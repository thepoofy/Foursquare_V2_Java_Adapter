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
public class UserSelfVenueHistoryTest extends BaseTest<UserVenueHistoryResponse> {

	@Override
	public String getFileName()
	{
		return "src/test/v2.users.self.venuehistory.SelfVenueHistory.json";
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
	
	public UserSelfVenueHistoryTest(ResultsParser<UserVenueHistoryResponse> loader)
	{
		super(loader);
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

	@Override
	public void testEquality(Results<UserVenueHistoryResponse> original,
			Results<UserVenueHistoryResponse> secondBuild) {
		// TODO Auto-generated method stub
		
	}
}
