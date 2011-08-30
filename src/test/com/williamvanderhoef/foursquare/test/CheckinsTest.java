/**
 * 
 */
package com.williamvanderhoef.foursquare.test;


import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.williamvanderhoef.foursquare.model.Checkin;
import com.williamvanderhoef.foursquare.responses.UserCheckinsResponse;
import com.williamvanderhoef.foursquare.types.Items;
import com.williamvanderhoef.foursquare.types.Results;

/**
 * @author Willum
 *
 */
public class CheckinsTest extends BaseTest<UserCheckinsResponse> {

	@Override
	public String getFileName()
	{
		return "src/test/v2.users.self.checkins.20110828.json";
	}
	
	

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	@Override
	public void setUp() throws Exception {
		
		super.setUp();
		
	}

	
	@Test
	public void testItems() {
		
		Results<UserCheckinsResponse> results = getResults();
		
		Items<Checkin> checkins = results.getResponse().getCheckins();
		
		Assert.assertNotNull(checkins);
	
		Assert.assertNotNull(checkins.getCount());
		
		Assert.assertNotNull(checkins.getItems());
	}

	@Test
	public void testCheckins() {
//		fail("Not yet implemented");
		
		Items<Checkin> checkins = getResults().getResponse().getCheckins();
		
		Checkin ck = checkins.getItems().get(0);
		
		Assert.assertNotNull(ck);
	}
}
