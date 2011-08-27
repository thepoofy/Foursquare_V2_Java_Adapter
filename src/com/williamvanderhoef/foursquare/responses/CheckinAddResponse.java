package com.williamvanderhoef.foursquare.responses;

import com.williamvanderhoef.foursquare.types.Checkin;

/**
 * 
 * Defined here: http://developer.foursquare.com/docs/checkins/add.html
 * 
 * @author <a href="mailto://william.vanderhoef@gmail.com">William Vanderhoef</a>
 *
 */
public class CheckinAddResponse
{
	/**
	 *  /checkins/add Response will always contain a checkin with notifications block
	 */
	private Checkin checkin;
	

	/**
	 * @return the checkin
	 */
	public Checkin getCheckin()
	{
		return checkin;
	}

	/**
	 * @param checkin the checkin to set
	 */
	public void setCheckin(Checkin checkin)
	{
		this.checkin = checkin;
	}
}
