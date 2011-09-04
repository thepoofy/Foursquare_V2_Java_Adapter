/**
 * 
 */
package com.williamvanderhoef.foursquare.test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.williamvanderhoef.foursquare.BaseTest;
import com.williamvanderhoef.foursquare.adapters.checkins.CheckinsAddEndpoint;
import com.williamvanderhoef.foursquare.model.Checkin;
import com.williamvanderhoef.foursquare.model.notification.Notifications;
import com.williamvanderhoef.foursquare.parsers.GsonResultsParser;
import com.williamvanderhoef.foursquare.parsers.JacksonResultsParser;
import com.williamvanderhoef.foursquare.parsers.ResultsParser;
import com.williamvanderhoef.foursquare.responses.CheckinAddResponse;
import com.williamvanderhoef.foursquare.types.Results;

/**
 * @author Willum
 *
 */
@RunWith(Parameterized.class)
public class CheckinAddTest extends BaseTest<CheckinAddResponse> {

	@Override
	public String getFileName()
	{
		return "src/test/v2.checkins.add.20110904.json";
	}
	
	@Parameters
	public static Collection<Object[]> generateParams(){
		List<ResultsParser<CheckinAddResponse>> params = new ArrayList<ResultsParser<CheckinAddResponse>>();  
        
		GsonResultsParser<CheckinAddResponse> gLoader = new GsonResultsParser<CheckinAddResponse>(new CheckinsAddEndpoint());
		params.add(gLoader);
		JacksonResultsParser<CheckinAddResponse> jLoader = new JacksonResultsParser<CheckinAddResponse>(new CheckinsAddEndpoint());
		jLoader.setStrictValidation(true);
		params.add(jLoader);
        
		return Arrays.asList(new Object[][] {
				{gLoader},
				{jLoader}
		});
	}
	
	public CheckinAddTest(ResultsParser<CheckinAddResponse> loader)
	{
		this.loader = loader;
	}
	
	private ResultsParser<CheckinAddResponse> loader = null;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	@Override
	public void setUp() throws Exception {
		
		super.setUp();
		
		this.setResults(loader.parse(this.getFileContents()));
	}
	
	@Test
	public void testNotification()
	{
		Results<CheckinAddResponse> results = getResults();
		
		List<Notifications> notifications = results.getNotifications();
		
		Assert.assertNotNull(notifications);
		
		for(int i = 0; i<notifications.size(); ++i )
		{
			Notifications n = notifications.get(i);
			Assert.assertNotNull("Notification #: "+i, n);
			
			Assert.assertNotNull(n.getItem());
			Assert.assertNotNull(n.getType());
			
			
//			Notifications.NotificationType type = 
			Assert.assertNotNull(Notifications.NotificationType.valueOf(n.getType()));
			
			
//			Object obj = (type.getTypeOf().cast(n));
		}
		
	}
	
	@Test
	public void testCheckin() {
		
		Results<CheckinAddResponse> results = getResults();
		
		Checkin checkin = results.getResponse().getCheckin();
		
		Assert.assertNotNull(checkin);
	
		
	}
}
