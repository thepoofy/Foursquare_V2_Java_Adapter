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
import com.williamvanderhoef.foursquare.model.Contact;
import com.williamvanderhoef.foursquare.model.User;
import com.williamvanderhoef.foursquare.model.UserDetails;
import com.williamvanderhoef.foursquare.model.subtypes.Count;
import com.williamvanderhoef.foursquare.model.subtypes.Results;
import com.williamvanderhoef.foursquare.parsers.GsonResultsParser;
import com.williamvanderhoef.foursquare.parsers.JacksonResultsParser;
import com.williamvanderhoef.foursquare.parsers.ResultsParser;
import com.williamvanderhoef.foursquare.responses.UserResponse;

/**
 * @author Willum
 *
 */
@RunWith(Parameterized.class)
public class UserSelfTest extends BaseTest<UserResponse> {

	@Override
	public String getFileName()
	{
		return "src/test/v2.users.self.Self.json";
	}

	public static DefinedType getEndpoint()
	{
		return new Results<UserResponse>(){};
	}


	@Parameters
	public static Collection<Object[]> generateParams(){
		List<ResultsParser<UserResponse>> params = new ArrayList<ResultsParser<UserResponse>>();

		GsonResultsParser<UserResponse> gLoader = new GsonResultsParser<UserResponse>(getEndpoint());
		params.add(gLoader);
		JacksonResultsParser<UserResponse> jLoader = new JacksonResultsParser<UserResponse>(getEndpoint());
		jLoader.setStrictValidation(true);
		params.add(jLoader);

		return Arrays.asList(new Object[][] {
				{gLoader},
				{jLoader}
		});
	}

	public UserSelfTest(ResultsParser<UserResponse> loader)
	{
		super(loader);
	}

	@Test
	public void testUser() {

		Results<UserResponse> results = getResults();

		UserDetails user = results.getResponse().getUser();

		Assert.assertNotNull(user);

		Assert.assertEquals("Will",user.getFirstName());

		Assert.assertEquals("Vanderhoef",user.getLastName());

		Assert.assertEquals(User.Gender.male, user.getGender());

		Assert.assertEquals(User.Relationship.self,user.getRelationship());


		Contact contact = user.getContact();
		Assert.assertNotNull(contact);
		Assert.assertEquals("thepoofy",contact.getTwitter());
		Assert.assertEquals("6313352247", contact.getPhone());


		Count badgeCount = user.getBadges();
		Assert.assertNotNull(badgeCount);
		Assert.assertEquals(Integer.valueOf(84), badgeCount.getCount());

		//TODO expect this to become null in the near future, should become a Count object
		Assert.assertNotNull(user.getMayorships().getItems());

		//TODO add more tests

	}

	@Override
	public void testEquality(Results<UserResponse> original,
			Results<UserResponse> secondBuild) {
		// TODO Auto-generated method stub
		
	}

}
