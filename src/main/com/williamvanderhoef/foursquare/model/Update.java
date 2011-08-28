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
}
