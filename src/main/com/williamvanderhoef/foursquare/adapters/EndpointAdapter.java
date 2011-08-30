package com.williamvanderhoef.foursquare.adapters;

import java.lang.reflect.Type;

public abstract class EndpointAdapter<T>
{
//	private Gson g = new Gson();

	public abstract Type defineType();

//	/**
//	 *
//	 * @param responseText
//	 * @return
//	 */
//	public Results<T> adapt(String responseText){
//
//		return g.fromJson(responseText, defineType());
//	}
//
//	public Results<T> adapt(JsonElement responseElement){
//
//		return g.fromJson(responseElement, defineType());
//	}
}
