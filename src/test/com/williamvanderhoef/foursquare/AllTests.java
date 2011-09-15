package com.williamvanderhoef.foursquare;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.williamvanderhoef.foursquare.test.endpoints.CheckinAddTest;
import com.williamvanderhoef.foursquare.test.endpoints.CheckinsTest;
import com.williamvanderhoef.foursquare.test.endpoints.ListsTest;
import com.williamvanderhoef.foursquare.test.endpoints.MayorshipsTest;
import com.williamvanderhoef.foursquare.test.endpoints.MultiResultsParserTest;
import com.williamvanderhoef.foursquare.test.endpoints.UserTest;
import com.williamvanderhoef.foursquare.test.endpoints.VenueHistoryTest;
import com.williamvanderhoef.foursquare.test.parsers.GsonResultsParserTest;
import com.williamvanderhoef.foursquare.test.parsers.JacksonResultsParserTest;

@RunWith(Suite.class)
@SuiteClasses({CheckinsTest.class,
	CheckinAddTest.class,
	CheckinsTest.class,
	ListsTest.class,
	MayorshipsTest.class,
	UserTest.class,
	VenueHistoryTest.class,
	MultiResultsParserTest.class,
	
	GsonResultsParserTest.class,
	JacksonResultsParserTest.class
	})
public class AllTests {

}
