package com.williamvanderhoef.foursquare.responses;

import java.util.List;

import com.williamvanderhoef.foursquare.model.Venue;
import com.williamvanderhoef.foursquare.types.Group;


public class VenueSearchResponse
{
	
	private List<Group<Venue>> groups;

	public List<Group<Venue>> getGroups()
	{
		return groups;
	}

	public void setGroups(List<Group<Venue>> groups)
	{
		this.groups = groups;
	}
}
