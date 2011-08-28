package com.williamvanderhoef.foursquare.types;

import java.util.Iterator;
import java.util.List;

public class Items<T> extends Count implements Iterable<T>
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

	@Override
	public Iterator<T> iterator()
	{
		return items.iterator();
	}
	
}
