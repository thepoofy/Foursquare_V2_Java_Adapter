package com.williamvanderhoef.foursquare.model.notification;

/**
 * 
 * This is the most difficult class to adapt from json to Java because of the dynamic typing of objects.
 * 
 * Please see http://developer.foursquare.com/docs/responses/notifications.html for a full definition of this object.
 * 
 * @author <a href="mailto://william.vanderhoef@gmail.com">William Vanderhoef</a>
 *
 */
public class Notifications
{
	
	private Notification item;
	private NotificationType type;
	
	
	/**
	 * @return the item
	 */
	public Notification getItem()
	{
		return item;
	}
	/**
	 * @param item the item to set
	 */
	public void setItem(Notification item)
	{
		this.item = item;
	}
	/**
	 * @return the type
	 */
	public NotificationType getType()
	{
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(NotificationType type)
	{
		this.type = type;
	}
	
}
