package com.williamvanderhoef.foursquare.model.subtypes;

public class Location
{
	private Double lat;
	private Double lng;

	public Location(){}
	public Location(Double lat, Double lng)
	{
		this.lat = new Double(lat);
		this.lng = new Double(lng);
	}

	/**
	 * @return the lat
	 */
	public Double getLat()
	{
		return lat;
	}
	/**
	 * @param lat the lat to set
	 */
	public void setLat(Double lat)
	{
		this.lat = lat;
	}
	/**
	 * @return the lng
	 */
	public Double getLng()
	{
		return lng;
	}
	/**
	 * @param lng the lng to set
	 */
	public void setLng(Double lng)
	{
		this.lng = lng;
	}
}
