package com.williamvanderhoef.foursquare;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.williamvanderhoef.foursquare.test.endpoints.CheckinAddTest;
import com.williamvanderhoef.foursquare.test.endpoints.CheckinsTest;
import com.williamvanderhoef.foursquare.test.endpoints.ListsTest;
import com.williamvanderhoef.foursquare.test.endpoints.MayorshipsTest;
import com.williamvanderhoef.foursquare.test.endpoints.UserTest;
import com.williamvanderhoef.foursquare.test.endpoints.VenueHistoryTest;

@RunWith(Suite.class)
@SuiteClasses({CheckinsTest.class,
	CheckinAddTest.class,
	ListsTest.class,
	MayorshipsTest.class,
	UserTest.class,
	VenueHistoryTest.class
	})
public class AllTests {

}
