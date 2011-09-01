/**
 * 
 */
package com.williamvanderhoef.foursquare.test;


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
import com.williamvanderhoef.foursquare.GsonResultsLoader;
import com.williamvanderhoef.foursquare.JacksonResultsLoader;
import com.williamvanderhoef.foursquare.ResultsLoader;
import com.williamvanderhoef.foursquare.adapters.users.UsersListsEndpoint;
import com.williamvanderhoef.foursquare.model.FoursquareList;
import com.williamvanderhoef.foursquare.responses.UsersListsResponse;
import com.williamvanderhoef.foursquare.types.Group;
import com.williamvanderhoef.foursquare.types.Groups;
import com.williamvanderhoef.foursquare.types.Results;

/**
 * @author Willum
 *
 */
@RunWith(Parameterized.class)
public class ListsTest extends BaseTest<UsersListsResponse> {

	@Override
	public String getFileName()
	{
//		return "src/test/v2.users.self.lists.20110828.json";
		return "src/test/v2.users.self.lists.20110901.json";
	}
	
	@Parameters
	public static Collection<Object[]> generateParams(){
		List<ResultsLoader<UsersListsResponse>> params = new ArrayList<ResultsLoader<UsersListsResponse>>();  
        
		GsonResultsLoader<UsersListsResponse> gLoader = new GsonResultsLoader<UsersListsResponse>(new UsersListsEndpoint());
		params.add(gLoader);
		JacksonResultsLoader<UsersListsResponse> jLoader = new JacksonResultsLoader<UsersListsResponse>(new UsersListsEndpoint());
		params.add(jLoader);
        
		return Arrays.asList(new Object[][] {
				{gLoader},
				{jLoader}
		});
	}
	
	public ListsTest(ResultsLoader<UsersListsResponse> loader)
	{
		this.loader = loader;
	}
	
	private ResultsLoader<UsersListsResponse> loader = null;
	
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
	public void testGroups() {
		
		Results<UsersListsResponse> results = getResults();
		
		Groups<FoursquareList> groups = results.getResponse().getLists();
		
		Assert.assertNotNull(groups);
		
		Assert.assertNotNull(groups.getGroups());
	
		Assert.assertTrue(groups.getGroups().size() >= 4);
	}

	@Test
	public void testValues() {

		List<Group<FoursquareList>> lists = getResults().getResponse().getLists().getGroups();
		
		Group<FoursquareList> list = lists.get(0);
		
		Assert.assertEquals("todos", list.getType());
		Assert.assertEquals("My To-Do List", list.getName());
		Assert.assertEquals(new Integer(1), list.getCount());
		
		Assert.assertNotNull(list.getItems());
		
		List<FoursquareList> myTodoList =list.getItems();
		
		Assert.assertEquals(1, myTodoList.size());
		
		
	}
}
