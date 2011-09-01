package com.williamvanderhoef.foursquare.responses;


import com.williamvanderhoef.foursquare.model.FoursquareList;
import com.williamvanderhoef.foursquare.types.Groups;

/**
 * Example found at http://developer.foursquare.com/docs/explore.html#req=venues/trending%3Fll%3D40.7,-74
 * 
 * @author <a href="mailto://william.vanderhoef@gmail.com">William Vanderhoef</a>
 *
 */
public class UsersListsResponse
{
	private Groups<FoursquareList> lists;

	public Groups<FoursquareList> getLists() {
		return lists;
	}

	public void setLists(Groups<FoursquareList> lists) {
		this.lists = lists;
	}

	
	
}
