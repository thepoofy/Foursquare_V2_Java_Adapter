/**
 * 
 */
package com.williamvanderhoef.foursquare.test.endpoints;


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
import com.williamvanderhoef.foursquare.adapters.DefinedType;
import com.williamvanderhoef.foursquare.model.VenueHistory;
import com.williamvanderhoef.foursquare.model.subtypes.Items;
import com.williamvanderhoef.foursquare.model.subtypes.Results;
import com.williamvanderhoef.foursquare.parsers.GsonResultsParser;
import com.williamvanderhoef.foursquare.parsers.JacksonResultsParser;
import com.williamvanderhoef.foursquare.parsers.ResultsParser;
import com.williamvanderhoef.foursquare.responses.UserVenueHistoryResponse;

/**
 * @author Willum
 *
 */
@RunWith(Parameterized.class)
public class VenueHistoryTest extends BaseTest<UserVenueHistoryResponse> {

	@Override
	public String getFileName()
	{
		return "src/test/v2.users.self.venuehistory.20110828.json";
	}
	
	public static DefinedType getEndpoint()
	{
		return new Results<UserVenueHistoryResponse>(){};
	}
	
	
	@Parameters
	public static Collection<Object[]> generateParams(){
		List<ResultsParser<UserVenueHistoryResponse>> params = new ArrayList<ResultsParser<UserVenueHistoryResponse>>();  
        
		GsonResultsParser<UserVenueHistoryResponse> gLoader = new GsonResultsParser<UserVenueHistoryResponse>(getEndpoint());
		params.add(gLoader);
		JacksonResultsParser<UserVenueHistoryResponse> jLoader = new JacksonResultsParser<UserVenueHistoryResponse>(getEndpoint());
		jLoader.setStrictValidation(true);
		params.add(jLoader);
        
		return Arrays.asList(new Object[][] {
				{gLoader},
				{jLoader}
		});
	}
	
	public VenueHistoryTest(ResultsParser<UserVenueHistoryResponse> loader)
	{
		this.loader = loader;
	}
	
	private ResultsParser<UserVenueHistoryResponse> loader = null;
	
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
		
		Results<UserVenueHistoryResponse> results = getResults();
		
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
