package com.williamvanderhoef.foursquare.adapters;

import com.williamvanderhoef.foursquare.types.Results;

public interface EndpointAdapter<T>
{
	/**
	 * 
	 * @param responseText
	 * @return
	 */
	public Results<T> adapt(String responseText);
}
