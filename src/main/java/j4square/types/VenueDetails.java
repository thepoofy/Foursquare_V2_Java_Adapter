package j4square.types;

import java.util.List;

/**
 * As defined on <a href="http://developer.j4square.com/docs/responses/venue.html">Foursquare Developers - Venue</a>
 * @author <a href="mailto://william.vanderhoef@gmail.com">William Vanderhoef</a>
 *
 */
public class VenueDetails extends Venue
{
	/**
	 * Contains checkinsCount (total checkins ever here) and usersCount (total users who have ever checked in here). 
	 */
	private Stats stats;
	
	/**
	 * user is the compact user who is the mayor (absent if there is no mayor), and count is the number of times they have checked in within the last 60 days.
	 */
	private Mayor mayor; 
	
	/**
	 * 	Contains the total count of tips and groups with friends and others as groupTypes. Groups may change over time. 
	 */
	private Groups<Tip> tips;
	
	/**
	 * An array of todos the current user has at this venue. Absent if there is no acting user.
	 */
	private List<Todo> todos;
	
	/**
	 * An array of string tags applied to this venue.
	 */
	private List<String> tags;
	
	/**
	 * 	Contains count of the number of times the acting user has been here. Absent if there is noacting user.
	 */
	private Count beenHere;		//only present if in the context of a user
	
	/**
	 * 	A short URL for this venue, e.g. http://4sq.com/Ab123D
	 */
	private String shortUrl;
	
	/**
	 * An array of specials near this venue.
	 */
	private List<Special> specialsNearby;
	
	/**
	 * 	A count and groups of photos for this venue. Group types are checkin and venue. Not all items will be present.
	 */
	private Groups<Photo> photos;

	/**
	 * @return the stats
	 */
	public Stats getStats()
	{
		return stats;
	}

	/**
	 * @param stats the stats to set
	 */
	public void setStats(Stats stats)
	{
		this.stats = stats;
	}

	/**
	 * @return the mayor
	 */
	public Mayor getMayor()
	{
		return mayor;
	}

	/**
	 * @param mayor the mayor to set
	 */
	public void setMayor(Mayor mayor)
	{
		this.mayor = mayor;
	}

	/**
	 * @return the tips
	 */
	public Groups<Tip> getTips()
	{
		return tips;
	}

	/**
	 * @param tips the tips to set
	 */
	public void setTips(Groups<Tip> tips)
	{
		this.tips = tips;
	}

	/**
	 * @return the todos
	 */
	public List<Todo> getTodos()
	{
		return todos;
	}

	/**
	 * @param todos the todos to set
	 */
	public void setTodos(List<Todo> todos)
	{
		this.todos = todos;
	}

	/**
	 * @return the tags
	 */
	public List<String> getTags()
	{
		return tags;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(List<String> tags)
	{
		this.tags = tags;
	}

	/**
	 * @return the beenHere
	 */
	public Count getBeenHere()
	{
		return beenHere;
	}

	/**
	 * @param beenHere the beenHere to set
	 */
	public void setBeenHere(Count beenHere)
	{
		this.beenHere = beenHere;
	}

	/**
	 * @return the shortUrl
	 */
	public String getShortUrl()
	{
		return shortUrl;
	}

	/**
	 * @param shortUrl the shortUrl to set
	 */
	public void setShortUrl(String shortUrl)
	{
		this.shortUrl = shortUrl;
	}

	/**
	 * @return the specialsNearby
	 */
	public List<Special> getSpecialsNearby()
	{
		return specialsNearby;
	}

	/**
	 * @param specialsNearby the specialsNearby to set
	 */
	public void setSpecialsNearby(List<Special> specialsNearby)
	{
		this.specialsNearby = specialsNearby;
	}

	/**
	 * @return the photos
	 */
	public Groups<Photo> getPhotos()
	{
		return photos;
	}

	/**
	 * @param photos the photos to set
	 */
	public void setPhotos(Groups<Photo> photos)
	{
		this.photos = photos;
	}
	
}
