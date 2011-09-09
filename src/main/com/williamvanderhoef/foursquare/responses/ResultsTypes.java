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
	public static class VenueSearchResults extends Results<VenueSearchResponse>{}
//	public static VenueSearchResults buildVenueSearchResults(){
//		return new VenueSearchResults();
//	}

	public static class UserResults extends Results<UserResponse>{}
//	public static UserResults buildUserResults(){
//		return new UserResults();
//	}
	
	public static class UsersBadgesResults extends Results<UsersBadgesResponse>{}
//	public static UsersBadgesResults buildUsersBadgesResults(){
//		return new UsersBadgesResults();
//	}
}
