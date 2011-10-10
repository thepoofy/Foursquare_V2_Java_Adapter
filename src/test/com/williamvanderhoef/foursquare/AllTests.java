package com.williamvanderhoef.foursquare;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.williamvanderhoef.foursquare.test.endpoints.CheckinsAddTest;
import com.williamvanderhoef.foursquare.test.endpoints.ListDetailsTest;
import com.williamvanderhoef.foursquare.test.endpoints.MultiResultsParserTest;
import com.williamvanderhoef.foursquare.test.endpoints.UserSelfBadgesTest;
import com.williamvanderhoef.foursquare.test.endpoints.UserSelfCheckinsTest;
import com.williamvanderhoef.foursquare.test.endpoints.UserSelfFriendsTest;
import com.williamvanderhoef.foursquare.test.endpoints.UserSelfListsGroupTest;
import com.williamvanderhoef.foursquare.test.endpoints.UserSelfListsTest;
import com.williamvanderhoef.foursquare.test.endpoints.UserSelfMayorshipsTest;
import com.williamvanderhoef.foursquare.test.endpoints.UserSelfTest;
import com.williamvanderhoef.foursquare.test.endpoints.UserSelfTipsTest;
import com.williamvanderhoef.foursquare.test.endpoints.UserSelfTodosTest;
import com.williamvanderhoef.foursquare.test.endpoints.UserSelfVenueHistoryTest;
import com.williamvanderhoef.foursquare.test.endpoints.VenuesSearchTest;
import com.williamvanderhoef.foursquare.test.parsers.GsonResultsParserTest;
import com.williamvanderhoef.foursquare.test.parsers.JacksonResultsParserTest;

@RunWith(Suite.class)
@SuiteClasses({
	CheckinsAddTest.class,
	
	ListDetailsTest.class,
	
	MultiResultsParserTest.class,
	
	UserSelfTest.class,
	UserSelfBadgesTest.class,
	UserSelfCheckinsTest.class,
	UserSelfFriendsTest.class,
	UserSelfListsTest.class,
	UserSelfListsGroupTest.class,
	UserSelfMayorshipsTest.class,
	UserSelfTipsTest.class,
	UserSelfTodosTest.class,
	UserSelfVenueHistoryTest.class,
	
	VenuesSearchTest.class,
	
	GsonResultsParserTest.class,
	JacksonResultsParserTest.class
	})
public class AllTests {

}
