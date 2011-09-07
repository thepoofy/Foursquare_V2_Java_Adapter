package com.williamvanderhoef.foursquare.adapters;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @deprecated
 * @author Willum
 *
 * @param <T>
 */
@Deprecated
public abstract class EndpointAdapter<T>
{
//	private Gson g = new Gson();

//	public abstract Type defineType();

	public Type defineType(){
		
		Type type = this.getClass().getGenericSuperclass();
		ParameterizedType paramType = (ParameterizedType)type;
		
//		return paramType;	//this will 
		return (Class<T>) paramType.getActualTypeArguments()[0];
			
//		return ((Class) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]).getClass();
	}
	
	


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
