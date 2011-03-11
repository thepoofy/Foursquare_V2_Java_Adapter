package com.williamvanderhoef.foursquare.responses;

import java.util.List;

import com.williamvanderhoef.foursquare.types.Venue;

/**
 * Example found at http://developer.foursquare.com/docs/explore.html#req=venues/trending%3Fll%3D40.7,-74
 * 
 * @author <a href="mailto://william.vanderhoef@gmail.com">William Vanderhoef</a>
 *
 */
public class VenueTrendingResponse
{
	
	private List<Venue> venues;

	public List<Venue> getVenues()
	{
		return venues;
	}

	public void setVenues(List<Venue> venues)
	{
		this.venues = venues;
	}

	
}
