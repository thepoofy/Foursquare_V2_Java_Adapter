package com.williamvanderhoef.foursquare.model.notification;

import com.williamvanderhoef.foursquare.model.Badge;

public class BadgeNotification extends Notification{

	private Badge badge;

	public Badge getBadge() {
		return badge;
	}

	public void setBadge(Badge badge) {
		this.badge = badge;
	}
	
}
