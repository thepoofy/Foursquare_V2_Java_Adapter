package com.williamvanderhoef.foursquare.parsers;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.type.JavaType;

import com.williamvanderhoef.foursquare.adapters.EndpointAdapter;
import com.williamvanderhoef.foursquare.types.Results;


public class JacksonResultsParser<T> implements ResultsParser<T> {

	@SuppressWarnings({ "rawtypes" })
	private EndpointAdapter adapter;
	
	private boolean isStrictValidation = false;
	
	@SuppressWarnings({ "rawtypes" })
	public JacksonResultsParser(EndpointAdapter adapter) {
		
		this.adapter = adapter;
	}
	
	public void setStrictValidation(boolean isStrict)
	{
		this.isStrictValidation = isStrict;
	}
	
	public Results<T> parse(String fileContents) throws Exception
	{
		ObjectMapper mapper = new ObjectMapper();

		DeserializationConfig cfg = mapper.getDeserializationConfig();
		cfg.set(Feature.FAIL_ON_UNKNOWN_PROPERTIES, isStrictValidation);
		mapper.setDeserializationConfig(cfg);


		TypeFactory tf = TypeFactory.defaultInstance();
		JavaType jt = tf.constructType(adapter.defineType());

		return mapper.readValue(fileContents, jt);

	}

}
