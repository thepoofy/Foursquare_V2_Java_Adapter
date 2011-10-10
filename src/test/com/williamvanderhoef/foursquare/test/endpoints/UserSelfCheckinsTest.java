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
import com.williamvanderhoef.foursquare.model.Checkin;
import com.williamvanderhoef.foursquare.model.subtypes.Items;
import com.williamvanderhoef.foursquare.model.subtypes.Results;
import com.williamvanderhoef.foursquare.parsers.GsonResultsParser;
import com.williamvanderhoef.foursquare.parsers.JacksonResultsParser;
import com.williamvanderhoef.foursquare.parsers.ResultsParser;
import com.williamvanderhoef.foursquare.responses.UserCheckinsResponse;

/**
 * @author Willum
 *
 */
@RunWith(Parameterized.class)
public class UserSelfCheckinsTest extends BaseTest<UserCheckinsResponse> {

	@Override
	public String getFileName()
	{
		return "src/test/v2.users.self.checkins.SelfCheckins.json";
	}
	
	public static DefinedType getEndpoint()
	{
		return new Results<UserCheckinsResponse>(){};
	}
	
	@Parameters
	public static Collection<Object[]> generateParams(){
		List<ResultsParser<UserCheckinsResponse>> params = new ArrayList<ResultsParser<UserCheckinsResponse>>();  
        
		GsonResultsParser<UserCheckinsResponse> gLoader = new GsonResultsParser<UserCheckinsResponse>(getEndpoint());
		params.add(gLoader);
		JacksonResultsParser<UserCheckinsResponse> jLoader = new JacksonResultsParser<UserCheckinsResponse>(getEndpoint());
		jLoader.setStrictValidation(true);
		params.add(jLoader);
        
		return Arrays.asList(new Object[][] {
				{gLoader},
				{jLoader}
		});
	}
	
	
	
	public UserSelfCheckinsTest(ResultsParser<UserCheckinsResponse> loader)
	{
		super(loader);
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

	@Override
	public void testEquality(Results<UserCheckinsResponse> original,
			Results<UserCheckinsResponse> secondBuild) {
		// TODO Auto-generated method stub
		
	}
}
