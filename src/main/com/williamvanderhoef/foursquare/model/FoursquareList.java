package com.williamvanderhoef.foursquare.model;

import com.williamvanderhoef.foursquare.types.Count;
import com.williamvanderhoef.foursquare.types.Photo;
import com.williamvanderhoef.foursquare.types.Unique;

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
	private Boolean editable;
	private Boolean _public;		//FIXME will not work for Gson
	private Boolean collaborative;
	private String url;
	private Count followers;
	private Count listItems;
	
	private Photo photo;
	private Long createdAt;
	private Long updatedAt;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Boolean getEditable() {
		return editable;
	}
	public void setEditable(Boolean editable) {
		this.editable = editable;
	}
	public Boolean getPublic() {
		return _public;
	}
	public void setPublic(Boolean _public) {
		this._public = _public;
	}
	public Boolean getCollaborative() {
		return collaborative;
	}
	public void setCollaborative(Boolean collaborative) {
		this.collaborative = collaborative;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Count getFollowers() {
		return followers;
	}
	public void setFollowers(Count followers) {
		this.followers = followers;
	}
	public Count getListItems() {
		return listItems;
	}
	public void setListItems(Count listItems) {
		this.listItems = listItems;
	}
	public Photo getPhoto() {
		return photo;
	}
	public void setPhoto(Photo photo) {
		this.photo = photo;
	}
	public Long getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Long createdAt) {
		this.createdAt = createdAt;
	}
	public Long getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Long updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
}
