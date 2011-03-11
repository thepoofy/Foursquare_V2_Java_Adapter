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
	 * 
	 * TODO add a subclass of Checkin that will contain the anomalous notifications block
	 */
	private Checkin checkin;
	
	
}
