package com.williamvanderhoef.foursquare.responses;

import com.williamvanderhoef.foursquare.model.subtypes.Items;
import com.williamvanderhoef.foursquare.model.subtypes.VenueWrapper;

/**
 * 
 * @author <a href="mailto://william.vanderhoef@gmail.com">William Vanderhoef</a>
 *
 */
public class UserMayorshipsResponse
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
