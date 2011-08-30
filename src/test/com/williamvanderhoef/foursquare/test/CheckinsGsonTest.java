package com.williamvanderhoef.foursquare.test;

import org.junit.Before;

import com.google.gson.Gson;
import com.williamvanderhoef.foursquare.adapters.EndpointAdapter;
import com.williamvanderhoef.foursquare.adapters.users.UserCheckinsEndpoint;
import com.williamvanderhoef.foursquare.responses.UserCheckinsResponse;
import com.williamvanderhoef.foursquare.types.Results;

public class CheckinsGsonTest extends CheckinsTest {

	@Before
	@Override
	public void setUp() throws Exception
	{
		super.setUp();

		EndpointAdapter<UserCheckinsResponse> checkinAdapter = new UserCheckinsEndpoint();

		Gson g = new Gson();
		Results<UserCheckinsResponse> results = g.fromJson(this.getFileContents(), checkinAdapter.defineType());

		this.setResults(results);
	}

}
