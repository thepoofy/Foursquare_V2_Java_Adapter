package com.williamvanderhoef.foursquare.model.notification;

import com.williamvanderhoef.foursquare.model.User;


/**
 * This class is not yet implemented and only returned by the checkins/add endpoint
 * 
 * 
 * @author <a href="mailto://william.vanderhoef@gmail.com">William Vanderhoef</a>
 *
 */
public class Mayorship extends Notification
{
	private String type;
	private Integer checkins; //the number of checkins the user has had in the past 60 days
	private Integer daysBehind;
	
	private User user;
	
	private String message;
	private String image;
	
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getCheckins() {
		return checkins;
	}
	public void setCheckins(Integer checkins) {
		this.checkins = checkins;
	}
	public Integer getDaysBehind() {
		return daysBehind;
	}
	public void setDaysBehind(Integer daysBehind) {
		this.daysBehind = daysBehind;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	

}
