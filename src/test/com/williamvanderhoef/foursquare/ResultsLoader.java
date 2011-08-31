package com.williamvanderhoef.foursquare;

import com.williamvanderhoef.foursquare.types.Results;


public interface ResultsLoader<T> {

	public Results<T> parse(String fileContents) throws Exception;
}
