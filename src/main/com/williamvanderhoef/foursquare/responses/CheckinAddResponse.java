package com.williamvanderhoef.foursquare.responses;

import com.williamvanderhoef.foursquare.model.Checkin;

/**
 * Copyright (c) 2011 William Vanderhoef
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
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
