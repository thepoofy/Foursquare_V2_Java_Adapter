package com.williamvanderhoef.foursquare.responses;

import com.williamvanderhoef.foursquare.model.VenueHistory;
import com.williamvanderhoef.foursquare.types.Items;

/**
 * Example found at https://developer.foursquare.com/docs/explore.html#req=users/self/venuehistory
 * 
 * @author <a href="mailto://william.vanderhoef@gmail.com">William Vanderhoef</a>
 *
 */
public class VenueTrendingResponse
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
