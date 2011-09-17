package com.williamvanderhoef.foursquare.model;

import java.util.List;

import com.williamvanderhoef.foursquare.model.subtypes.Unique;

public class FoursquareListItem extends Unique
{
	private User user;
	private Photo photo;
	private Venue venue;
	private Tip tip;
	private String note;
	private Long createdAt;
	private Boolean todo;
	private Boolean done;
	private Integer visitedCount;
	private List<FoursquareList> listed;
	/**
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
	/**
	 * @return the tip
	 */
	public Tip getTip()
	{
		return tip;
	}
	/**
	 * @param tip the tip to set
	 */
	public void setTip(Tip tip)
	{
		this.tip = tip;
	}
	/**
	 * @return the note
	 */
	public String getNote()
	{
		return note;
	}
	/**
	 * @param note the note to set
	 */
	public void setNote(String note)
	{
		this.note = note;
	}
	/**
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
	/**
	 * @return the todo
	 */
	public Boolean getTodo()
	{
		return todo;
	}
	/**
	 * @param todo the todo to set
	 */
	public void setTodo(Boolean todo)
	{
		this.todo = todo;
	}
	/**
	 * @return the done
	 */
	public Boolean getDone()
	{
		return done;
	}
	/**
	 * @param done the done to set
	 */
	public void setDone(Boolean done)
	{
		this.done = done;
	}
	/**
	 * @return the visitedCount
	 */
	public Integer getVisitedCount()
	{
		return visitedCount;
	}
	/**
	 * @param visitedCount the visitedCount to set
	 */
	public void setVisitedCount(Integer visitedCount)
	{
		this.visitedCount = visitedCount;
	}
	/**
	 * @return the listed
	 */
	public List<FoursquareList> getListed()
	{
		return listed;
	}
	/**
	 * @param listed the listed to set
	 */
	public void setListed(List<FoursquareList> listed)
	{
		this.listed = listed;
	}
	
	

}
