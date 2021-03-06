package com.williamvanderhoef.foursquare.model;

import com.williamvanderhoef.foursquare.model.subtypes.Unique;

/**
 * As documented on <a href="http://developer.foursquare.com/docs/responses/todo.html">Foursquare Developers - Todo Response</a>
 * 
 * @author <a href="mailto://william.vanderhoef@gmail.com">William Vanderhoef</a>
 *
 */
public class Todo extends Unique
{
	private Long createdAt;
	private Tip tip;
	
	/**
	 * @return the createdAt
	 */
	public Long getCreatedAt()
	{
		return createdAt;
	}
	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Long createdAt)
	{
		this.createdAt = createdAt;
	}
	/**
	 * @return the tip
	 */
	public Tip getTip()
	{
		return tip;
	}
	/**
	 * @param tip the tip to set
	 */
	public void setTip(Tip tip)
	{
		this.tip = tip;
	}
}
