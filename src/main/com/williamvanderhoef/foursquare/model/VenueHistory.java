package com.williamvanderhoef.foursquare.model;


/**
 * Used in conjunction with the /users/USER_ID/venuehistory endpoint
 * https://developer.foursquare.com/docs/users/venuehistory.html
 * 
 * Returns a list of all venues visited by the specified user, along with how many visits and when they were last there. 
 * 
 * @author <a href="mailto://william.vanderhoef@gmail.com">William Vanderhoef</a>
 *
 */
public class VenueHistory
{
	private Integer beenHere;
	//private Integer lastHereAt;
	private Venue venue;
	
	
	public Integer getBeenHere()
	{
		return beenHere;
	}
	public void setBeenHere(Integer beenHere)
	{
		this.beenHere = beenHere;
	}
//	public Integer getLastHereAt()
//	{
//		return lastHereAt;
//	}
//	public void setLastHereAt(Integer lastHereAt)
//	{
//		this.lastHereAt = lastHereAt;
//	}
	public Venue getVenue()
	{
		return venue;
	}
	public void setVenue(Venue venue)
	{
		this.venue = venue;
	}
}
