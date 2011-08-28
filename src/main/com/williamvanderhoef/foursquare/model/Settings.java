package com.williamvanderhoef.foursquare.model;

public class Settings {

	private Boolean sendToTwitter;
	private Boolean sendToFacebook;
	private Boolean pings;
	
	
	public Boolean getSendToTwitter() {
		return sendToTwitter;
	}
	public void setSendToTwitter(Boolean sendToTwitter) {
		this.sendToTwitter = sendToTwitter;
	}
	public Boolean getSendToFacebook() {
		return sendToFacebook;
	}
	public void setSendToFacebook(Boolean sendToFacebook) {
		this.sendToFacebook = sendToFacebook;
	}
	public Boolean getPings() {
		return pings;
	}
	public void setPings(Boolean pings) {
		this.pings = pings;
	}
	
	
}
