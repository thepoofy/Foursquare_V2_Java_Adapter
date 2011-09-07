package com.williamvanderhoef.foursquare.test.parsers;

import java.lang.reflect.Type;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.reflect.TypeToken;
import com.williamvanderhoef.foursquare.BaseTest;
import com.williamvanderhoef.foursquare.adapters.DefinedType;
import com.williamvanderhoef.foursquare.model.subtypes.Results;
import com.williamvanderhoef.foursquare.parsers.GsonResultsParser;
import com.williamvanderhoef.foursquare.responses.CheckinAddResponse;

/**
 * 
 * This test requires GSON
 *
 */
public class GsonResultsParserTest extends BaseTest<CheckinAddResponse>{

	public static DefinedType getTypeDefinition()
	{
		Results<CheckinAddResponse> results = new Results<CheckinAddResponse>(){};
		return results;
	}
	
	@Override
	public String getFileName()
	{
		return "src/test/v2.multi.self_badges.20110904.json";
	}
	
	@Test
	public void endpointTest()
	{
		DefinedType endpoint = getTypeDefinition();
		
		Type endpointType = endpoint.defineType();
		
		Type tokenizedType = new TypeToken<Results<CheckinAddResponse>>() {}.getType();

		Assert.assertEquals(tokenizedType, endpointType);
	}
	
	@Before
	@Override
	public void setUp() throws Exception
	{
		super.setUp();
		
		GsonResultsParser<CheckinAddResponse> gLoader = new GsonResultsParser<CheckinAddResponse>(getTypeDefinition());
		
		Results<CheckinAddResponse> results = gLoader.parse(this.getFileContents());
		
		this.setResults(results);
	}
	
}
