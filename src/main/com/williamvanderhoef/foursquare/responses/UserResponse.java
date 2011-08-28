package com.williamvanderhoef.foursquare.responses;

import com.williamvanderhoef.foursquare.model.UserDetails;

public class UserResponse
{
	private UserDetails user;

	/**
	 * @return the user
	 */
	public UserDetails getUser()
	{
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(UserDetails user)
	{
		this.user = user;
	}
	
	
}
