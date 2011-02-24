package com.williamvanderhoef.foursquare.adapters.users;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.williamvanderhoef.foursquare.adapters.EndpointAdapter;
import com.williamvanderhoef.foursquare.responses.UserCheckinsResponse;
import com.williamvanderhoef.foursquare.types.Results;

public class UserCheckinsEndpoint implements EndpointAdapter<UserCheckinsResponse>
{
	/*
	 * (non-Javadoc)
	 * @see com.williamvanderhoef.foursquare.adapters.EndpointAdapter#adapt(java.lang.String)
	 */
	@Override
	public Results<UserCheckinsResponse> adapt(String responseText)
	{
		Gson g = new Gson();
		
		Type resultsType = new TypeToken<Results<UserCheckinsResponse>>() {}.getType();
		
		return g.fromJson(responseText, resultsType);
	}

	
	
}
