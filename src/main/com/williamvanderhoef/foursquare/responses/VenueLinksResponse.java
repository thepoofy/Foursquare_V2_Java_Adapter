package com.williamvanderhoef.foursquare.responses;

import com.williamvanderhoef.foursquare.model.VenueExternalLink;
import com.williamvanderhoef.foursquare.model.subtypes.Items;


public class VenueLinksResponse
{
	
	private Items<VenueExternalLink> links;

	public Items<VenueExternalLink> getLinks() {
		return links;
	}

	public void setLinks(Items<VenueExternalLink> venues) {
		this.links = venues;
	}

	
}
