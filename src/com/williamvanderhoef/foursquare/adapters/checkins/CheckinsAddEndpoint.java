package com.williamvanderhoef.foursquare.adapters.checkins;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.williamvanderhoef.foursquare.adapters.EndpointAdapter;
import com.williamvanderhoef.foursquare.responses.CheckinAddResponse;
import com.williamvanderhoef.foursquare.types.Results;

/**
 * 
 * http://developer.foursquare.com/docs/checkins/add.html
 * 
 * @author <a href="mailto://william.vanderhoef@gmail.com">William Vanderhoef</a>
 *
 */
public class CheckinsAddEndpoint implements EndpointAdapter<CheckinAddResponse>
{

	@Override
	public Results<CheckinAddResponse> adapt(String responseText)
	{
		Type checkinAddResultsType = new TypeToken<Results<CheckinAddResponse>>() {}.getType();

		return new Gson().fromJson(responseText,checkinAddResultsType );
	}
}
