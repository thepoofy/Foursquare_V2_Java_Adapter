package com.williamvanderhoef.foursquare.model.notification;


/**
 * com.williamvanderhoef.foursquare.model.notification.FoursquareObject is the base class for all Notification objects.
 * 
 */
public class Notification
{
	private FoursquareObject item;
	private String type;
	
	
	public FoursquareObject getItem() {
		return item;
	}
	public void setItem(FoursquareObject item) {
		this.item = item;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}

