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
import com.williamvanderhoef.foursquare.GsonResultsLoader;
import com.williamvanderhoef.foursquare.JacksonResultsLoader;
import com.williamvanderhoef.foursquare.ResultsLoader;
import com.williamvanderhoef.foursquare.adapters.users.UserCheckinsEndpoint;
import com.williamvanderhoef.foursquare.model.Checkin;
import com.williamvanderhoef.foursquare.responses.UserCheckinsResponse;
import com.williamvanderhoef.foursquare.types.Items;
import com.williamvanderhoef.foursquare.types.Results;

/**
 * @author Willum
 *
 */
@RunWith(Parameterized.class)
public class CheckinsTest extends BaseTest<UserCheckinsResponse> {

	@Override
	public String getFileName()
	{
		return "src/test/v2.users.self.checkins.20110828.json";
	}
	
	@Parameters
	public static Collection<Object[]> generateParams(){
		List<ResultsLoader<UserCheckinsResponse>> params = new ArrayList<ResultsLoader<UserCheckinsResponse>>();  
        
		GsonResultsLoader<UserCheckinsResponse> gLoader = new GsonResultsLoader<UserCheckinsResponse>(new UserCheckinsEndpoint());
		params.add(gLoader);
		JacksonResultsLoader<UserCheckinsResponse> jLoader = new JacksonResultsLoader<UserCheckinsResponse>(new UserCheckinsEndpoint());
		params.add(jLoader);
        
		return Arrays.asList(new Object[][] {
				{gLoader},
				{jLoader}
		});
	}
	
	public CheckinsTest(ResultsLoader<UserCheckinsResponse> loader)
	{
		this.loader = loader;
	}
	
	private ResultsLoader<UserCheckinsResponse> loader = null;
	
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
