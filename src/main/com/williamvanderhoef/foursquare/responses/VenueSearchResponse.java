package com.williamvanderhoef.foursquare.responses;

import java.util.List;

import com.williamvanderhoef.foursquare.model.Venue;


public class VenueSearchResponse
{
	
	private List<Venue> venues;

	public List<Venue> getVenues() {
		return venues;
	}

	public void setVenues(List<Venue> venues) {
		this.venues = venues;
	}

	
}
