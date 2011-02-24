package j4square.adapters.venues;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import j4square.adapters.EndpointAdapter;
import j4square.responses.VenueResponse;
import j4square.types.Results;
import j4square.types.VenueDetails;

public class VenuesEndpoint implements EndpointAdapter<VenueDetails>
{

	@Override
	public Results<VenueDetails> adapt(String responseText)
	{
		Type venueDetailResultsType = new TypeToken<Results<VenueResponse>>() {}.getType();

		return new Gson().fromJson(responseText,venueDetailResultsType );
		
	}
	

}
