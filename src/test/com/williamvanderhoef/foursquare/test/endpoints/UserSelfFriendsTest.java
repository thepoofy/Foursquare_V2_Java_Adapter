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
import com.williamvanderhoef.foursquare.model.User;
import com.williamvanderhoef.foursquare.model.subtypes.Items;
import com.williamvanderhoef.foursquare.model.subtypes.Results;
import com.williamvanderhoef.foursquare.parsers.GsonResultsParser;
import com.williamvanderhoef.foursquare.parsers.JacksonResultsParser;
import com.williamvanderhoef.foursquare.parsers.ResultsParser;
import com.williamvanderhoef.foursquare.responses.UserFriendsResponse;

/**
 * @author Willum
 *
 */
@RunWith(Parameterized.class)
public class UserSelfFriendsTest extends BaseTest<UserFriendsResponse> {

	@Override
	public String getFileName()
	{
		return "src/test/v2.users.self.friends.SelfFriends.json";
	}
	
	public static DefinedType getEndpoint()
	{
		return new Results<UserFriendsResponse>(){};
	}
	
	@Parameters
	public static Collection<Object[]> generateParams(){
		List<ResultsParser<UserFriendsResponse>> params = new ArrayList<ResultsParser<UserFriendsResponse>>();  
        
		GsonResultsParser<UserFriendsResponse> gLoader = new GsonResultsParser<UserFriendsResponse>(getEndpoint());
		params.add(gLoader);
		JacksonResultsParser<UserFriendsResponse> jLoader = new JacksonResultsParser<UserFriendsResponse>(getEndpoint());
		jLoader.setStrictValidation(true);
		params.add(jLoader);
        
		return Arrays.asList(new Object[][] {
				{gLoader},
				{jLoader}
		});
	}
	
	
	
	public UserSelfFriendsTest(ResultsParser<UserFriendsResponse> loader)
	{
		super(loader);
	}
	
	
	@Test
	public void testItems() {
		
		Items<User> items = getResults().getResponse().getFriends();
		
		Assert.assertNotNull(items);
	
		Assert.assertFalse(items.getItems().isEmpty());
	}

	@Override
	public void testEquality(Results<UserFriendsResponse> original,
			Results<UserFriendsResponse> secondBuild) {
		// TODO Auto-generated method stub
		
	}
}
