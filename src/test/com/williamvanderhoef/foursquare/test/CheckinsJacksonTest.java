package com.williamvanderhoef.foursquare.test;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.type.JavaType;
import org.junit.Before;

import com.williamvanderhoef.foursquare.adapters.users.UserCheckinsEndpoint;
import com.williamvanderhoef.foursquare.responses.UserCheckinsResponse;
import com.williamvanderhoef.foursquare.types.Results;

public class CheckinsJacksonTest extends CheckinsTest {

	@Before
	@Override
	public void setUp() throws Exception
	{
		super.setUp();

		ObjectMapper mapper = new ObjectMapper();

		DeserializationConfig cfg = mapper.getDeserializationConfig();
		cfg.set(Feature.FAIL_ON_UNKNOWN_PROPERTIES, true);
		mapper.setDeserializationConfig(cfg);


		TypeFactory tf = TypeFactory.defaultInstance();
		JavaType jt = tf.constructType(new UserCheckinsEndpoint().defineType());

		Results<UserCheckinsResponse> results = mapper.readValue(getFileContents(), jt);

		this.setResults(results);
	}

}
