package com.williamvanderhoef.foursquare.parsers;

import java.lang.reflect.Type;

import com.williamvanderhoef.foursquare.adapters.JsonSyntaxException;
import com.williamvanderhoef.foursquare.model.subtypes.Results;


public interface ResultsParser<T> {

	/**
	 * 
	 * @param fileContents
	 * @return
	 * @throws JsonSyntaxException
	 */
	public Results<T> fromJson(String fileContents) throws JsonSyntaxException;
	
	/**
	 * 
	 * 
	 * @param object
	 * @return
	 * @throws JsonSyntaxException
	 */
	public String toJson(Object object) throws JsonSyntaxException;
	
	/**
	 * 
	 * @param json
	 * @param t
	 * @return
	 * @throws JsonSyntaxException
	 */
	public T simpleFromJson(String json, Type t)throws JsonSyntaxException;
	
}
