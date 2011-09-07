package com.williamvanderhoef.foursquare.model;

import com.williamvanderhoef.foursquare.model.subtypes.Unique;

public class Event extends Unique{

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
