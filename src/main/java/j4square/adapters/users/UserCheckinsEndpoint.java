package j4square.adapters.users;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import j4square.adapters.EndpointAdapter;
import j4square.responses.UserCheckinsResponse;
import j4square.types.Results;

public class UserCheckinsEndpoint implements EndpointAdapter<UserCheckinsResponse>
{
	/*
	 * (non-Javadoc)
	 * @see j4square.adapters.EndpointAdapter#adapt(java.lang.String)
	 */
	@Override
	public Results<UserCheckinsResponse> adapt(String responseText)
	{
		Gson g = new Gson();
		
		Type resultsType = new TypeToken<Results<UserCheckinsResponse>>() {}.getType();
		
		return g.fromJson(responseText, resultsType);
	}

	
	
}
