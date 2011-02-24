package j4square.types;

/**
 * @see http://developer.j4square.com/docs/responses/user.html
 * @author William Vanderhoef william.vanderhoef@gmail.com
 *
 */
public class User extends Unique
{
	/**
	 * 	A user's first name.
	 */
	private String firstName;
	/**
	 * 	A user's last name.	
	 */
	private String lastName;
	/**
	 * 	User's home city
	 */
	private String homeCity;
	/**
	 * URL of a profile picture for this user.
	 */
	private String photo;
	/**
	 * male or female
	 */
	private String gender;
	/**
	 * Optional.
	 * 
	 * The relationship of the acting user (me) to this user (them). 
	 * 		self, 
	 * 		friend, 
	 * 		pendingMe (user has sent a friend request that acting user has not accepted), 
	 * 		pendingThem (acting user has sent a friend request to the user but they have not accepted), 
	 * 		followingThem (acting user is following a celebrity or brand). 
	 * If there is no relationship or pending request between the two users, the node is absent. 
	 * If the acting user is a celebrity, does not indicate whether the user is following them.
	 * 
	 * If pendingme, applications will want to the acting user to an approve/ignore action. 
	 * If pendingthem, applications will want to show the acting user a "pending" message. 
	 */
	private String relationship;
	
	
	
	
	
	
	/**
	 * @return the firstName
	 */
	public String getFirstName()
	{
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName()
	{
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	/**
	 * @return the homeCity
	 */
	public String getHomeCity()
	{
		return homeCity;
	}
	/**
	 * @param homeCity the homeCity to set
	 */
	public void setHomeCity(String homeCity)
	{
		this.homeCity = homeCity;
	}
	/**
	 * @return the photo
	 */
	public String getPhoto()
	{
		return photo;
	}
	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo)
	{
		this.photo = photo;
	}
	/**
	 * @return the gender
	 */
	public String getGender()
	{
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	/**
	 * @return the relationship
	 */
	public String getRelationship()
	{
		return relationship;
	}
	/**
	 * @param relationship the relationship to set
	 */
	public void setRelationship(String relationship)
	{
		this.relationship = relationship;
	}
}
