package com.williamvanderhoef.foursquare.model;


import com.williamvanderhoef.foursquare.model.subtypes.Count;
import com.williamvanderhoef.foursquare.model.subtypes.Groups;
import com.williamvanderhoef.foursquare.model.subtypes.Items;
import com.williamvanderhoef.foursquare.model.subtypes.Scores;


/**
 * @see http://developer.foursquare.com/docs/responses/user.html
 * @author William Vanderhoef william.vanderhoef@gmail.com
 *
 */
public class UserDetails extends User
{
	/**
	 * One of brand, celebrity, or user. Users can establish following relationships with celebrities.
	 */
	private UserType type;	//brand,celebrity,user
	
	public enum UserType { brand, celebrity, user }
	
	/**
	 * 	An object containing none, some, or all of twitter, facebook, email, and phone. Both are strings.
	 */
	private Contact contact;
	
	/**
	 * Optional. Whether we receive pings from this user, if we have a relationship.
	 */
	private Boolean pings;

	/**
	 * Contains the count of badges for this user. May eventually contain some selected badges. 
	 * Use user/XX/badges to get the list of badges. 
	 */
	private Count badges;		//only returns a count
	
	/**
	 * Contains the count of checkins by this user. 
	 * May contain the most recent checkin as an array items containing a single element, if the user is a friend. 
	 */
	private Items<Checkin> checkins;	//returns only the most recent
	
	/**
	 * Contains the count of mayorships for this user and an items array that for now is empty. 
	 * Use users/XXXX/mayorships to get actual mayorships.
	 * 
	 * FIXME This is currently returning an empty items list, anticipate this to change this to a Count object.
	 */
	private Items<Venue> mayorships;	//returns all venue that the user is the mayor of
	
	/**
	 * Contains the count of tips from this user. 
	 * May contain an array of selected tips as items, which may or may not be empty. 
	 * 
	 */
	private Count tips;
	/**
	 * Contains the count of todos this user has. 
	 * May contain an array of selected todos as items.  
	 * Full set of items can be requested from the To-do endpoint, but only visible to friends. 
	 */
	private Count todos;
	/**
	 * Contains count of friends for this user and groups of users who are friends. 
	 * Right now will only contain a group where type is friends, but it's subject to change. 
	 * Groups are omitted when viewing self. 
	 * The full set of friends has its own endpoint. 
	 */
	private Groups<User> friends;		
	/**
	 * Contains count of followers for this user, if they are a brand or celebrity. 
	 */
	private Count followers;
	
	/**
	 * 
	 */
	private Count following;
	/**
	 * 	Contains count of pending friend requests for this user. 
	 */
	private Count requests;
	
	/**
	 * XXX undocumented
	 */
	private Scores scores;
	
	
	/**
	 * @return the type
	 */
	public UserType getType()
	{
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(UserType type)
	{
		this.type = type;
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
	 * @return the pings
	 */
	public Boolean getPings()
	{
		return pings;
	}
	/**
	 * @param pings the pings to set
	 */
	public void setPings(Boolean pings)
	{
		this.pings = pings;
	}
	/**
	 * @return the badges
	 */
	public Count getBadges()
	{
		return badges;
	}
	/**
	 * @param badges the badges to set
	 */
	public void setBadges(Count badges)
	{
		this.badges = badges;
	}
	/**
	 * @return the checkins
	 */
	public Items<Checkin> getCheckins()
	{
		return checkins;
	}
	/**
	 * @param checkins the checkins to set
	 */
	public void setCheckins(Items<Checkin> checkins)
	{
		this.checkins = checkins;
	}
	/**
	 * @return the mayorships
	 */
	public Items<Venue> getMayorships()
	{
		return mayorships;
	}
	/**
	 * @param mayorships the mayorships to set
	 */
	public void setMayorships(Items<Venue> mayorships)
	{
		this.mayorships = mayorships;
	}

	
	/**
	 * @param followers the followers to set
	 */
	public void setFollowers(Items<User> followers)
	{
		this.followers = followers;
	}
	
	/**
	 * @param requests the requests to set
	 */
	public void setRequests(Items<Object> requests)
	{
		this.requests = requests;
	}
	
	/**
	 * @return the followers
	 */
	public Count getFollowers()
	{
		return followers;
	}
	/**
	 * @param followers the followers to set
	 */
	public void setFollowers(Count followers)
	{
		this.followers = followers;
	}
	/**
	 * @return the requests
	 */
	public Count getRequests()
	{
		return requests;
	}
	/**
	 * @param requests the requests to set
	 */
	public void setRequests(Count requests)
	{
		this.requests = requests;
	}
	public Count getTips() {
		return tips;
	}
	public void setTips(Count tips) {
		this.tips = tips;
	}
	public Count getTodos() {
		return todos;
	}
	public void setTodos(Count todos) {
		this.todos = todos;
	}
	public Groups<User> getFriends() {
		return friends;
	}
	public void setFriends(Groups<User> friends) {
		this.friends = friends;
	}
	public Count getFollowing() {
		return following;
	}
	public void setFollowing(Count following) {
		this.following = following;
	}
	public Scores getScores() {
		return scores;
	}
	public void setScores(Scores scores) {
		this.scores = scores;
	}
	
	
	
}