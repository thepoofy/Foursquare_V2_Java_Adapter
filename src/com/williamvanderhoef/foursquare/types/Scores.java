package com.williamvanderhoef.foursquare.types;

/**
 * TODO This class is not yet implemented and only returned by the checkins/add endpoint
 * 
 * 
 * @author <a href="mailto://william.vanderhoef@gmail.com">William Vanderhoef</a>
 *
 */
public class Scores implements Notification
{

	
	
	@Override
	public NotificationType getType()
	{
		return NotificationType.score;
	}
	
	

}
