package com.williamvanderhoef.foursquare.test.endpoints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.williamvanderhoef.foursquare.BaseTest;
import com.williamvanderhoef.foursquare.adapters.DefinedType;
import com.williamvanderhoef.foursquare.model.subtypes.Results;
import com.williamvanderhoef.foursquare.parsers.GsonResultsParser;
import com.williamvanderhoef.foursquare.parsers.JacksonResultsParser;
import com.williamvanderhoef.foursquare.parsers.ResultsParser;
import com.williamvanderhoef.foursquare.responses.Responses;
import com.williamvanderhoef.foursquare.responses.VenueSearchResponse;

/**
 * 
 * This test requires GSON
 *
 */
@RunWith(Parameterized.class)
public class MultiResultsParserTest extends BaseTest<Responses>{

	@Override
	public String getFileName()
	{
		return "src/test/v2.multi.MultiVenuesVenues.json";
	}
	
	public static DefinedType getEndpoint()
	{
		return new Results<Responses>(){};
	}
	
	@Parameters
	public static Collection<Object[]> generateParams(){
		List<ResultsParser<Responses>> params = new ArrayList<ResultsParser<Responses>>();  
        
		GsonResultsParser<Responses> gLoader = new GsonResultsParser<Responses>(getEndpoint());
		params.add(gLoader);
		JacksonResultsParser<Responses> jLoader = new JacksonResultsParser<Responses>(getEndpoint());
		jLoader.setStrictValidation(true);
		params.add(jLoader);
        
		return Arrays.asList(new Object[][] {
				{gLoader},
				{jLoader}
		});
	}
	
	public MultiResultsParserTest(ResultsParser<Responses> loader)
	{
		super(loader);
	}
	
	@Test
	public void test3() throws Exception
	{
		List<String> responses = this.getResults().getResponse().getResponses();
		
		Assert.assertNotNull(responses);
//		System.out.println("Responses: "+responses);
		Assert.assertEquals(2, responses.size());
//		System.out.println("Responses Size: "+responses.size());
		for(String res : responses)
		{
			Assert.assertNotNull(res);
//			System.out.println("Response: "+res);
			
			GsonResultsParser<VenueSearchResponse> gLoader = new GsonResultsParser<VenueSearchResponse>(getSubEndpoint());
			
			Results<VenueSearchResponse> venues = gLoader.fromJson(res);
			
			Assert.assertNotNull(venues);
			Assert.assertNotNull(venues.getResponse());
			Assert.assertNotNull(venues.getResponse().getVenues());
		}
		
	}
	
	public static DefinedType getSubEndpoint()
	{
		return new Results<VenueSearchResponse>(){};
	}

	@Override
	public void testEquality(Results<Responses> original,
			Results<Responses> secondBuild) {
		// TODO Auto-generated method stub
		
	}
}
