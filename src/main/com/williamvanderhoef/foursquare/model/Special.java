package com.williamvanderhoef.foursquare.model;

import java.util.List;


/**
 * 
 * @see http://developer.foursquare.com/docs/responses/special.html
 * @author William Vanderhoef william.vanderhoef@gmail.com
 *
 */
public class Special
{
	private String id;			//	A unique identifier for this special.
	private SpecialType type;		//One of mayor, count, frequency, or other.
	public enum SpecialType { mayor, count, frequency, regular, friends, swarm, flash, other}
	
	private String message;		//	A message describing the special.
	private String description;	//  A description of how to unlock the special.
	private String finePrint;	//	The specific rules for this special.
	
	private Boolean unlocked;	//optional If this is a venue detail request, true or false indicating if this special is unlocked for the acting user.

	private String icon;
	private String title;
	private String state;
	
	private Integer progress;	
	private String progressDescription;
	
	private String detail;
	private String target;
	
	private List<User> friendsHere;
	
	
	
	
	
//	private Venue venue;		//optional If the venue is not clear from the context, then a compact venue is provided.
	
	
	/**
	 * @return the id
	 */
	public String getId()
	{
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id)
	{
		this.id = id;
	}
	/**
	 * @return the type
	 */
	public SpecialType getType()
	{
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(SpecialType type)
	{
		this.type = type;
	}
	/**
	 * @return the message
	 */
	public String getMessage()
	{
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message)
	{
		this.message = message;
	}
	/**
	 * @return the description
	 */
	public String getDescription()
	{
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}
	/**
	 * @return the unlocked
	 */
	public Boolean getUnlocked()
	{
		return unlocked;
	}
	/**
	 * @param unlocked the unlocked to set
	 */
	public void setUnlocked(Boolean unlocked)
	{
		this.unlocked = unlocked;
	}
	public String getFinePrint() {
		return finePrint;
	}
	public void setFinePrint(String finePrint) {
		this.finePrint = finePrint;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getProgress() {
		return progress;
	}
	public void setProgress(Integer progress) {
		this.progress = progress;
	}
	public String getProgressDescription() {
		return progressDescription;
	}
	public void setProgressDescription(String progressDescription) {
		this.progressDescription = progressDescription;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public List<User> getFriendsHere() {
		return friendsHere;
	}
	public void setFriendsHere(List<User> friendsHere) {
		this.friendsHere = friendsHere;
	}

	

}
