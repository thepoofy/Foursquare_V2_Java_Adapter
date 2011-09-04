package com.williamvanderhoef.foursquare;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.williamvanderhoef.foursquare.test.CheckinAddTest;
import com.williamvanderhoef.foursquare.test.CheckinsTest;
import com.williamvanderhoef.foursquare.test.ListsTest;
import com.williamvanderhoef.foursquare.test.MayorshipsTest;
import com.williamvanderhoef.foursquare.test.UserTest;
import com.williamvanderhoef.foursquare.test.VenueHistoryTest;

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
