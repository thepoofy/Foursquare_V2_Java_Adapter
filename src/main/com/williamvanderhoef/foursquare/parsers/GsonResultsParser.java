package com.williamvanderhoef.foursquare.parsers;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.williamvanderhoef.foursquare.adapters.DefinedType;
import com.williamvanderhoef.foursquare.model.notification.Notification;
import com.williamvanderhoef.foursquare.model.notification.Notifications;
import com.williamvanderhoef.foursquare.model.subtypes.Results;


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
			.create();
	}
	
	public Results<T> parse(String fileContents) throws Exception
	{
		return g.fromJson(fileContents, adapter.defineType());
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
	
	class FoursquareObjectDeserializer implements JsonDeserializer<Notifications>
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
}
