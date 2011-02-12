package com.williamvanderhoef.foursquare.types;

public class Friends
{
	private Items<User> friends;

	/**
	 * @return the friends
	 */
	public Items<User> getFriends()
	{
		return friends;
	}

	/**
	 * @param friends the friends to set
	 */
	public void setFriends(Items<User> friends)
	{
		this.friends = friends;
	}
	
	
}
