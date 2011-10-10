package com.williamvanderhoef.foursquare.parsers;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.Module;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.deser.StdDeserializer;
import org.codehaus.jackson.map.module.SimpleModule;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.node.ObjectNode;
import org.codehaus.jackson.type.JavaType;

import com.williamvanderhoef.foursquare.adapters.DefinedType;
import com.williamvanderhoef.foursquare.adapters.JsonSyntaxException;
import com.williamvanderhoef.foursquare.model.notification.Notification;
import com.williamvanderhoef.foursquare.model.notification.Notifications;
import com.williamvanderhoef.foursquare.model.subtypes.Results;
import com.williamvanderhoef.foursquare.responses.Responses;


public class JacksonResultsParser<T> implements ResultsParser<T> {

	private DefinedType adapter;
	
	private boolean isStrictValidation = false;
	
	private ObjectMapper mapper = new ObjectMapper();
	
	public JacksonResultsParser(DefinedType adapter) {
		
		this.adapter = adapter;
		
		init();
	}
	
	public JacksonResultsParser() {
		
		init();
	}
	
	private void init(){
		DeserializationConfig cfg = mapper.getDeserializationConfig();
		cfg.set(Feature.FAIL_ON_UNKNOWN_PROPERTIES, isStrictValidation);
		mapper.setDeserializationConfig(cfg);

		SerializationConfig config = mapper.getSerializationConfig();
		config.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
		
		mapper.registerModule(createNotificationModule());
	}
	
	/**
	 * Used for testing json and forcing it to throw an exception when an unknown element is discovered while parsing.
	 * 
	 * @param isStrict
	 */
	public void setStrictValidation(boolean isStrict)
	{
		this.isStrictValidation = isStrict;
	}
	
	
	@Override
	public T simpleFromJson(String json, Type t)throws JsonSyntaxException{
		try
		{
			TypeFactory tf = TypeFactory.defaultInstance();
			
			JavaType jt = tf.constructType(t);
			
			return mapper.readValue(json, jt );	
		}
		catch(JsonMappingException e)
		{
			throw new JsonSyntaxException(e);
		}
		catch(JsonParseException e)
		{
			throw new JsonSyntaxException(e);
		}
		catch(IOException e)
		{
			throw new JsonSyntaxException(e);
		}
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see com.williamvanderhoef.foursquare.parsers.ResultsParser#fromJson(java.lang.String)
	 */
	public Results<T> fromJson(String fileContents) throws JsonSyntaxException
	{
		TypeFactory tf = TypeFactory.defaultInstance();
		
		JavaType jt = tf.constructType(adapter.defineType());

		try
		{
			return mapper.readValue(fileContents, jt);	
		}
		catch(Exception e)
		{
			throw new JsonSyntaxException(e);
		}
	}

	public String toJson(Object object) throws JsonSyntaxException
	{
		
		try
		{
			return mapper.writeValueAsString(object);	
		}
		catch(JsonGenerationException e)
		{
			throw new JsonSyntaxException(e);
		}
		catch(JsonMappingException e)
		{
			throw new JsonSyntaxException(e);
		}
		catch(IOException e)
		{
			throw new JsonSyntaxException(e);
		}
	}
	
	private Module createNotificationModule()
	{
		NotificationDeserializer notificationDeserializer = new NotificationDeserializer();
		ResponsesDeserializer resDes= new ResponsesDeserializer(); 
		
		//specify a unique class attribute and the class that it is unique for
		for(Notifications.NotificationType type: Notifications.NotificationType.values())
		{
			notificationDeserializer.registerType(type.name(),type.getTypeOf());
		}
		
		SimpleModule module = new SimpleModule(
				"PolymorphicNotificationDeserializerModule", new Version(1, 0, 0, null));
		module.addDeserializer(Notifications.class, notificationDeserializer);
		module.addDeserializer(Responses.class, resDes);
		
		return module;  
	}
	
	class NotificationDeserializer extends StdDeserializer<Notifications>  
	{  
		private Map<String, Class<? extends Notification>> registry = new HashMap<String, Class<? extends Notification>>();

		NotificationDeserializer() {
			super(Notifications.class);
		}

		void registerType(String uniqueAttribute, Class<? extends Notification> animalClass) {
			registry.put(uniqueAttribute, animalClass);
		}
	  
		@Override
		public Notifications deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException 
		{
			ObjectMapper mapper = (ObjectMapper) jp.getCodec();
			ObjectNode fsqObject = (ObjectNode) mapper.readTree(jp);
			
			if(fsqObject.has("item") 
					&& fsqObject.has("type")
					&& registry.get(fsqObject.get("type").getValueAsText()) != null)
			{
				String type = fsqObject.get("type").getValueAsText();
				
				Class<? extends Notification> instanceClass = registry.get(type);
				
				Notification n = mapper.readValue(fsqObject.get("item"), instanceClass);
				
				Notifications notifications = new Notifications();
				notifications.setType(type);
				notifications.setItem(n);
				
				return notifications;
			}
			
			return null;
		}
	}
	
	class ResponsesDeserializer extends StdDeserializer<Responses>  
	{  
		ResponsesDeserializer() {
			super(Responses.class);
		}
	  
		@Override
		public Responses deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException 
		{
			ObjectMapper mapper = (ObjectMapper) jp.getCodec();
			ObjectNode fsqObject = (ObjectNode) mapper.readTree(jp);
			
			if(fsqObject.has("responses") 
					&& fsqObject.get("responses").isArray())
			{
				Iterator<JsonNode> responses = fsqObject.get("responses").getElements();
				
				List<String> res = new ArrayList<String>();
				
				while(responses.hasNext())
				{
					res.add(responses.next().toString());
				}
				
				Responses myResponses = new Responses();
				myResponses.setResponses(res);
				
				return myResponses;
			}
			
			return null;
		}
	}
}
