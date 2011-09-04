package com.williamvanderhoef.foursquare.model.notification;

import com.williamvanderhoef.foursquare.model.Tip;

public class TipAlertNotification extends Notification{

	private Tip tipAlert;

	public Tip getTip() {
		return tipAlert;
	}

	public void setTip(Tip tip) {
		this.tipAlert = tip;
	}
	
	
	
}
