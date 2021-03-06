package com.williamvanderhoef.foursquare.parsers;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.williamvanderhoef.foursquare.adapters.DefinedType;
import com.williamvanderhoef.foursquare.adapters.JsonSyntaxException;
import com.williamvanderhoef.foursquare.model.notification.Notification;
import com.williamvanderhoef.foursquare.model.notification.Notifications;
import com.williamvanderhoef.foursquare.model.subtypes.Results;
import com.williamvanderhoef.foursquare.responses.Responses;

/**
 * Copyright (c) 2011 William Vanderhoef
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 * 
 * 
 * @param <T>
 */
public class GsonResultsParser<T> implements ResultsParser<T> {

	private DefinedType adapter;
	private final Gson g;
	
	/**
	 * 
	 * @param adapter
	 */
	public GsonResultsParser(DefinedType adapter){
		
		this.adapter = adapter;
		
		g = new GsonBuilder()
			.setFieldNamingStrategy(new FoursquareFieldNamingStrategy())
			.registerTypeHierarchyAdapter(Notifications.class, buildDeserializer())
			.registerTypeHierarchyAdapter(Responses.class, new FoursquareResponsesDeserializer())
			.create();
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.williamvanderhoef.foursquare.parsers.ResultsParser#fromJson(java.lang.String)
	 */
	public Results<T> fromJson(String fileContents) throws JsonSyntaxException
	{
		try{
			return g.fromJson(fileContents, adapter.defineType());	
		}
		catch(com.google.gson.JsonSyntaxException jse)
		{
			throw new JsonSyntaxException(jse);
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.williamvanderhoef.foursquare.parsers.ResultsParser#simpleFromJson(java.lang.String, java.lang.reflect.Type)
	 */
	@Override
	public T simpleFromJson(String json, Type t) throws JsonSyntaxException {

		try{
			return g.fromJson(json, t);	
		}
		catch(com.google.gson.JsonSyntaxException jse)
		{
			throw new JsonSyntaxException(jse);
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.williamvanderhoef.foursquare.parsers.ResultsParser#toJson(com.williamvanderhoef.foursquare.model.subtypes.Results)
	 */
	public String toJson(Object results) throws JsonSyntaxException
	{
		try
		{
			return g.toJson(results);
		}
		catch(com.google.gson.JsonSyntaxException jse)
		{
			throw new JsonSyntaxException(jse);
		}
	}

	private class FoursquareFieldNamingStrategy implements FieldNamingStrategy{
		public String translateName(Field f)
		{
			if("public".equals(f.getName()))
			{
				return "_public";
			}
			if("private".equals(f.getName()))
			{
				return "_private";
			}
			
			return f.getName();
		}
	}
	
	private FoursquareObjectDeserializer buildDeserializer()
	{
		FoursquareObjectDeserializer deserializer = new FoursquareObjectDeserializer();
		
		//specify a unique class attribute and the class that it is unique for
		for(Notifications.NotificationType type: Notifications.NotificationType.values())
		{
			deserializer.registerType(type.name(),type.getTypeOf());
		}
		
		return deserializer;
	}
	
	private class FoursquareObjectDeserializer implements JsonDeserializer<Notifications>
	{
		private Map<String, Class<? extends Notification>> registry = new HashMap<String, Class<? extends Notification>>();

		/**
		 * 
		 * @param uniqueAttribute
		 * @param notificationClass
		 */
		public void registerType(String uniqueAttribute, Class<? extends Notification> notificationClass) 
		{
			registry.put(uniqueAttribute, notificationClass);
		}
		
		/*
		 * (non-Javadoc)
		 * @see com.google.gson.JsonDeserializer#deserialize(com.google.gson.JsonElement, java.lang.reflect.Type, com.google.gson.JsonDeserializationContext)
		 */
		@Override
		public Notifications deserialize(JsonElement json, Type typeOf,
				JsonDeserializationContext context) throws JsonParseException 
		{
			JsonObject fsqObject = json.getAsJsonObject();
			
			if(fsqObject.has("item") 
					&& fsqObject.has("type")
					&& registry.get(fsqObject.get("type").getAsString()) != null)
			{
				String type = fsqObject.get("type").getAsString();
				
				Class<? extends Notification> instanceClass = registry.get(type);
				Gson g = new Gson();
				Notification n = g.fromJson(fsqObject.get("item"), instanceClass);
				
				Notifications notifications = new Notifications();
				notifications.setType(type);
				notifications.setItem(n);
				
				return notifications;
			}
			
			return null;
		}
		
	}
	
	private class FoursquareResponsesDeserializer implements JsonDeserializer<Responses>
	{
		/*
		 * (non-Javadoc)
		 * @see com.google.gson.JsonDeserializer#deserialize(com.google.gson.JsonElement, java.lang.reflect.Type, com.google.gson.JsonDeserializationContext)
		 */
		@Override
		public Responses deserialize(JsonElement json, Type typeOf,
				JsonDeserializationContext context) throws JsonParseException 
		{
			JsonObject fsqObject = json.getAsJsonObject();
			
			if(fsqObject.has("responses") 
					&& fsqObject.get("responses").getAsJsonArray() != null)
			{
				JsonArray responses = fsqObject.get("responses").getAsJsonArray();
				
				List<String> res = new ArrayList<String>();
				
				for(JsonElement ele : responses)
				{
					res.add(ele.toString());
				}
				
				Responses myResponses = new Responses();
				myResponses.setResponses(res);
				
				return myResponses;
			}
			
			return null;
		}
		
	}
}
