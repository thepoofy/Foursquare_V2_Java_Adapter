package j4square.responses;

import java.util.List;

import j4square.types.Group;
import j4square.types.Venue;


public class VenueSearchResponse
{
	
	private List<Group<Venue>> groups;

	public List<Group<Venue>> getGroups()
	{
		return groups;
	}

	public void setGroups(List<Group<Venue>> groups)
	{
		this.groups = groups;
	}
}
