/**
 * 
 */
package com.williamvanderhoef.foursquare.test.endpoints;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.williamvanderhoef.foursquare.BaseTest;
import com.williamvanderhoef.foursquare.adapters.DefinedType;
import com.williamvanderhoef.foursquare.model.Badge;
import com.williamvanderhoef.foursquare.model.subtypes.Results;
import com.williamvanderhoef.foursquare.parsers.GsonResultsParser;
import com.williamvanderhoef.foursquare.parsers.JacksonResultsParser;
import com.williamvanderhoef.foursquare.parsers.ResultsParser;
import com.williamvanderhoef.foursquare.responses.UserBadgesResponse;

/**
 * @author Willum
 *
 */
@RunWith(Parameterized.class)
public class UserSelfBadgesTest extends BaseTest<UserBadgesResponse> {

	@Override
	public String getFileName()
	{
		return "src/test/v2.users.self.badges.SelfBadges.json";
	}
	
	public static DefinedType getEndpoint()
	{
		return new Results<UserBadgesResponse>(){};
	}
	
	@Parameters
	public static Collection<Object[]> generateParams(){
		List<ResultsParser<UserBadgesResponse>> params = new ArrayList<ResultsParser<UserBadgesResponse>>();  
        
		GsonResultsParser<UserBadgesResponse> gLoader = new GsonResultsParser<UserBadgesResponse>(getEndpoint());
		params.add(gLoader);
		JacksonResultsParser<UserBadgesResponse> jLoader = new JacksonResultsParser<UserBadgesResponse>(getEndpoint());
		jLoader.setStrictValidation(true);
		params.add(jLoader);
        
		return Arrays.asList(new Object[][] {
				{gLoader},
				{jLoader}
		});
	}
	
	
	
	public UserSelfBadgesTest(ResultsParser<UserBadgesResponse> loader)
	{
		super(loader);
	}
	
	
	@Test
	public void testItems() {
		
		Map<String, Badge> badges = getResults().getResponse().getBadges();
		
		Assert.assertNotNull(badges);
	
		Assert.assertFalse(badges.isEmpty());
		
		Assert.assertTrue(badges.values().size() > 0);
	}

	@Test
	public void testCheckins() 
	{
		Map<String, Badge> badges = getResults().getResponse().getBadges();
		
		Collection<Badge> badgeList = badges.values();
		
		Assert.assertNotNull(badgeList);
	}

	@Override
	public void testEquality(Results<UserBadgesResponse> original,
			Results<UserBadgesResponse> secondBuild) {
		// TODO Auto-generated method stub
		
	}
}
