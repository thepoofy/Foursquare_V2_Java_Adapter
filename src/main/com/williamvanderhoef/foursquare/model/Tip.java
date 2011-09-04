package com.williamvanderhoef.foursquare.model;

import com.williamvanderhoef.foursquare.types.Count;
import com.williamvanderhoef.foursquare.types.Unique;

/**
 * As documented on <a href="http://developer.foursquare.com/docs/responses/tip.html">Foursquare Developers - Tip</a>
 * 
 * @author <a href="mailto://william.vanderhoef@gmail.com">William Vanderhoef</a>
 *
 */
public class Tip extends Unique
{
	private Long createdAt;
	private String text;
	
	/**
	 * optional A URL for more information.
	 */
	private String url;
	/**
	 * optional One of todo or done, depending on the user's relationship to the tip. Absent if there is no relationship
	 */
	private String status;

	/**
	 * optional If there is a photo for this tip and the tip is not already container inside of a photo element, details about the photo.
	 */
	private Photo photo;
	
	/**
	 * optional If the context allows tips from multiple users, the compact user that created this tip.
	 */
	private User user;
	
	/**
	 * optional If the context allows tips from multiple venues, the compact venue for this tip.
	 */
	private Venue venue;
	
	//TODO move todo and done to details object
	//TODO see if todo and done are actually Groups<User>
	/**
	 * The count of users who have marked this tip todo, and  groups containing any friends who have marked it to-do. 
	 * The groups included are subject to change. (Note that to-dos are only visible to friends!)
	 */
	private Count todo;	
	/**
	 * The count of users who have done this tip todo, and  groups containing any friends and others who have marked it done. 
	 * The groups included are subject to change.
	 */
	private Count done;
	
	
	
	
	
	
	/**
	 * The actual tip.
	 * @return the text
	 */
	public String getText()
	{
		return text;
	}
	/**
	 * @param text the text to set
	 */
	public void setText(String text)
	{
		this.text = text;
	}
	/**
	 * Seconds since epoch when their tip was created.
	 * @return the createdAt
	 */
	public Long getCreatedAt()
	{
		return createdAt;
	}
	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Long createdAt)
	{
		this.createdAt = createdAt;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	
	/**
	 * optional
	 * One of todo or done, depending on the user's relationship to the tip. 
	 * Absent if there is no relationship.
	 * @return the status
	 */
	public String getStatus()
	{
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status)
	{
		this.status = status;
	}
	/**
	 * optional 
	 * If there is a photo for this tip and the tip is not already container inside of a photo element, details about the photo.
	 * @return the photo
	 */
	public Photo getPhoto()
	{
		return photo;
	}
	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(Photo photo)
	{
		this.photo = photo;
	}
	/**
	 * optional 
	 * If the context allows tips from multiple users, the compact user that created this tip.
	 * @return the user
	 */
	public User getUser()
	{
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user)
	{
		this.user = user;
	}
	/**
	 * optional 
	 * If the context allows tips from multiple venues, the compact venue for this tip.
	 * @return the venue
	 */
	public Venue getVenue()
	{
		return venue;
	}
	/**
	 * @param venue the venue to set
	 */
	public void setVenue(Venue venue)
	{
		this.venue = venue;
	}
	public Count getTodo() {
		return todo;
	}
	public void setTodo(Count todo) {
		this.todo = todo;
	}
	public Count getDone() {
		return done;
	}
	public void setDone(Count done) {
		this.done = done;
	}

	
}
