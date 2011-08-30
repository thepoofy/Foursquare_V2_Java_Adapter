package com.williamvanderhoef.foursquare.model;

public class Contact
{
	private String twitter;
	private String facebook;
	private String email;
	private String phone;
	private String formattedPhone;
	
	/**
	 * @return the twitter
	 */
	public String getTwitter()
	{
		return twitter;
	}
	/**
	 * @param twitter the twitter to set
	 */
	public void setTwitter(String twitter)
	{
		this.twitter = twitter;
	}
	/**
	 * @return the facebook
	 */
	public String getFacebook()
	{
		return facebook;
	}
	/**
	 * @param facebook the facebook to set
	 */
	public void setFacebook(String facebook)
	{
		this.facebook = facebook;
	}
	/**
	 * @return the email
	 */
	public String getEmail()
	{
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email)
	{
		this.email = email;
	}
	/**
	 * @return the phone
	 */
	public String getPhone()
	{
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	public String getFormattedPhone() {
		return formattedPhone;
	}
	public void setFormattedPhone(String formattedPhone) {
		this.formattedPhone = formattedPhone;
	}
	
	
}