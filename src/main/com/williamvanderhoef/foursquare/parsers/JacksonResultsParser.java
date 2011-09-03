package com.williamvanderhoef.foursquare.parsers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.codehaus.jackson.JsonNode;
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
import com.williamvanderhoef.foursquare.model.notification.FoursquareObject;
import com.williamvanderhoef.foursquare.model.notification.NotificationTray;
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
		deserializer.registerType("unreadCount", NotificationTray.class);
//		deserializer.registerAnimal("favorite_toy", Cat.class);
//		deserializer.registerAnimal("wing_span", Bird.class);
		
		SimpleModule module = new SimpleModule(
				"PolymorphicNotificationDeserializerModule", new Version(1, 0, 0, null));
		module.addDeserializer(FoursquareObject.class, deserializer);

		return module;  
	}
	
	class NotificationDeserializer extends StdDeserializer<FoursquareObject>  
	{  
	  private Map<String, Class<? extends FoursquareObject>> registry =  
	      new HashMap<String, Class<? extends FoursquareObject>>();  
	  
	  NotificationDeserializer()  
	  {  
	    super(FoursquareObject.class);  
	  }  
	  
	  void registerType(String uniqueAttribute,  
	      Class<? extends FoursquareObject> animalClass)  
	  {  
	    registry.put(uniqueAttribute, animalClass);  
	  }  
	  
	  @Override  
	  public FoursquareObject deserialize(  
	      JsonParser jp, DeserializationContext ctxt)   
	      throws IOException, JsonProcessingException  
	  {  
	    ObjectMapper mapper = (ObjectMapper) jp.getCodec();  
	    ObjectNode root = (ObjectNode) mapper.readTree(jp);  
	    Class<? extends FoursquareObject> animalClass = null;  
	    Iterator<Entry<String, JsonNode>> elementsIterator =   
	        root.getFields();  
	    while (elementsIterator.hasNext())  
	    {  
	      Entry<String, JsonNode> element=elementsIterator.next();  
	      String name = element.getKey();  
	      if (registry.containsKey(name))  
	      {  
	        animalClass = registry.get(name);  
	        break;  
	      }  
	    }  
	    if (animalClass == null) return null;  
	    return mapper.readValue(root, animalClass);  
	  }  
	}  
}
