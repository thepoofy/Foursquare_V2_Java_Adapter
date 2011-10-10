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
import com.williamvanderhoef.foursquare.model.subtypes.Results;
import com.williamvanderhoef.foursquare.parsers.GsonResultsParser;
import com.williamvanderhoef.foursquare.parsers.JacksonResultsParser;
import com.williamvanderhoef.foursquare.parsers.ResultsParser;
import com.williamvanderhoef.foursquare.responses.VenueSearchResponse;

/**
 * @author Willum
 *
 */
@RunWith(Parameterized.class)
public class VenuesSearchTest extends BaseTest<VenueSearchResponse> {

	@Override
	public String getFileName()
	{
		return "src/test/v2.venues.search.VenueSearch.json";
	}
	
	public static DefinedType getEndpoint()
	{
		return new Results<VenueSearchResponse>(){};
	}
	
	@Parameters
	public static Collection<Object[]> generateParams(){
		List<ResultsParser<VenueSearchResponse>> params = new ArrayList<ResultsParser<VenueSearchResponse>>();  
        
		GsonResultsParser<VenueSearchResponse> gLoader = new GsonResultsParser<VenueSearchResponse>(getEndpoint());
		params.add(gLoader);
		JacksonResultsParser<VenueSearchResponse> jLoader = new JacksonResultsParser<VenueSearchResponse>(getEndpoint());
		jLoader.setStrictValidation(true);
		params.add(jLoader);
        
		return Arrays.asList(new Object[][] {
				{gLoader},
				{jLoader}
		});
	}
	
	
	
	public VenuesSearchTest(ResultsParser<VenueSearchResponse> loader)
	{
		super(loader);
	}
	
	
	@Test
	public void testItems() {
		
		List<Venue> venues= getResults().getResponse().getVenues();
		
		Assert.assertNotNull(venues);
	
		Assert.assertFalse(venues.isEmpty());
	}

	@Override
	public void testEquality(Results<VenueSearchResponse> original,
			Results<VenueSearchResponse> secondBuild) {
		// TODO Auto-generated method stub
		
	}
}
