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
import com.williamvanderhoef.foursquare.adapters.users.UsersVenueHistoryEndpoint;
import com.williamvanderhoef.foursquare.model.VenueHistory;
import com.williamvanderhoef.foursquare.responses.UsersVenueHistoryResponse;
import com.williamvanderhoef.foursquare.types.Items;
import com.williamvanderhoef.foursquare.types.Results;

/**
 * @author Willum
 *
 */
@RunWith(Parameterized.class)
public class VenueHistoryTest extends BaseTest<UsersVenueHistoryResponse> {

	@Override
	public String getFileName()
	{
		return "src/test/v2.users.self.venuehistory.20110828.json";
	}
	
	@Parameters
	public static Collection<Object[]> generateParams(){
		List<ResultsLoader<UsersVenueHistoryResponse>> params = new ArrayList<ResultsLoader<UsersVenueHistoryResponse>>();  
        
		GsonResultsLoader<UsersVenueHistoryResponse> gLoader = new GsonResultsLoader<UsersVenueHistoryResponse>(new UsersVenueHistoryEndpoint());
		params.add(gLoader);
		JacksonResultsLoader<UsersVenueHistoryResponse> jLoader = new JacksonResultsLoader<UsersVenueHistoryResponse>(new UsersVenueHistoryEndpoint());
		params.add(jLoader);
        
		return Arrays.asList(new Object[][] {
				{gLoader},
				{jLoader}
		});
	}
	
	public VenueHistoryTest(ResultsLoader<UsersVenueHistoryResponse> loader)
	{
		this.loader = loader;
	}
	
	private ResultsLoader<UsersVenueHistoryResponse> loader = null;
	
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
		
		Results<UsersVenueHistoryResponse> results = getResults();
		
		Items<VenueHistory> items = results.getResponse().getVenues();
		
		Assert.assertNotNull(items);
	
		Assert.assertNotNull(items.getCount());
		
		Assert.assertNotNull(items.getItems());
	}

	@Test
	public void testValues() {
//		fail("Not yet implemented");
		
		Items<VenueHistory> checkins = getResults().getResponse().getVenues();
		
		VenueHistory ck = checkins.getItems().get(0);
		
		Assert.assertNotNull(ck);
	}
}
