package com.williamvanderhoef.foursquare.responses;

import com.williamvanderhoef.foursquare.model.Checkin;
import com.williamvanderhoef.foursquare.model.subtypes.Items;

public class UserCheckinsResponse
{
	//checkins contains a list of Checkin and a count
	private Items<Checkin> checkins;
	
	
	public Items<Checkin> getCheckins()
	{
		return checkins;
	}

	public void setCheckins(Items<Checkin> checkins)
	{
		this.checkins = checkins;
	}

	
}
