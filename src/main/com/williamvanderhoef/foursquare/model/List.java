package com.williamvanderhoef.foursquare.model;

import com.williamvanderhoef.foursquare.types.Count;
import com.williamvanderhoef.foursquare.types.Unique;

/**
 * @date("08/28/2011")
 * 
 * I really hate calling this object List but I want to keep 4sq's name conventions.
 * Currently a non-public api.  This file is definitely subject to change.
 * 
 * @author Willum
 *
 */
public class List extends Unique{

	private String name;
	private String description;
	private User user;
	private Boolean editable;
	private Boolean _public;		//FIXME will not work for Gson
	private Boolean collaborative;
	private String url;
	private Count followers;
	private Count listItems;
	
	
	
	
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
	
	
}
