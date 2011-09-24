package com.williamvanderhoef.foursquare.model;

import com.williamvanderhoef.foursquare.model.subtypes.CategoryCount;
import com.williamvanderhoef.foursquare.model.subtypes.Items;
import com.williamvanderhoef.foursquare.model.subtypes.Unique;

/**
 * @date("08/28/2011")
 * 
 * The name was originally "List" but it took all of 3 minutes to realize how ambiguous that would be in downstream code.
 * The name FoursquareList was chosen in the event
 * 
 * @author Willum
 *
 */
public class FoursquareList extends Unique{

	private String name;
	private String description;
	private User user;
	private Boolean following;
	private Items<User> followers;
	private Boolean editable;
	private Boolean collaborative;
	private Boolean _public;
	private Items<User> collaborators;
	private String url;
	private String canonicalUrl;
	
	private Photo photo;
	private Integer doneCount;
	private Integer venueCount; 
	private Integer visitedCount;
	private Items<CategoryCount> categories;
	
	private Integer createdAt;
	private Integer updatedAt;
	
	private Items<FoursquareListItem> listItems;

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
	 * @return the following
	 */
	public Boolean getFollowing()
	{
		return following;
	}

	/**
	 * @param following the following to set
	 */
	public void setFollowing(Boolean following)
	{
		this.following = following;
	}

	/**
	 * @return the followers
	 */
	public Items<User> getFollowers()
	{
		return followers;
	}

	/**
	 * @param followers the followers to set
	 */
	public void setFollowers(Items<User> followers)
	{
		this.followers = followers;
	}

	/**
	 * @return the editable
	 */
	public Boolean getEditable()
	{
		return editable;
	}

	/**
	 * @param editable the editable to set
	 */
	public void setEditable(Boolean editable)
	{
		this.editable = editable;
	}

	/**
	 * @return the collaborative
	 */
	public Boolean getCollaborative()
	{
		return collaborative;
	}

	/**
	 * @param collaborative the collaborative to set
	 */
	public void setCollaborative(Boolean collaborative)
	{
		this.collaborative = collaborative;
	}

	/**
	 * @return the collaborators
	 */
	public Items<User> getCollaborators()
	{
		return collaborators;
	}

	/**
	 * @param collaborators the collaborators to set
	 */
	public void setCollaborators(Items<User> collaborators)
	{
		this.collaborators = collaborators;
	}

	/**
	 * @return the canonicalUrl
	 */
	public String getCanonicalUrl()
	{
		return canonicalUrl;
	}

	/**
	 * @param canonicalUrl the canonicalUrl to set
	 */
	public void setCanonicalUrl(String canonicalUrl)
	{
		this.canonicalUrl = canonicalUrl;
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
	 * @return the doneCount
	 */
	public Integer getDoneCount()
	{
		return doneCount;
	}

	/**
	 * @param doneCount the doneCount to set
	 */
	public void setDoneCount(Integer doneCount)
	{
		this.doneCount = doneCount;
	}

	/**
	 * @return the venueCount
	 */
	public Integer getVenueCount()
	{
		return venueCount;
	}

	/**
	 * @param venueCount the venueCount to set
	 */
	public void setVenueCount(Integer venueCount)
	{
		this.venueCount = venueCount;
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
	 * @return the listItems
	 */
	public Items<FoursquareListItem> getListItems()
	{
		return listItems;
	}

	/**
	 * @param listItems the listItems to set
	 */
	public void setListItems(Items<FoursquareListItem> listItems)
	{
		this.listItems = listItems;
	}

	public Boolean getPublic() {
		return _public;
	}

	public void setPublic(Boolean _public) {
		this._public = _public;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the createdAt
	 */
	public Integer getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Integer createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the updatedAt
	 */
	public Integer getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(Integer updatedAt) {
		this.updatedAt = updatedAt;
	}

	/**
	 * @return the categories
	 */
	public Items<CategoryCount> getCategories() {
		return categories;
	}

	/**
	 * @param categories the categories to set
	 */
	public void setCategories(Items<CategoryCount> categories) {
		this.categories = categories;
	}
	
	
		
}
