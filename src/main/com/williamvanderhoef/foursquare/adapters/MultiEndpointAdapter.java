package com.williamvanderhoef.foursquare.adapters;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonStreamParser;
import com.williamvanderhoef.foursquare.responses.MultiResponse;
import com.williamvanderhoef.foursquare.types.Meta;
import com.williamvanderhoef.foursquare.types.Results;

/**
 *
 * @author <a href="mailto://william.vanderhoef@gmail.com">William Vanderhoef</a>
 *
 * @param <T1>
 * @param <T2>
 * @param <T3>
 * @param <T4>
 * @param <T5>
 */
public class MultiEndpointAdapter<T1, T2, T3, T4, T5> extends EndpointAdapter<MultiResponse<T1, T2, T3, T4, T5>>
{
	List<EndpointAdapter> responseAdapters = new ArrayList<EndpointAdapter>();

	public Type defineType(){
		throw new RuntimeException("MultiEndpointAdapter uses dynamic typing and cannot define a type.");
	}

	public void addAdapter(EndpointAdapter adapter){
		if(adapter != null)
		{
			responseAdapters.add(adapter);
		}
	}


//	@Override
//	public Results<MultiResponse<T1, T2, T3, T4, T5>> adapt(String json)
//	{
//		Results<MultiResponse<T1, T2, T3, T4, T5>> multiResults = new Results<MultiResponse<T1, T2, T3, T4, T5>>();
//		MultiResponse<T1, T2, T3, T4, T5> multi = new MultiResponse<T1, T2, T3, T4, T5>();
//
//		int index = 0;
//		if(index < responseAdapters.size())
//			multi.getResult1().setAdapter(responseAdapters.get(index++));
//		if(index < responseAdapters.size())
//			multi.getResult2().setAdapter(responseAdapters.get(index++));
//		if(index < responseAdapters.size())
//			multi.getResult3().setAdapter(responseAdapters.get(index++));
//		if(index < responseAdapters.size())
//			multi.getResult4().setAdapter(responseAdapters.get(index++));
//		if(index < responseAdapters.size())
//			multi.getResult5().setAdapter(responseAdapters.get(index++));
//
//		index = 0;
//
//		Gson g = new Gson();
//
//		JsonStreamParser parser = new JsonStreamParser(json);
//
//		synchronized(parser)
//		{
//			if(parser.hasNext())
//			{
//				JsonElement element = parser.next();
//
//				JsonObject obj = element.getAsJsonObject();
//				JsonObject meta = obj.getAsJsonObject("meta");
//				multiResults.setMeta(g.fromJson(meta, Meta.class));
//
//				JsonObject response = obj.getAsJsonObject("response");
//				JsonArray array = response.getAsJsonArray("responses");
//
//
//				if(index < array.size())
//					multi.getResult1().setResult(multi.getResult1().getAdapter().adapt(array.get(index++)));
//				if(index < array.size())
//					multi.getResult2().setResult(multi.getResult2().getAdapter().adapt(array.get(index++)));
//				if(index < array.size())
//					multi.getResult3().setResult(multi.getResult3().getAdapter().adapt(array.get(index++)));
//				if(index < array.size())
//					multi.getResult4().setResult(multi.getResult4().getAdapter().adapt(array.get(index++)));
//				if(index < array.size())
//					multi.getResult5().setResult(multi.getResult5().getAdapter().adapt(array.get(index++)));
//
//				multiResults.setResponse(multi);
//			}
//		}
//
//		return multiResults;
//	}
}
