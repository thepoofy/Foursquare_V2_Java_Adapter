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
import com.williamvanderhoef.foursquare.adapters.EndpointAdapter;
import com.williamvanderhoef.foursquare.model.notification.FoursquareObject;
import com.williamvanderhoef.foursquare.model.notification.NotificationTray;
import com.williamvanderhoef.foursquare.types.Results;


public class GsonResultsParser<T> implements ResultsParser<T> {

	@SuppressWarnings({ "rawtypes" })
	private EndpointAdapter adapter;
	private final Gson g;
	
	/**
	 * 
	 * @param adapter
	 */
	@SuppressWarnings({ "rawtypes" })	//the EndpointAdapter type doesn't matter, it's getType() is defines the java.lang.reflect.Type
	public GsonResultsParser(EndpointAdapter adapter) {
		
		this.adapter = adapter;
		
		g = new GsonBuilder()
			.setFieldNamingStrategy(new FoursquareFieldNamingStrategy())
			.registerTypeHierarchyAdapter(FoursquareObject.class, buildDeserializer())
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
		FoursquareObjectDeserializer fod = new FoursquareObjectDeserializer();
		
		//specify a unique class attribute and the class that it is unique for
		fod.registerType("unreadCount",NotificationTray.class);
		
		return fod;
	}
	
	class FoursquareObjectDeserializer implements JsonDeserializer<FoursquareObject>
	{
		private Map<String, Class<? extends FoursquareObject>> registry = new HashMap<String, Class<? extends FoursquareObject>>();

		/**
		 * 
		 * @param uniqueAttribute
		 * @param animalClass
		 */
		public void registerType(String uniqueAttribute, Class<? extends FoursquareObject> animalClass) 
		{
			registry.put(uniqueAttribute, animalClass);
		}
		
		/*
		 * (non-Javadoc)
		 * @see com.google.gson.JsonDeserializer#deserialize(com.google.gson.JsonElement, java.lang.reflect.Type, com.google.gson.JsonDeserializationContext)
		 */
		@Override
		public FoursquareObject deserialize(JsonElement json, Type typeOf,
				JsonDeserializationContext context) throws JsonParseException 
		{
			JsonObject fsqObject = json.getAsJsonObject();
			
			for(String memberName: registry.keySet())
			{
				if(fsqObject.has(memberName))
				{
					Class<? extends FoursquareObject> instanceClass = registry.get(memberName);
					
					Gson g = new Gson();
					return g.fromJson(fsqObject, instanceClass);
				}
			}
			
			return null;
		}
		
	}
}
