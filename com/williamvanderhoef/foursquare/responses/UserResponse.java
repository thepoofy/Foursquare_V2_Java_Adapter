package com.williamvanderhoef.foursquare.responses;

import com.williamvanderhoef.foursquare.types.UserDetail;

public class UserResponse
{
	private UserDetail user;

	/**
	 * @return the user
	 */
	public UserDetail getUser()
	{
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(UserDetail user)
	{
		this.user = user;
	}
	
	
}
