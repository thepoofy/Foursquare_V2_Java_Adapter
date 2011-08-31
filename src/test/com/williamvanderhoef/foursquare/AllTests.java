package com.williamvanderhoef.foursquare;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.williamvanderhoef.foursquare.test.CheckinsTest;
import com.williamvanderhoef.foursquare.test.VenueHistoryTest;

@RunWith(Suite.class)
@SuiteClasses({CheckinsTest.class, VenueHistoryTest.class})
public class AllTests {

}
