package com.williamvanderhoef.foursquare.parsers;

import com.williamvanderhoef.foursquare.types.Results;


public interface ResultsParser<T> {

	public Results<T> parse(String fileContents) throws Exception;
}
