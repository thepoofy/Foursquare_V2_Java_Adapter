package com.williamvanderhoef.foursquare;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.type.JavaType;

import com.williamvanderhoef.foursquare.adapters.EndpointAdapter;
import com.williamvanderhoef.foursquare.types.Results;


public class JacksonResultsLoader<T> implements ResultsLoader<T> {

	private EndpointAdapter adapter;
	
	public JacksonResultsLoader(EndpointAdapter adapter) {
		
		this.adapter = adapter;
	}
	
	public Results<T> parse(String fileContents) throws Exception
	{
		ObjectMapper mapper = new ObjectMapper();

		DeserializationConfig cfg = mapper.getDeserializationConfig();
		cfg.set(Feature.FAIL_ON_UNKNOWN_PROPERTIES, true);
		mapper.setDeserializationConfig(cfg);


		TypeFactory tf = TypeFactory.defaultInstance();
		JavaType jt = tf.constructType(adapter.defineType());

		return mapper.readValue(fileContents, jt);

	}

}
