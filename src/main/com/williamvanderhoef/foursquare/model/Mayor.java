package com.williamvanderhoef.foursquare.model;

import com.williamvanderhoef.foursquare.model.subtypes.Count;

public class Mayor extends Count
{
	/**
	 * The compact user who is the mayor (absent if there is no mayor)
	 */
	private User user;
	
	/**
	 * @return the user
	 */
	public User getUser()
	{
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user)
	{
		this.user = user;
	}

}
