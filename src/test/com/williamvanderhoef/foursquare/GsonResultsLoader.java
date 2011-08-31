package com.williamvanderhoef.foursquare;

import com.google.gson.Gson;
import com.williamvanderhoef.foursquare.adapters.EndpointAdapter;
import com.williamvanderhoef.foursquare.types.Results;


public class GsonResultsLoader<T> implements ResultsLoader<T> {

	private EndpointAdapter adapter;
	private final Gson g = new Gson();
	
	public GsonResultsLoader(EndpointAdapter adapter) {
		
		this.adapter = adapter;
		
		
	}
	
	public Results<T> parse(String fileContents) throws Exception
	{
		return g.fromJson(fileContents, adapter.defineType());
	}

}
