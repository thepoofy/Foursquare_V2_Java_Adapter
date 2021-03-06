package com.williamvanderhoef.foursquare.model.subtypes;

import java.lang.reflect.Type;
import java.util.List;

import com.williamvanderhoef.foursquare.adapters.DefinedType;
import com.williamvanderhoef.foursquare.model.notification.Notifications;

/**
 * 
 * @author <a href="mailto://william.vanderhoef@gmail.com">William Vanderhoef</a>
 *
 * @param <ResponseType>
 */

public class Results<ResponseType> implements DefinedType
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
	 * @return
	 */
	public List<Notifications> getNotifications() {
		return notifications;
	}
	/**
	 * @param notifications
	 */
	public void setNotifications(List<Notifications> notifications) {
		this.notifications = notifications;
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
	

	/*
	 * (non-Javadoc)
	 * @see com.williamvanderhoef.foursquare.adapters.DefinedType#defineType()
	 */
	@Override
	public Type defineType()
	{
		return this.getClass().getGenericSuperclass();
	}
}
