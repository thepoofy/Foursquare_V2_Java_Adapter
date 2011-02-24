package j4square.types;

import java.util.List;

/**
 * 
 * @see TODO update once documents become available online 
 * @author William Vanderhoef william.vanderhoef@gmail.com
 *
 */
public class Category
{
	private String id;
	
	private String name;
	
	private String icon;	//url
	
	private List<String> parents;
	
	private Boolean primary;
	
	
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
	 * @return the icon
	 */
	public String getIcon()
	{
		return icon;
	}
	/**
	 * @param icon the icon to set
	 */
	public void setIcon(String icon)
	{
		this.icon = icon;
	}
	/**
	 * @return the parents
	 */
	public List<String> getParents()
	{
		return parents;
	}
	/**
	 * @param parents the parents to set
	 */
	public void setParents(List<String> parents)
	{
		this.parents = parents;
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
