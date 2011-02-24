package j4square.adapters.users;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import j4square.adapters.EndpointAdapter;
import j4square.responses.UserResponse;
import j4square.types.Results;

public class UsersEndpoint implements EndpointAdapter<UserResponse>
{
	/*
	 * (non-Javadoc)
	 * @see j4square.adapters.EndpointAdapter#adapt(java.lang.String)
	 */
	@Override
	public Results<UserResponse> adapt(String responseText)
	{
		Gson g = new Gson();
		
		Type userDetailResultsType = new TypeToken<Results<UserResponse>>() {}.getType();
		
		return g.fromJson(responseText, userDetailResultsType);
	}

	
	
}
