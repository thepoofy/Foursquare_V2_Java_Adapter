package com.williamvanderhoef.foursquare.responses;

import com.williamvanderhoef.foursquare.types.Items;
import com.williamvanderhoef.foursquare.types.VenueWrapper;

/**
 * 
 * @author <a href="mailto://william.vanderhoef@gmail.com">William Vanderhoef</a>
 *
 */
public class UsersMayorshipsResponse
{
	private Items<VenueWrapper> mayorships;

	public Items<VenueWrapper> getMayorships()
	{
		return mayorships;
	}

	public void setMayorships(Items<VenueWrapper> mayorships)
	{
		this.mayorships = mayorships;
	}

	
}
