package com.williamvanderhoef.foursquare.model;

import com.williamvanderhoef.foursquare.types.Count;
import com.williamvanderhoef.foursquare.types.Groups;
import com.williamvanderhoef.foursquare.types.Items;


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
	
	enum UserType { brand, celebrity, user }
	
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
	 * Use users/XX/mayorships to get actual mayorships.  
	 */
	private Count mayorships;	//returns all venue that the user is the mayor of
	
	/**
	 * Contains the count of tips from this user. 
	 * May contain an array of selected tips as items, which may or may not be empty. 
	 * 
	 */
	private Items<Tip> tips;
	/**
	 * Contains the count of todos this user has. 
	 * May contain an array of selected todos as items.  
	 * Full set of items can be requested from the To-do endpoint, but only visible to friends. 
	 */
	private Items<Todo> todos;
	/**
	 * Contains count of friends for this user and groups of users who are friends. 
	 * Right now will only contain a group where type is friends, but it's subject to change. 
	 * Groups are omitted when viewing self. 
	 * The full set of friends has its own endpoint. 
	 */
	private Groups<Items<User>> friends;		
	/**
	 * Contains count of followers for this user, if they are a brand or celebrity. 
	 */
	private Count followers;
	/**
	 * 	Contains count of pending friend requests for this user. 
	 */
	private Count requests;
	
	
	
	
	
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
	public Count getMayorships()
	{
		return mayorships;
	}
	/**
	 * @param mayorships the mayorships to set
	 */
	public void setMayorships(Count mayorships)
	{
		this.mayorships = mayorships;
	}
	/**
	 * @return the tips
	 */
	public Items<Tip> getTips()
	{
		return tips;
	}
	/**
	 * @param tips the tips to set
	 */
	public void setTips(Items<Tip> tips)
	{
		this.tips = tips;
	}
	/**
	 * @return the todos
	 */
	public Items<Todo> getTodos()
	{
		return todos;
	}
	/**
	 * @param todos the todos to set
	 */
	public void setTodos(Items<Todo> todos)
	{
		this.todos = todos;
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
	 * @return the friends
	 */
	public Groups<Items<User>> getFriends()
	{
		return friends;
	}
	/**
	 * @param friends the friends to set
	 */
	public void setFriends(Groups<Items<User>> friends)
	{
		this.friends = friends;
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
}