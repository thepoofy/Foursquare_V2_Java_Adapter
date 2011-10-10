/**
 * 
 */
package com.williamvanderhoef.foursquare.test.endpoints;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.williamvanderhoef.foursquare.BaseTest;
import com.williamvanderhoef.foursquare.adapters.DefinedType;
import com.williamvanderhoef.foursquare.model.Venue;
import com.williamvanderhoef.foursquare.model.subtypes.Items;
import com.williamvanderhoef.foursquare.model.subtypes.Results;
import com.williamvanderhoef.foursquare.model.subtypes.VenueWrapper;
import com.williamvanderhoef.foursquare.parsers.GsonResultsParser;
import com.williamvanderhoef.foursquare.parsers.JacksonResultsParser;
import com.williamvanderhoef.foursquare.parsers.ResultsParser;
import com.williamvanderhoef.foursquare.responses.UserMayorshipsResponse;

/**
 * @author Willum
 *
 */
@RunWith(Parameterized.class)
public class MayorshipsTest extends BaseTest<UserMayorshipsResponse> {

	@Override
	public String getFileName()
	{
		return "src/test/v2.users.self.mayorships.20110901.json";
	}
	
	public static DefinedType getEndpoint()
	{
		return new Results<UserMayorshipsResponse>(){};
	}
	
	@Parameters
	public static Collection<Object[]> generateParams(){
		List<ResultsParser<UserMayorshipsResponse>> params = new ArrayList<ResultsParser<UserMayorshipsResponse>>();  
        
		GsonResultsParser<UserMayorshipsResponse> gLoader = new GsonResultsParser<UserMayorshipsResponse>(getEndpoint());
		params.add(gLoader);
		JacksonResultsParser<UserMayorshipsResponse> jLoader = new JacksonResultsParser<UserMayorshipsResponse>(getEndpoint());
		jLoader.setStrictValidation(true);
		params.add(jLoader);
        
		return Arrays.asList(new Object[][] {
				{gLoader},
				{jLoader}
		});
	}
	
	public MayorshipsTest(ResultsParser<UserMayorshipsResponse> loader)
	{
		super(loader);
	}
			
	@Test
	public void testItems() {
		
		Results<UserMayorshipsResponse> results = getResults();
		
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

	@Override
	public void testEquality(Results<UserMayorshipsResponse> original,
			Results<UserMayorshipsResponse> secondBuild) {
		// TODO Auto-generated method stub
		
	}
}
