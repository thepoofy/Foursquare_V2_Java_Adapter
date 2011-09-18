package com.williamvanderhoef.foursquare.responses;


import com.williamvanderhoef.foursquare.model.FoursquareList;
import com.williamvanderhoef.foursquare.model.subtypes.Items;

/**
 * Example found at http://developer.foursquare.com/docs/explore.html#req=venues/trending%3Fll%3D40.7,-74
 * 
 * @author <a href="mailto://william.vanderhoef@gmail.com">William Vanderhoef</a>
 *
 */
public class UserListsGroupResponse implements ResponseBase
{
	private Items<FoursquareList> lists;

	public Items<FoursquareList> getLists() {
		return lists;
	}

	public void setLists(Items<FoursquareList> lists) {
		this.lists = lists;
	}
	
	
}
