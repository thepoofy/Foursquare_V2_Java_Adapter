package j4square.types;

import java.util.List;

/**
 * 
 * Pieces needed to construct badge image at various sizes. 
 * Combine prefix with one of the sizes and a name, e.g. http://foursquare.com/img/badge/57/newbie.png. 
 * For locked badges, this will point to the locked badge image.
 * 
 * 
 * @author <a href="mailto://william.vanderhoef@gmail.com">William Vanderhoef</a>
 *
 */
public class ImageDefinition
{
	private String prefix;
	private List<Integer> sizes;
	private String name;
	/**
	 * @return the prefix
	 */
	public String getPrefix()
	{
		return prefix;
	}
	/**
	 * @param prefix the prefix to set
	 */
	public void setPrefix(String prefix)
	{
		this.prefix = prefix;
	}
	/**
	 * @return the sizes
	 */
	public List<Integer> getSizes()
	{
		return sizes;
	}
	/**
	 * @param sizes the sizes to set
	 */
	public void setSizes(List<Integer> sizes)
	{
		this.sizes = sizes;
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

}
