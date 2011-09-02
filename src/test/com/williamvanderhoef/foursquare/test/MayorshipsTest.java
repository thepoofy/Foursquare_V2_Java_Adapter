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
import com.williamvanderhoef.foursquare.adapters.users.UsersMayorshipsEndpoint;
import com.williamvanderhoef.foursquare.model.Venue;
import com.williamvanderhoef.foursquare.parsers.GsonResultsParser;
import com.williamvanderhoef.foursquare.parsers.JacksonResultsParser;
import com.williamvanderhoef.foursquare.parsers.ResultsParser;
import com.williamvanderhoef.foursquare.responses.UsersMayorshipsResponse;
import com.williamvanderhoef.foursquare.types.Items;
import com.williamvanderhoef.foursquare.types.Results;
import com.williamvanderhoef.foursquare.types.VenueWrapper;

/**
 * @author Willum
 *
 */
@RunWith(Parameterized.class)
public class MayorshipsTest extends BaseTest<UsersMayorshipsResponse> {

	@Override
	public String getFileName()
	{
		return "src/test/v2.users.self.mayorships.20110901.json";
	}
	
	@Parameters
	public static Collection<Object[]> generateParams(){
		List<ResultsParser<UsersMayorshipsResponse>> params = new ArrayList<ResultsParser<UsersMayorshipsResponse>>();  
        
		GsonResultsParser<UsersMayorshipsResponse> gLoader = new GsonResultsParser<UsersMayorshipsResponse>(new UsersMayorshipsEndpoint());
		params.add(gLoader);
		JacksonResultsParser<UsersMayorshipsResponse> jLoader = new JacksonResultsParser<UsersMayorshipsResponse>(new UsersMayorshipsEndpoint());
		jLoader.setStrictValidation(true);
		params.add(jLoader);
        
		return Arrays.asList(new Object[][] {
				{gLoader},
				{jLoader}
		});
	}
	
	public MayorshipsTest(ResultsParser<UsersMayorshipsResponse> loader)
	{
		this.loader = loader;
	}
	
	private ResultsParser<UsersMayorshipsResponse> loader = null;
	
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
		
		Results<UsersMayorshipsResponse> results = getResults();
		
		Items<VenueWrapper> items = results.getResponse().getMayorships();
		
		Assert.assertNotNull(items);
	
		Assert.assertNotNull(items.getCount());
		
		Assert.assertNotNull(items.getItems());
	}

	@Test
	public void testValues() {
		
		Items<VenueWrapper> items = getResults().getResponse().getMayorships();
		
		Assert.assertNotNull(items.getItems().get(0));
		
		Venue item = items.getItems().get(0).getVenue();
		
		Assert.assertNotNull(item);
	}
}
