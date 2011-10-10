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
import com.williamvanderhoef.foursquare.model.FoursquareList;
import com.williamvanderhoef.foursquare.model.subtypes.Items;
import com.williamvanderhoef.foursquare.model.subtypes.Results;
import com.williamvanderhoef.foursquare.parsers.GsonResultsParser;
import com.williamvanderhoef.foursquare.parsers.JacksonResultsParser;
import com.williamvanderhoef.foursquare.parsers.ResultsParser;
import com.williamvanderhoef.foursquare.responses.UserListsGroupResponse;

/**
 * @author Willum
 *
 */
@RunWith(Parameterized.class)
public class UserSelfListsGroupTest extends BaseTest<UserListsGroupResponse> {

	@Override
	public String getFileName()
	{
		return "src/test/v2.users.self.lists.SelfListsCreated.json";
	}

	public static DefinedType getEndpoint()
	{
		return new Results<UserListsGroupResponse>(){};
	}

	@Parameters
	public static Collection<Object[]> generateParams(){
		List<ResultsParser<UserListsGroupResponse>> params = new ArrayList<ResultsParser<UserListsGroupResponse>>();

		GsonResultsParser<UserListsGroupResponse> gLoader = new GsonResultsParser<UserListsGroupResponse>(getEndpoint());
		params.add(gLoader);
		JacksonResultsParser<UserListsGroupResponse> jLoader = new JacksonResultsParser<UserListsGroupResponse>(getEndpoint());
		jLoader.setStrictValidation(true);
		params.add(jLoader);

		return Arrays.asList(new Object[][] {
				{gLoader},
				{jLoader}
		});
	}

	public UserSelfListsGroupTest(ResultsParser<UserListsGroupResponse> loader)
	{
		super(loader);
	}


	@Test
	public void testItems() {

		Results<UserListsGroupResponse> results = getResults();

		Items<FoursquareList>lists = results.getResponse().getLists();

		Assert.assertNotNull(lists);

		Assert.assertNotNull(lists.getItems());

		Assert.assertEquals(Integer.valueOf(4), lists.getCount());
	
	}


	@Override
	public void testEquality(Results<UserListsGroupResponse> original,
			Results<UserListsGroupResponse> secondBuild) {
		// TODO Auto-generated method stub
		
	}
}
