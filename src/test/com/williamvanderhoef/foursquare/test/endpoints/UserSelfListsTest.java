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
import com.williamvanderhoef.foursquare.model.subtypes.Group;
import com.williamvanderhoef.foursquare.model.subtypes.Groups;
import com.williamvanderhoef.foursquare.model.subtypes.Results;
import com.williamvanderhoef.foursquare.parsers.GsonResultsParser;
import com.williamvanderhoef.foursquare.parsers.JacksonResultsParser;
import com.williamvanderhoef.foursquare.parsers.ResultsParser;
import com.williamvanderhoef.foursquare.responses.UserListsResponse;

/**
 * @author Willum
 *
 */
@RunWith(Parameterized.class)
public class UserSelfListsTest extends BaseTest<UserListsResponse> {

	@Override
	public String getFileName()
	{
		return "src/test/v2.users.self.lists.SelfLists.json";
	}

	public static DefinedType getEndpoint()
	{
		return new Results<UserListsResponse>(){};
	}

	@Parameters
	public static Collection<Object[]> generateParams(){
		List<ResultsParser<UserListsResponse>> params = new ArrayList<ResultsParser<UserListsResponse>>();

		GsonResultsParser<UserListsResponse> gLoader = new GsonResultsParser<UserListsResponse>(getEndpoint());
		params.add(gLoader);
		JacksonResultsParser<UserListsResponse> jLoader = new JacksonResultsParser<UserListsResponse>(getEndpoint());
		jLoader.setStrictValidation(true);
		params.add(jLoader);

		return Arrays.asList(new Object[][] {
				{gLoader},
				{jLoader}
		});
	}

	public UserSelfListsTest(ResultsParser<UserListsResponse> loader)
	{
		super(loader);
	}


	@Test
	public void testGroups() {

		Results<UserListsResponse> results = getResults();

		Groups<FoursquareList> groups = results.getResponse().getLists();

		Assert.assertNotNull(groups);

		Assert.assertNotNull(groups.getGroups());

		Assert.assertTrue(groups.getGroups().size() >= 4);
	}

	@Test
	public void testValues() {

		List<Group<FoursquareList>> lists = getResults().getResponse().getLists().getGroups();

		Group<FoursquareList> list = lists.get(1);

		Assert.assertEquals("created", list.getType());
		Assert.assertEquals("Lists I created", list.getName());
		Assert.assertEquals(Integer.valueOf(4), list.getCount());

		Assert.assertNotNull(list.getItems());

//		List<FoursquareList> myTodoList =list.getItems();

//		Assert.assertEquals(4, myTodoList.size());


	}

	@Override
	public void testEquality(Results<UserListsResponse> original,
			Results<UserListsResponse> secondBuild) {
		// TODO Auto-generated method stub
		
	}
}
