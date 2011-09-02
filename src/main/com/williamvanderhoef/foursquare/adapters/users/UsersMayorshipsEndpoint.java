package com.williamvanderhoef.foursquare.adapters.users;

import java.lang.reflect.Type;

import com.google.gson.reflect.TypeToken;
import com.williamvanderhoef.foursquare.adapters.EndpointAdapter;
import com.williamvanderhoef.foursquare.responses.UsersListsResponse;
import com.williamvanderhoef.foursquare.responses.UsersMayorshipsResponse;
import com.williamvanderhoef.foursquare.types.Results;

public class UsersMayorshipsEndpoint extends EndpointAdapter<UsersListsResponse>
{
	public Type defineType()
	{
		return new TypeToken<Results<UsersMayorshipsResponse>>() {}.getType();
	}
}
