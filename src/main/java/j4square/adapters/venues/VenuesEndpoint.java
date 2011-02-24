package com.williamvanderhoef.foursquare.adapters.venues;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.williamvanderhoef.foursquare.adapters.EndpointAdapter;
import com.williamvanderhoef.foursquare.responses.VenueResponse;
import com.williamvanderhoef.foursquare.types.Results;
import com.williamvanderhoef.foursquare.types.VenueDetails;

public class VenuesEndpoint implements EndpointAdapter<VenueDetails>
{

	@Override
	public Results<VenueDetails> adapt(String responseText)
	{
		Type venueDetailResultsType = new TypeToken<Results<VenueResponse>>() {}.getType();

		return new Gson().fromJson(responseText,venueDetailResultsType );
		
	}
	

}
