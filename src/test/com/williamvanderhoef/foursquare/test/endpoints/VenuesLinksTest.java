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
import com.williamvanderhoef.foursquare.model.VenueExternalLink;
import com.williamvanderhoef.foursquare.model.subtypes.Items;
import com.williamvanderhoef.foursquare.model.subtypes.Results;
import com.williamvanderhoef.foursquare.parsers.GsonResultsParser;
import com.williamvanderhoef.foursquare.parsers.JacksonResultsParser;
import com.williamvanderhoef.foursquare.parsers.ResultsParser;
import com.williamvanderhoef.foursquare.responses.VenueLinksResponse;

/**
 * @author Willum
 *
 */
@RunWith(Parameterized.class)
public class VenuesLinksTest extends BaseTest<VenueLinksResponse> {

	@Override
	public String getFileName()
	{
		return "src/test/v2.venues.4af82bc2f964a520370b22e3.links.VenuesLinks.json";
	}
	
	public static DefinedType getEndpoint()
	{
		return new Results<VenueLinksResponse>(){};
	}
	
	@Parameters
	public static Collection<Object[]> generateParams(){
		List<ResultsParser<VenueLinksResponse>> params = new ArrayList<ResultsParser<VenueLinksResponse>>();  
        
		GsonResultsParser<VenueLinksResponse> gLoader = new GsonResultsParser<VenueLinksResponse>(getEndpoint());
		params.add(gLoader);
		JacksonResultsParser<VenueLinksResponse> jLoader = new JacksonResultsParser<VenueLinksResponse>(getEndpoint());
		jLoader.setStrictValidation(true);
		params.add(jLoader);
        
		return Arrays.asList(new Object[][] {
				{gLoader},
				{jLoader}
		});
	}
	
	
	
	public VenuesLinksTest(ResultsParser<VenueLinksResponse> loader)
	{
		super(loader);
	}
	
	
	@Test
	public void testItems() {
		
		Items<VenueExternalLink> venues= getResults().getResponse().getLinks();
		
		Assert.assertNotNull(venues);
	
		Assert.assertFalse(venues.getItems().isEmpty());
	}

	@Override
	public void testEquality(Results<VenueLinksResponse> original,
			Results<VenueLinksResponse> secondBuild) {
		// TODO Auto-generated method stub
		
	}
}
