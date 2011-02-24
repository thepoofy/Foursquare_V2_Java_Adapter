package com.williamvanderhoef.foursquare.adapters.venues;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.williamvanderhoef.foursquare.adapters.EndpointAdapter;
import com.williamvanderhoef.foursquare.responses.VenueSearchResponse;
import com.williamvanderhoef.foursquare.types.Results;

public class VenueSearchEndpoint implements EndpointAdapter<VenueSearchResponse>
{

	@Override
	public Results<VenueSearchResponse> adapt(String responseText)
	{
		Type venueSearchResultsType = new TypeToken<Results<VenueSearchResponse>>() {}.getType();

		return new Gson().fromJson(responseText,venueSearchResultsType );
	}
	

}
