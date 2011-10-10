package com.williamvanderhoef.foursquare.model.subtypes;

import com.sun.xml.internal.bind.v2.TODO;
import com.williamvanderhoef.foursquare.model.ImageDefinition;

/**
 * 
 * @see TODO update once documents become available online 
 * @author William Vanderhoef william.vanderhoef@gmail.com
 *
 */
public class Category extends Unique
{
	private String name;
	
	private String pluralName;
	
	private String shortName;
	
	private ImageDefinition icon;
	
	private Boolean primary;
	
	
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
	
	public String getPluralName() {
		return pluralName;
	}
	public void setPluralName(String pluralName) {
		this.pluralName = pluralName;
	}
	
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
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
	
	/**
	 * @return the primary
	 */
	public Boolean getPrimary()
	{
		return primary;
	}
	/**
	 * @param primary the primary to set
	 */
	public void setPrimary(Boolean primary)
	{
		this.primary = primary;
	}
	
	
	
}
