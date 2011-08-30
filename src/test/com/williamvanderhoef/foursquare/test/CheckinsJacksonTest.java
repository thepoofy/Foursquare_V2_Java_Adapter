package com.williamvanderhoef.foursquare.test;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;
import org.junit.Before;

import com.williamvanderhoef.foursquare.adapters.users.UserCheckinsEndpoint;
import com.williamvanderhoef.foursquare.responses.UserCheckinsResponse;
import com.williamvanderhoef.foursquare.types.Results;

public class CheckinsJacksonTest extends CheckinsTest {
	
	@Before
	@Override
	public void setUp() throws Exception
	{
		super.setUp(); 
		
		ObjectMapper mapper = new ObjectMapper();
		
		Results<UserCheckinsResponse> results = new Results<UserCheckinsResponse>();
		new UserCheckinsEndpoint().defineType();
		results = mapper.readValue(getFileContents(), TypeFactory.type(new UserCheckinsEndpoint().defineType()));
		
		
		this.setResults(results);
	}

}
