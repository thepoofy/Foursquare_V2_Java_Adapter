package com.williamvanderhoef.foursquare.responses;

import com.williamvanderhoef.foursquare.model.VenueHistory;
import com.williamvanderhoef.foursquare.types.Items;

/**
 * Example found at http://developer.foursquare.com/docs/explore.html#req=venues/trending%3Fll%3D40.7,-74
 * 
 * @author <a href="mailto://william.vanderhoef@gmail.com">William Vanderhoef</a>
 *
 */
public class UsersVenueHistoryResponse
{
	private Items<VenueHistory> venues;

	public Items<VenueHistory> getVenues()
	{
		return venues;
	}

	public void setVenues(Items<VenueHistory> venues)
	{
		this.venues = venues;
	}

	
}
