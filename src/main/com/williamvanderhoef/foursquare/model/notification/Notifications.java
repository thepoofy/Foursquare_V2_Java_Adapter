package com.williamvanderhoef.foursquare.model.notification;

import java.util.List;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;

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
	
	List<Notification> notifications;
	
	

	
//	/**
//	 * 
//	 */
//	public enum NotificationType
//	{ badge, tip, score, mayorship, message, notificationTray }
//	
	
	
//	/**
//	 * @return the type
//	 */
//	public NotificationType getType()
//	{
//		return type;
//	}
//	/**
//	 * @param type the type to set
//	 */
//	public void setType(NotificationType type)
//	{
//		this.type = type;
//	}

	
	
}
