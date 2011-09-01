package com.williamvanderhoef.foursquare;

import java.lang.reflect.Field;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.williamvanderhoef.foursquare.adapters.EndpointAdapter;
import com.williamvanderhoef.foursquare.types.Results;


public class GsonResultsLoader<T> implements ResultsLoader<T> {

	@SuppressWarnings({ "rawtypes" })
	private EndpointAdapter adapter;
	private final Gson g;
	
	/**
	 * 
	 * @param adapter
	 */
	@SuppressWarnings({ "rawtypes" })	//the EndpointAdapter type doesn't matter, it's getType() is defines the java.lang.reflect.Type
	public GsonResultsLoader(EndpointAdapter adapter) {
		
		this.adapter = adapter;
		
		g = new GsonBuilder()
			.setFieldNamingStrategy(new FoursquareFieldNamingStrategy())
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
}
