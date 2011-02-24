package j4square.types;

import java.util.List;


public class Group<T> extends Count{
	private String type;
	private String name;
	private List<T> items;

	/**
	 * @return the type
	 */
	public String getType()
	{
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type)
	{
		this.type = type;
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
	 * @return the items
	 */
	public List<T> getItems()
	{
		return items;
	}
	/**
	 * @param items the items to set
	 */
	public void setItems(List<T> items)
	{
		this.items = items;
	}
	
}
