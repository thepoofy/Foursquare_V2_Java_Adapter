package com.williamvanderhoef.foursquare.responses;

import com.williamvanderhoef.foursquare.model.VenueHistory;
import com.williamvanderhoef.foursquare.model.subtypes.Items;

/**
 * Copyright (c) 2011 William Vanderhoef
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 * 
 * Example found at https://developer.foursquare.com/docs/explore.html#req=users/self/venuehistory
 * 
 * @author <a href="mailto://william.vanderhoef@gmail.com">William Vanderhoef</a>
 *
 */
public class VenueTrendingResponse
{
	
	private Items<VenueHistory> venues;

	public Items<VenueHistory> getVenues()
	{
		return venues;
	}

	public void setVenues(Items<VenueHistory> venues)
	{
		this.venues = venues;
	}

	

	
}
