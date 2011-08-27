package com.williamvanderhoef.foursquare.adapters.users;

import java.lang.reflect.Type;

import com.google.gson.reflect.TypeToken;
import com.williamvanderhoef.foursquare.adapters.EndpointAdapter;
import com.williamvanderhoef.foursquare.responses.UsersVenueHistoryResponse;
import com.williamvanderhoef.foursquare.types.Results;

public class UsersVenueHistoryEndpoint extends EndpointAdapter<UsersVenueHistoryResponse>
{
	public Type defineType()
	{
		return new TypeToken<Results<UsersVenueHistoryResponse>>() {}.getType();
	}
	
	
}
