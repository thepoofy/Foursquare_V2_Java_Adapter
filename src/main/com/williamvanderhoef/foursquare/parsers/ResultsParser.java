package com.williamvanderhoef.foursquare.parsers;

import com.williamvanderhoef.foursquare.adapters.JsonSyntaxException;
import com.williamvanderhoef.foursquare.model.subtypes.Results;


public interface ResultsParser<T> {

	public Results<T> parse(String fileContents) throws JsonSyntaxException;
}
