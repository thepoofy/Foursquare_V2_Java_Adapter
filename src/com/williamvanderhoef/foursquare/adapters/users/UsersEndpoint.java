package com.williamvanderhoef.foursquare.adapters.users;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.williamvanderhoef.foursquare.adapters.EndpointAdapter;
import com.williamvanderhoef.foursquare.responses.UserResponse;
import com.williamvanderhoef.foursquare.types.Results;

public class UsersEndpoint implements EndpointAdapter<UserResponse>
{
	/*
	 * (non-Javadoc)
	 * @see com.williamvanderhoef.foursquare.adapters.EndpointAdapter#adapt(java.lang.String)
	 */
	@Override
	public Results<UserResponse> adapt(String responseText)
	{
		Gson g = new Gson();
		
		Type userDetailResultsType = new TypeToken<Results<UserResponse>>() {}.getType();
		
		return g.fromJson(responseText, userDetailResultsType);
	}	
}
