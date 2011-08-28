package com.williamvanderhoef.foursquare.adapters.venues;

import java.lang.reflect.Type;

import com.google.gson.reflect.TypeToken;
import com.williamvanderhoef.foursquare.adapters.EndpointAdapter;
import com.williamvanderhoef.foursquare.responses.VenueSearchResponse;
import com.williamvanderhoef.foursquare.types.Results;

public class VenueSearchEndpoint extends EndpointAdapter<VenueSearchResponse>
{
	
	public Type defineType()
	{
		return new TypeToken<Results<VenueSearchResponse>>() {}.getType();
	}
}
