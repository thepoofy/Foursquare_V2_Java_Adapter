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
import com.williamvanderhoef.foursquare.responses.UsersVenueHistoryResponse;

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
	
	public static DefinedType getEndpoint()
	{
		return new Results<UsersVenueHistoryResponse>(){};
	}
	
	
	@Parameters
	public static Collection<Object[]> generateParams(){
		List<ResultsParser<UsersVenueHistoryResponse>> params = new ArrayList<ResultsParser<UsersVenueHistoryResponse>>();  
        
		GsonResultsParser<UsersVenueHistoryResponse> gLoader = new GsonResultsParser<UsersVenueHistoryResponse>(getEndpoint());
		params.add(gLoader);
		JacksonResultsParser<UsersVenueHistoryResponse> jLoader = new JacksonResultsParser<UsersVenueHistoryResponse>(getEndpoint());
		jLoader.setStrictValidation(true);
		params.add(jLoader);
        
		return Arrays.asList(new Object[][] {
				{gLoader},
				{jLoader}
		});
	}
	
	public VenueHistoryTest(ResultsParser<UsersVenueHistoryResponse> loader)
	{
		this.loader = loader;
	}
	
	private ResultsParser<UsersVenueHistoryResponse> loader = null;
	
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
