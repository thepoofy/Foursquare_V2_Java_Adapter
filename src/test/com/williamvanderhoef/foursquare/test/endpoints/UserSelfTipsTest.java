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
import com.williamvanderhoef.foursquare.model.Tip;
import com.williamvanderhoef.foursquare.model.subtypes.Items;
import com.williamvanderhoef.foursquare.model.subtypes.Results;
import com.williamvanderhoef.foursquare.parsers.GsonResultsParser;
import com.williamvanderhoef.foursquare.parsers.JacksonResultsParser;
import com.williamvanderhoef.foursquare.parsers.ResultsParser;
import com.williamvanderhoef.foursquare.responses.UserTipsResponse;

/**
 * @author Willum
 *
 */
@RunWith(Parameterized.class)
public class UserSelfTipsTest extends BaseTest<UserTipsResponse> {

	@Override
	public String getFileName()
	{
		return "src/test/v2.users.self.tips.SelfTips.json";
	}
	
	public static DefinedType getEndpoint()
	{
		return new Results<UserTipsResponse>(){};
	}
	
	@Parameters
	public static Collection<Object[]> generateParams(){
		List<ResultsParser<UserTipsResponse>> params = new ArrayList<ResultsParser<UserTipsResponse>>();  
        
		GsonResultsParser<UserTipsResponse> gLoader = new GsonResultsParser<UserTipsResponse>(getEndpoint());
		params.add(gLoader);
		JacksonResultsParser<UserTipsResponse> jLoader = new JacksonResultsParser<UserTipsResponse>(getEndpoint());
		jLoader.setStrictValidation(true);
		params.add(jLoader);
        
		return Arrays.asList(new Object[][] {
				{gLoader},
				{jLoader}
		});
	}
	
	
	
	public UserSelfTipsTest(ResultsParser<UserTipsResponse> loader)
	{
		super(loader);
	}
	
	
	@Test
	public void testItems() {
		
		Items<Tip> items = getResults().getResponse().getTips();
		
		Assert.assertNotNull(items);
	
		Assert.assertFalse(items.getItems().isEmpty());
	}

	@Override
	public void testEquality(Results<UserTipsResponse> original,
			Results<UserTipsResponse> secondBuild) {
		// TODO Auto-generated method stub
		
	}
}
