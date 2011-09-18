/**
 *
 */
package com.williamvanderhoef.foursquare.test.endpoints;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.williamvanderhoef.foursquare.BaseTest;
import com.williamvanderhoef.foursquare.adapters.DefinedType;
import com.williamvanderhoef.foursquare.model.FoursquareList;
import com.williamvanderhoef.foursquare.model.subtypes.Group;
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
public class ListsGroupTest extends BaseTest<UserListsGroupResponse> {

	@Override
	public String getFileName()
	{
		return "src/test/v2.users.self.lists.SelfCreatedLists.20110917.json";
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

	public ListsGroupTest(ResultsParser<UserListsGroupResponse> loader)
	{
		this.loader = loader;
	}

	private ResultsParser<UserListsGroupResponse> loader = null;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	@Override
	public void setUp() throws Exception {

		super.setUp();

		this.setResults(loader.parse(this.getFileContents()));
	}


	@Test
	public void testItems() {

		Results<UserListsGroupResponse> results = getResults();

		Items<FoursquareList>lists = results.getResponse().getLists();

		Assert.assertNotNull(lists);

		Assert.assertNotNull(lists.getItems());

		Assert.assertNotNull(lists.getCount());
		
		Assert.assertTrue(lists.getCount().equals(Integer.valueOf(2)));
	}
//
//	@Test
//	public void testValues() {
//
//		List<Group<FoursquareList>> lists = getResults().getResponse().getLists().getGroups();
//
//		Group<FoursquareList> list = lists.get(0);
//
//		Assert.assertEquals("todos", list.getType());
//		Assert.assertEquals("My To-Do List", list.getName());
//		Assert.assertEquals(Integer.valueOf(1), list.getCount());
//
//		Assert.assertNotNull(list.getItems());
//
//		List<FoursquareList> myTodoList =list.getItems();
//
//		Assert.assertEquals(1, myTodoList.size());
//
//
//	}
}
