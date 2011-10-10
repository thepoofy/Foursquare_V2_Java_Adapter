package com.williamvanderhoef.foursquare.test.parsers;

import java.lang.reflect.Type;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.reflect.TypeToken;
import com.williamvanderhoef.foursquare.BaseTest;
import com.williamvanderhoef.foursquare.adapters.DefinedType;
import com.williamvanderhoef.foursquare.model.subtypes.Results;
import com.williamvanderhoef.foursquare.parsers.JacksonResultsParser;
import com.williamvanderhoef.foursquare.responses.CheckinAddResponse;

/**
 * 
 * This test requires GSON
 *
 */
public class JacksonResultsParserTest extends BaseTest<CheckinAddResponse>{

	private static JacksonResultsParser<CheckinAddResponse> loader = new JacksonResultsParser<CheckinAddResponse>(getTypeDefinition());
	
	public JacksonResultsParserTest() {
		super(loader);
	}

	public static DefinedType getTypeDefinition()
	{
		Results<CheckinAddResponse> results = new Results<CheckinAddResponse>(){};
		return results;
	}
	
	@Override
	public String getFileName()
	{
		return "src/test/v2.checkins.add.CheckinsAdd.json";
	}
	
	@Test
	public void endpointTest()
	{
		DefinedType endpoint = getTypeDefinition();
		
		Type endpointType = endpoint.defineType();
		
		Type tokenizedType = new TypeToken<Results<CheckinAddResponse>>() {}.getType();

		Assert.assertEquals(tokenizedType, endpointType);
	}

	@Override
	public void testEquality(Results<CheckinAddResponse> original,
			Results<CheckinAddResponse> secondBuild) {

		// TODO Auto-generated method stub
		
	}
	
}
