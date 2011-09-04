package com.williamvanderhoef.foursquare.model.notification;


/**
 * TODO This class is not yet implemented and only returned by the checkins/add endpoint
 * 
 * 
 * @author <a href="mailto://william.vanderhoef@gmail.com">William Vanderhoef</a>
 *
 */
public class Message extends Notification
{
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
