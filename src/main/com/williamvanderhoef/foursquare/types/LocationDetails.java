package com.williamvanderhoef.foursquare.types;

public class LocationDetails extends Location
{
	private String address;
	private String crossStreet;
	private String city;
	private String state;
	private String postalCode;
	private String country;
	private Double distance;
	
	
	/**
	 * @return the address
	 */
	public String getAddress()
	{
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address)
	{
		this.address = address;
	}
	/**
	 * @return the crossStreet
	 */
	public String getCrossStreet()
	{
		return crossStreet;
	}
	/**
	 * @param crossStreet the crossStreet to set
	 */
	public void setCrossStreet(String crossStreet)
	{
		this.crossStreet = crossStreet;
	}
	/**
	 * @return the city
	 */
	public String getCity()
	{
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city)
	{
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState()
	{
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state)
	{
		this.state = state;
	}
	/**
	 * @return the postalCode
	 */
	public String getPostalCode()
	{
		return postalCode;
	}
	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode)
	{
		this.postalCode = postalCode;
	}
	/**
	 * @return the country
	 */
	public String getCountry()
	{
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country)
	{
		this.country = country;
	}
	/**
	 * @return the distance
	 */
	public Double getDistance()
	{
		return distance;
	}
	/**
	 * @param distance the distance to set
	 */
	public void setDistance(Double distance)
	{
		this.distance = distance;
	}
	
}
