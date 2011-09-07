package com.williamvanderhoef.foursquare.responses;

import java.util.Map;

import com.williamvanderhoef.foursquare.model.Badge;
import com.williamvanderhoef.foursquare.model.subtypes.Groups;

public class UsersBadgesResponse implements GetResponseBase{

	//TODO add a type for grouped groups, these groups include ImageDefinitions and N nested groups.
	private Groups<String> sets;
	
	private Map<String, Badge> badges;

	public Groups<String> getSets() {
		return sets;
	}

	public void setSets(Groups<String> sets) {
		this.sets = sets;
	}

	public Map<String, Badge> getBadges() {
		return badges;
	}

	public void setBadges(Map<String, Badge> badges) {
		this.badges = badges;
	}
	
	
}
