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
import com.williamvanderhoef.foursquare.model.subtypes.Groups;
import com.williamvanderhoef.foursquare.model.subtypes.Results;
import com.williamvanderhoef.foursquare.parsers.GsonResultsParser;
import com.williamvanderhoef.foursquare.parsers.JacksonResultsParser;
import com.williamvanderhoef.foursquare.parsers.ResultsParser;
import com.williamvanderhoef.foursquare.responses.FoursquareListDetailResponse;
import com.williamvanderhoef.foursquare.responses.FoursquareListDetailResponse;

/**
 * @author Willum
 *
 */
@RunWith(Parameterized.class)
public class ListDetailsTest extends BaseTest<FoursquareListDetailResponse> {

	@Override
	public String getFileName()
	{
		return "src/test/v2.lists.4e725193d22dbd6261a1839e.ListDetails.20110917.json";
	}

	public static DefinedType getEndpoint()
	{
		return new Results<FoursquareListDetailResponse>(){};
	}

	@Parameters
	public static Collection<Object[]> generateParams(){
		List<ResultsParser<FoursquareListDetailResponse>> params = new ArrayList<ResultsParser<FoursquareListDetailResponse>>();

		GsonResultsParser<FoursquareListDetailResponse> gLoader = new GsonResultsParser<FoursquareListDetailResponse>(getEndpoint());
		params.add(gLoader);
		JacksonResultsParser<FoursquareListDetailResponse> jLoader = new JacksonResultsParser<FoursquareListDetailResponse>(getEndpoint());
		jLoader.setStrictValidation(true);
		params.add(jLoader);

		return Arrays.asList(new Object[][] {
				{gLoader},
				{jLoader}
		});
	}

	public ListDetailsTest(ResultsParser<FoursquareListDetailResponse> loader)
	{
		this.loader = loader;
	}

	private ResultsParser<FoursquareListDetailResponse> loader = null;

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
	public void testList() {

		Results<FoursquareListDetailResponse> results = getResults();

		FoursquareList list = results.getResponse().getList();

		Assert.assertNotNull(list);

		Assert.assertNotNull(list.getName());

		Assert.assertNotNull(list.getListItems());
		
		Assert.assertEquals(Integer.valueOf(6), list.getListItems().getCount());
	}

	
}
