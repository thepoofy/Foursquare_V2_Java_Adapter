package j4square.types;

import java.util.List;

/**
 * 
 * @author William Vanderhoef william.vanderhoef@gmail.com
 *
 * @param <T> The Type of Group
 */
public class Groups<T> extends Count
{
	private List<Group<T>> groups;

	/**
	 * @return the groups
	 */
	public List<Group<T>> getGroups()
	{
		return groups;
	}

	/**
	 * @param groups the groups to set
	 */
	public void setGroups(List<Group<T>> groups)
	{
		this.groups = groups;
	}

}
