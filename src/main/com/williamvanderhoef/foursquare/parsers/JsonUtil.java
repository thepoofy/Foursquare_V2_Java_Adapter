package com.williamvanderhoef.foursquare.parsers;

import com.williamvanderhoef.foursquare.model.subtypes.Results;
import com.williamvanderhoef.foursquare.parsers.JacksonResultsParser;
import com.williamvanderhoef.foursquare.parsers.ResultsParser;

public class JsonUtil {

	
	public static <T> ResultsParser<T> getParser(Results<T> adapter)
	{
		ResultsParser<T> parser = new JacksonResultsParser<T>(adapter);
		
		return parser;
	}
	
	public static <T> ResultsParser<T> getParser(Class<T> clazz)
	{
		ResultsParser<T> parser = new JacksonResultsParser<T>();
		
		return parser;
	}
}
