package com.williamvanderhoef.foursquare.parsers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.Module;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.deser.StdDeserializer;
import org.codehaus.jackson.map.module.SimpleModule;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.node.ObjectNode;
import org.codehaus.jackson.type.JavaType;

import com.williamvanderhoef.foursquare.adapters.EndpointAdapter;
import com.williamvanderhoef.foursquare.model.notification.Notification;
import com.williamvanderhoef.foursquare.model.notification.Notifications;
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

		mapper.registerModule(createNotificationModule());

		TypeFactory tf = TypeFactory.defaultInstance();
		JavaType jt = tf.constructType(adapter.defineType());

		return mapper.readValue(fileContents, jt);

	}

	
	private Module createNotificationModule()
	{
		NotificationDeserializer deserializer = new NotificationDeserializer();
		
		//specify a unique class attribute and the class that it is unique for
		for(Notifications.NotificationType type: Notifications.NotificationType.values())
		{
			deserializer.registerType(type.name(),type.getTypeOf());
		}
		
		SimpleModule module = new SimpleModule(
				"PolymorphicNotificationDeserializerModule", new Version(1, 0, 0, null));
		module.addDeserializer(Notifications.class, deserializer);

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
}
