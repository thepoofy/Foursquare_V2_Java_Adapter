package com.williamvanderhoef.foursquare.types;

/**
 * 
 * @author <a href="mailto://william.vanderhoef@gmail.com">William Vanderhoef</a>
 *
 * @param <ResponseType>
 */
public class Results<ResponseType>
{
	private Meta meta;
	private ResponseType response;
	
	//optional - always returned with Checkins Add
	//private Notifications notifications;

//	/**
//	 * @return the notifications
//	 */
//	public Notifications getNotifications()
//	{
//		return notifications;
//	}
//
//	/**
//	 * @param notifications the notifications to set
//	 */
//	public void setNotifications(Notifications notifications)
//	{
//		this.notifications = notifications;
//	}

	
	/**
	 * @return the meta
	 */
	public Meta getMeta()
	{
		return meta;
	}
	/**
	 * @param meta the meta to set
	 */
	public void setMeta(Meta meta)
	{
		this.meta = meta;
	}
	/**
	 * @return the response
	 */
	public ResponseType getResponse()
	{
		return response;
	}
	/**
	 * @param response the response to set
	 */
	public void setResponse(ResponseType response)
	{
		this.response = response;
	}
	
	
	
}
