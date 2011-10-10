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
import com.williamvanderhoef.foursquare.model.Todo;
import com.williamvanderhoef.foursquare.model.subtypes.Items;
import com.williamvanderhoef.foursquare.model.subtypes.Results;
import com.williamvanderhoef.foursquare.parsers.GsonResultsParser;
import com.williamvanderhoef.foursquare.parsers.JacksonResultsParser;
import com.williamvanderhoef.foursquare.parsers.ResultsParser;
import com.williamvanderhoef.foursquare.responses.UserTodosResponse;

/**
 * @author Willum
 *
 */
@RunWith(Parameterized.class)
public class UserSelfTodosTest extends BaseTest<UserTodosResponse> {

	@Override
	public String getFileName()
	{
		return "src/test/v2.users.self.todos.SelfTodos.json";
	}
	
	public static DefinedType getEndpoint()
	{
		return new Results<UserTodosResponse>(){};
	}
	
	@Parameters
	public static Collection<Object[]> generateParams(){
		List<ResultsParser<UserTodosResponse>> params = new ArrayList<ResultsParser<UserTodosResponse>>();  
        
		GsonResultsParser<UserTodosResponse> gLoader = new GsonResultsParser<UserTodosResponse>(getEndpoint());
		params.add(gLoader);
		JacksonResultsParser<UserTodosResponse> jLoader = new JacksonResultsParser<UserTodosResponse>(getEndpoint());
		jLoader.setStrictValidation(true);
		params.add(jLoader);
        
		return Arrays.asList(new Object[][] {
				{gLoader},
				{jLoader}
		});
	}
	
	
	
	public UserSelfTodosTest(ResultsParser<UserTodosResponse> loader)
	{
		super(loader);
	}
	
	
	@Test
	public void testItems() {
		
		Items<Todo> items = getResults().getResponse().getTodos();
		
		Assert.assertNotNull(items);
	
		Assert.assertFalse(items.getItems().isEmpty());
	}

	@Override
	public void testEquality(Results<UserTodosResponse> original,
			Results<UserTodosResponse> secondBuild) {
		// TODO Auto-generated method stub
		
	}
}
