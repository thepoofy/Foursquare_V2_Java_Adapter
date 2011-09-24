package com.williamvanderhoef.foursquare.model;

import java.util.List;

/**
 * This is deprecated until testing is complete.
 * 
 * @author Willum
 *
 */
@Deprecated
public class Update {

	private List<String> ids;
	
	private Long createdAt;
	
	private Boolean unread;
	
	/**
	 * This looks like a pain to map via jackson or gson.  Deprecated till then.
	 */
	@Deprecated
	private Object target;	//the target object that should be opened when the user clicks on this update
	
	private String text;
	
	/**
	 * TODO Define the type for this.  From Foursquare api: 
	 * A list with information about entities referenced in the text of the update. 
	 * Each element of this list will include a "type" key and an "indices" key to indicate what kind of entity is being referenced and at what indices in the returned text. 
	 * The valid values of "type" are "user" and "venue."
	 */
	private List<Object> entities;
	
	private ImageDefinition image;
	private ImageType imageType;
	
	enum ImageType{ user, badge, special, points, bulletin }
	
	
	private ImageDefinition icon;


	/**
	 * @return the ids
	 */
	public List<String> getIds() {
		return ids;
	}


	/**
	 * @param ids the ids to set
	 */
	public void setIds(List<String> ids) {
		this.ids = ids;
	}


	/**
	 * @return the createdAt
	 */
	public Long getCreatedAt() {
		return createdAt;
	}


	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Long createdAt) {
		this.createdAt = createdAt;
	}


	/**
	 * @return the unread
	 */
	public Boolean getUnread() {
		return unread;
	}


	/**
	 * @param unread the unread to set
	 */
	public void setUnread(Boolean unread) {
		this.unread = unread;
	}


	/**
	 * @return the target
	 */
	public Object getTarget() {
		return target;
	}


	/**
	 * @param target the target to set
	 */
	public void setTarget(Object target) {
		this.target = target;
	}


	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}


	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}


	/**
	 * @return the entities
	 */
	public List<Object> getEntities() {
		return entities;
	}


	/**
	 * @param entities the entities to set
	 */
	public void setEntities(List<Object> entities) {
		this.entities = entities;
	}


	/**
	 * @return the image
	 */
	public ImageDefinition getImage() {
		return image;
	}


	/**
	 * @param image the image to set
	 */
	public void setImage(ImageDefinition image) {
		this.image = image;
	}


	/**
	 * @return the imageType
	 */
	public ImageType getImageType() {
		return imageType;
	}


	/**
	 * @param imageType the imageType to set
	 */
	public void setImageType(ImageType imageType) {
		this.imageType = imageType;
	}


	/**
	 * @return the icon
	 */
	public ImageDefinition getIcon() {
		return icon;
	}


	/**
	 * @param icon the icon to set
	 */
	public void setIcon(ImageDefinition icon) {
		this.icon = icon;
	}
	
	
}
