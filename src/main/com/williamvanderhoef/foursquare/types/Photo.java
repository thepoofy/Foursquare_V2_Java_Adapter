package com.williamvanderhoef.foursquare.types;

import com.williamvanderhoef.foursquare.model.Checkin;
import com.williamvanderhoef.foursquare.model.Tip;
import com.williamvanderhoef.foursquare.model.User;
import com.williamvanderhoef.foursquare.model.Venue;

/**
 * @see http://developer.foursquare.com/docs/responses/photo.html
 * @author William Vanderhoef william.vanderhoef@gmail.com
 * 
 */
public class Photo extends Unique
{
	/**
	 * Seconds since epoch when this photo was created.
	 */
	private Long createdAt;
	/**
	 * The url for the original uploaded file.
	 */
	private String url;
	/**
	 * The count of supported sizes, plus items, an array of supported sizes. 
	 * Each size will have a string url and integer width and height parameters. 
	 * The first item will be the original photo size, and the remaining items will be derived photo sizes. 
	 * Just because a derived photo size (with url) is returned does not mean it is necessarily available at that url. 
	 */
	private Items<Size> sizes;
	/**
	 * optional 
	 * If present, the name and url for the application that created this photo.
	 */
	private Source source;
	/**
	 * optional 
	 * If the user is not clear from context, then a compact user is present.
	 */
	private User user;
	
	/**
	 * optional 
	 * If the venue is not clear from context, then a compact venue is present.
	 */
	private Venue venue;
	
	/**
	 * 	optional 
	 * If the tip is not clear from context, then a compact tip is present.
	 */
	private Tip tip;
	/**
	 * optional 
	 * If the checkin is not clear from context, then a compact checkin is present.
	 */
	private Checkin checkin;
	
	
	
	
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
	 * @return the url
	 */
	public String getUrl()
	{
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url)
	{
		this.url = url;
	}
	/**
	 * @return the sizes
	 */
	public Items<Size> getSizes()
	{
		return sizes;
	}
	/**
	 * @param sizes the sizes to set
	 */
	public void setSizes(Items<Size> sizes)
	{
		this.sizes = sizes;
	}
	/**
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
	
	
	
	public Venue getVenue() {
		return venue;
	}
	public void setVenue(Venue venue) {
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
	 * @return the checkin
	 */
	public Checkin getCheckin()
	{
		return checkin;
	}
	/**
	 * @param checkin the checkin to set
	 */
	public void setCheckin(Checkin checkin)
	{
		this.checkin = checkin;
	}

}
