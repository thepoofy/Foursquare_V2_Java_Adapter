package com.williamvanderhoef.foursquare.types;

import java.util.List;


/**
 * 
 * @see http://developer.foursquare.com/docs/responses/venue.html
 * @author William Vanderhoef william.vanderhoef@gmail.com
 *
 */
public class Venue extends Unique
{
	/**
	 * The best known name for this venue.
	 */
	private String name;
	
	/**
	 * 	Boolean indicating whether the owner of this business has claimed it and verified the information.
	 */
	private Boolean verified;
	
	/**
	 * An object containing none, some, or all of twitter and phone. Both are strings.
	 */
	private Contact contact;
	
	/**
	 * An object containing none, some, or all of address (street address), crossStreet, city, state, postalCode, country, lat, lng, and distance. 
	 * All fields are strings, except for geolat, geolong, and distance. 
	 */
	private LocationDetails location;
	
	/**
	 * 	An array, possibly empty, of categories that have been applied to this venue. 
	 * One of the categories will have a field primary indicating that it is the primary category for the venue. 
	 * All categories will have a string id, icon URL, and parents (an array of parent category names in increasing specificity). 
	 * For the complete set of categories, See Category. TODO broken link
	 * 
	 * @see com.williamvanderhoef.foursquare.types.Category
	 */
	private List<Category> categories;
	
	/**
	 * Optional. 
	 * If present, an array, possibly empty, of specials at this venue. 
	 */
	private List<Special> specials;
	
	/**
	 * Optional. 
	 * Information about who is here now. If present, there is always a count, the number of people here. 
	 * If viewing details and there is a logged-in user, there is also a groups field with friends and others as types. 
	 */
	private Groups<Checkin> hereNow;	
	
	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	/**
	 * @return the verified
	 */
	public Boolean getVerified()
	{
		return verified;
	}
	/**
	 * @param verified the verified to set
	 */
	public void setVerified(Boolean verified)
	{
		this.verified = verified;
	}
	/**
	 * @return the contact
	 */
	public Contact getContact()
	{
		return contact;
	}
	/**
	 * @param contact the contact to set
	 */
	public void setContact(Contact contact)
	{
		this.contact = contact;
	}
	/**
	 * @return the location
	 */
	public LocationDetails getLocation()
	{
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(LocationDetails location)
	{
		this.location = location;
	}
	/**
	 * @return the categories
	 */
	public List<Category> getCategories()
	{
		return categories;
	}
	/**
	 * @param categories the categories to set
	 */
	public void setCategories(List<Category> categories)
	{
		this.categories = categories;
	}
	/**
	 * @return the specials
	 */
	public List<Special> getSpecials()
	{
		return specials;
	}
	/**
	 * @param specials the specials to set
	 */
	public void setSpecials(List<Special> specials)
	{
		this.specials = specials;
	}
	/**
	 * @return the hereNow
	 */
	public Groups<Checkin> getHereNow()
	{
		return hereNow;
	}
	/**
	 * @param hereNow the hereNow to set
	 */
	public void setHereNow(Groups<Checkin> hereNow)
	{
		this.hereNow = hereNow;
	}
}
