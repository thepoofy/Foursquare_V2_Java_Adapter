package com.williamvanderhoef.foursquare.responses;

import com.williamvanderhoef.foursquare.model.User;
import com.williamvanderhoef.foursquare.model.subtypes.Items;

/**
 * 
 * @author <a href="mailto://william.vanderhoef@gmail.com">William Vanderhoef</a>
 *
 */
public class UserFriendsResponse
{
	private Items<User> friends;

	/**
	 * @return the friends
	 */
	public Items<User> getFriends() {
		return friends;
	}

	/**
	 * @param friends the friends to set
	 */
	public void setFriends(Items<User> friends) {
		this.friends = friends;
	}
	
}
