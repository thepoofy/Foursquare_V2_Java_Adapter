package j4square.types;

/**
 * As documented on <a href="http://developer.j4square.com/docs/responses/tip.html">Foursquare Developers - Tip Response</a>
 * 
 * @author <a href="mailto://william.vanderhoef@gmail.com">William Vanderhoef</a>
 *
 */
public class TipDetails extends Tip
{
	private Groups<User> todo;
	private Groups<User> done;
	
	
	/**
	 * The count of users who have marked this tip todo, and groups containing any friends who have marked it to-do. 
	 * The groups included are subject to change. 
	 * (Note that to-dos are only visible to friends!) 
	 * @return the todo
	 */
	public Groups<User> getTodo()
	{
		return todo;
	}
	/**
	 * @param todo the todo to set
	 */
	public void setTodo(Groups<User> todo)
	{
		this.todo = todo;
	}
	/**
	 * The count of users who have done this tip todo, and groups containing any friends and others who have marked it done. 
	 * The groups included are subject to change.
	 * @return the done
	 */
	public Groups<User> getDone()
	{
		return done;
	}
	/**
	 * @param done the done to set
	 */
	public void setDone(Groups<User> done)
	{
		this.done = done;
	}
}
