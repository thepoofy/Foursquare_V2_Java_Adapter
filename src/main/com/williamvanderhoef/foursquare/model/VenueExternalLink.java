package com.williamvanderhoef.foursquare.model;

import com.williamvanderhoef.foursquare.model.subtypes.Unique;

public class VenueExternalLink
{
	private Unique provider;

	private String linkedId;
	private String url;
	/**
	 * @return the provider
	 */
	public Unique getProvider()
	{
		return provider;
	}
	/**
	 * @param provider the provider to set
	 */
	public void setProvider(Unique provider)
	{
		this.provider = provider;
	}
	/**
	 * @return the linkedId
	 */
	public String getLinkedId()
	{
		return linkedId;
	}
	/**
	 * @param linkedId the linkedId to set
	 */
	public void setLinkedId(String linkedId)
	{
		this.linkedId = linkedId;
	}
	/**
	 * @return the url
	 */
	public String getUrl()
	{
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url)
	{
		this.url = url;
	}
	
	
	
	
}
