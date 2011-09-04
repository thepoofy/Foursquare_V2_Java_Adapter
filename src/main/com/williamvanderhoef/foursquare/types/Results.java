package com.williamvanderhoef.foursquare.types;

import java.util.List;

import com.williamvanderhoef.foursquare.model.notification.Notifications;

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
	
	private List<Notifications> notifications;
	
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
	public List<Notifications> getNotifications() {
		return notifications;
	}
	public void setNotifications(List<Notifications> notifications) {
		this.notifications = notifications;
	}
	
	
	
}
