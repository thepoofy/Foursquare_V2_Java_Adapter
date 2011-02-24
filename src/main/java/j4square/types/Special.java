package j4square.types;

/**
 * 
 * @see http://developer.j4square.com/docs/responses/special.html
 * @author William Vanderhoef william.vanderhoef@gmail.com
 *
 */
public class Special
{
	private String id;			//	A unique identifier for this special.
	private String type;		//One of mayor, count, frequency, or other.
	private String message;		//	A message describing the special.
	private String description;	//The specific rules for this special.
	
	private Boolean unlocked;	//optional If this is a venue detail request, true or false indicating if this special is unlocked for the acting user.
	private Venue venue;		//optional If the venue is not clear from the context, then a compact venue is provided.
	
	
	/**
	 * @return the id
	 */
	public String getId()
	{
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id)
	{
		this.id = id;
	}
	/**
	 * @return the type
	 */
	public String getType()
	{
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type)
	{
		this.type = type;
	}
	/**
	 * @return the message
	 */
	public String getMessage()
	{
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message)
	{
		this.message = message;
	}
	/**
	 * @return the description
	 */
	public String getDescription()
	{
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}
	/**
	 * @return the unlocked
	 */
	public Boolean getUnlocked()
	{
		return unlocked;
	}
	/**
	 * @param unlocked the unlocked to set
	 */
	public void setUnlocked(Boolean unlocked)
	{
		this.unlocked = unlocked;
	}
	/**
	 * @return the venue
	 */
	public Venue getVenue()
	{
		return venue;
	}
	/**
	 * @param venue the venue to set
	 */
	public void setVenue(Venue venue)
	{
		this.venue = venue;
	}
	

}
