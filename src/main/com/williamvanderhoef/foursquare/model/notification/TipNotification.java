package com.williamvanderhoef.foursquare.model.notification;

import com.williamvanderhoef.foursquare.model.Tip;

public class TipNotification extends Notification {

	private Tip tip;

	public Tip getTip() {
		return tip;
	}

	public void setTip(Tip tip) {
		this.tip = tip;
	}
	
	
	
}
