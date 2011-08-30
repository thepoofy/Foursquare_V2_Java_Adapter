package com.williamvanderhoef.foursquare.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({CheckinsGsonTest.class, CheckinsJacksonTest.class})
public class AllTests {

}
