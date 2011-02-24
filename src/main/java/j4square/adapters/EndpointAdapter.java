package j4square.adapters;

import j4square.types.Results;

public interface EndpointAdapter<T>
{
	/**
	 * 
	 * @param responseText
	 * @return
	 */
	public Results<T> adapt(String responseText);
}
