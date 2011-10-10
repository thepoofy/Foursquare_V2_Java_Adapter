package com.williamvanderhoef.foursquare.responses;

import com.williamvanderhoef.foursquare.model.Todo;
import com.williamvanderhoef.foursquare.model.subtypes.Items;

/**
 * 
 * @author <a href="mailto://william.vanderhoef@gmail.com">William Vanderhoef</a>
 *
 */
public class UserTodosResponse
{
	private Items<Todo> todos;

	/**
	 * @return the todos
	 */
	public Items<Todo> getTodos() {
		return todos;
	}

	/**
	 * @param todos the todos to set
	 */
	public void setTodos(Items<Todo> todos) {
		this.todos = todos;
	}
	
	
}
