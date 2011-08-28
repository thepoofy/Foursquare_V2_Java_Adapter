package com.williamvanderhoef.foursquare.types;

public class Source
{
	private String name;
	private String url;
	
	public Source(){}

	public Source(String name, String url)
	{
		this.name = name;
		this.url = url;
	}
	
	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
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
