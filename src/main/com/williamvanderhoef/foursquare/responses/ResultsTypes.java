package com.williamvanderhoef.foursquare.responses;

import com.williamvanderhoef.foursquare.model.subtypes.Results;

/**
 * 
 * 
 * @author williamvanderhoef
 *
 */
public class ResultsTypes
{
	public static class UserResults extends Results<UserResponse>{}
	
	public static class UserBadgesResults extends Results<UserBadgesResponse>{}

	public static class UserCheckinsResults extends Results<UserCheckinsResponse>{}
	
	public static class UsersBadgesResults extends Results<UserBadgesResponse>{}
	
	public static class UsersListsResults extends Results<UserListsResponse>{}
	
	public static class UsersMayorshipsResults extends Results<UserMayorshipsResponse>{}
	

	
	public static class VenueSearchResults extends Results<VenueSearchResponse>{}

}
