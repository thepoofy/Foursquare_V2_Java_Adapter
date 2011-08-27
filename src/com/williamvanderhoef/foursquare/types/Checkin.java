package com.williamvanderhoef.foursquare.types;

/**
 * 
 * As defined on <a href="http://developer.foursquare.com/docs/responses/checkin.html">Foursquare Developers - Checkin Response</a>
 * 
 * @author <a href="mailto://william.vanderhoef@gmail.com">William Vanderhoef</a>
 *
 */
public class Checkin extends Unique
{
	private String type;
	private Boolean isPrivate;	//FIXME may require custom deserializer to load this value 
	private User user;
	private String timeZone;	//timeZone in use where the checkin occurred.
	private Venue venue;
	private LocationCompact location;	//alternative to venue when Venue not present 
	private String shout;
	private Long createdAt;
	private Source source;
	private Items<Photo> photos;
	private Items<Object> comments;		//FIXME add Comment Object once it is defined by foursquare
	
	
	
	/**
	 * One of checkin, shout, or venueless.
	 * @return the type
	 */
	public String getType()
	{
		return type;
	}
	/**
	 * optional
	 * If present, it indicates the checkin was marked as private and not sent to friends. 
	 * It is only being returned because the owner of the checkin is viewing this data.
	 * 
	 * @param type the type to set
	 */
	public void setType(String type)
	{
		this.type = type;
	}
	/**
	 * optional 
	 * If the user is not clear from context, then a compact user is present.
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
	 * String representation of the time zone where this check-in occurred.
	 * @return the timeZone
	 */
	public String getTimeZone()
	{
		return timeZone;
	}
	/**
	 * @param timeZone the timeZone to set
	 */
	public void setTimeZone(String timeZone)
	{
		this.timeZone = timeZone;
	}
	/**
	 * optional 
	 * If the venue is not clear from context, and this checkin was at a venue, then a compact venue is present.
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
	 * optional
	 * If the type of this checkin is shout or venueless, this field may be present and may contains a lat, lng pair and/or a name, providing unstructured information about the user's current location.
	 * @return the location
	 */
	public LocationCompact getLocation()
	{
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(LocationCompact location)
	{
		this.location = location;
	}
	/**
	 * 	optional 
	 * Message from check-in, if present and visible to the acting user.
	 * @return the shout
	 */
	public String getShout()
	{
		return shout;
	}
	/**
	 * @param shout the shout to set
	 */
	public void setShout(String shout)
	{
		this.shout = shout;
	}
	/**
	 * SECONDS since epoch when this checkin was created.
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
	 * 	optional 
	 * If present, the name and url for the application that created this checkin.
	 * @return the source
	 */
	public Source getSource()
	{
		return source;
	}
	/**
	 * @param source the source to set
	 */
	public void setSource(Source source)
	{
		this.source = source;
	}
	/**
	 * count and items for photos on this checkin. 
	 * All items may not be present.
	 * @return the photos
	 */
	public Items<Photo> getPhotos()
	{
		return photos;
	}
	/**
	 * @param photos the photos to set
	 */
	public void setPhotos(Items<Photo> photos)
	{
		this.photos = photos;
	}
	/**
	 * count and items for comments on this checkin. 
	 * All items may not be present.
	 * 
	 * @return the comments
	 */
	public Items<Object> getComments()
	{
		return comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(Items<Object> comments)
	{
		this.comments = comments;
	}

	public Boolean getIsPrivate()
	{
		return isPrivate;
	}
	public void setIsPrivate(Boolean isPrivate)
	{
		this.isPrivate = isPrivate;
	}
	
	
	
}
