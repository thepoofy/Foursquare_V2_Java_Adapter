package com.williamvanderhoef.foursquare.model;

import java.util.List;

import com.williamvanderhoef.foursquare.model.subtypes.Checkins;
import com.williamvanderhoef.foursquare.model.subtypes.Unique;

/**
 * As defined on
 * <a href="http://developer.foursquare.com/docs/responses/badge.html">Foursquare Developers</a>
 * 
 * @see http://developer.foursquare.com/docs/responses/badge.html
 * @author <a href="mailto://william.vanderhoef@gmail.com">William Vanderhoef</a>
 *
 */
public class Badge extends Unique
{
	private String badgeId;
	private String name;
	private String description;
	private ImageDefinition image;
	private List<Checkins> unlocks;
	
	
	/**
	 * optional 
	 * A canonical ID for this badge.
	 * 
	 * @return the badgeId
	 */
	public String getBadgeId()
	{
		return badgeId;
	}
	
	/**
	 * The name of the badge.
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
	 * Additional text about the badge.
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
	 * Pieces needed to construct badge image at various sizes. 
	 * Combine prefix with one of the sizes and a name, e.g. http://foursquare.com/img/badge/57/newbie.png. 
	 * For locked badges, this will point to the locked badge image.
	 * 
	 * @return the image
	 */
	public ImageDefinition getImage()
	{
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(ImageDefinition image)
	{
		this.image = image;
	}

	/**
	 * optional 
	 * If present, an array of unlock data. 
	 * Array contains checkins, which is an array of checkins. 
	 * Currently both arrays will only contain 1 element.
	 * 
	 * @return the unlocks
	 */
	public List<Checkins> getUnlocks()
	{
		return unlocks;
	}

	/**
	 * @param unlocks the unlocks to set
	 */
	public void setUnlocks(List<Checkins> unlocks)
	{
		this.unlocks = unlocks;
	}

	/**
	 * @param badgeId the badgeId to set
	 */
	public void setBadgeId(String badgeId)
	{
		this.badgeId = badgeId;
	}

}
