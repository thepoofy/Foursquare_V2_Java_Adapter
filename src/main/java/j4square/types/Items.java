package j4square.types;

import java.util.List;

public class Items<T> extends Count
{
	private List<T> items;

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
