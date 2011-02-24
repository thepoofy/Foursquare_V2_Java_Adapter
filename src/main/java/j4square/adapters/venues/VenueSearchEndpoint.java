package j4square.adapters.venues;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import j4square.adapters.EndpointAdapter;
import j4square.responses.VenueSearchResponse;
import j4square.types.Results;

public class VenueSearchEndpoint implements EndpointAdapter<VenueSearchResponse>
{

	@Override
	public Results<VenueSearchResponse> adapt(String responseText)
	{
		Type venueSearchResultsType = new TypeToken<Results<VenueSearchResponse>>() {}.getType();

		return new Gson().fromJson(responseText,venueSearchResultsType );
	}
	

}
