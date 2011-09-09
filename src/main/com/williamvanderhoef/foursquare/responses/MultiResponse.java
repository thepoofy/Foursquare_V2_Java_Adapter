package com.williamvanderhoef.foursquare.responses;


import com.williamvanderhoef.foursquare.adapters.EndpointAdapter;
import com.williamvanderhoef.foursquare.model.subtypes.Results;

/**
 * @deprecated
 */
@Deprecated
public class MultiResponse<T1, T2, T3, T4, T5>
{
	private Converter<T1> result1 = new Converter<T1>();
	private Converter<T2> result2 = new Converter<T2>();
	private Converter<T3> result3 = new Converter<T3>();
	private Converter<T4> result4 = new Converter<T4>();
	private Converter<T5> result5 = new Converter<T5>();
	
	public class Converter<T>{
		Results<T> result;
		EndpointAdapter<T> adapter;
		
		public Results<T> getResult()
		{
			return result;
		}
		public void setResult(Results<T> result)
		{
			this.result = result;
		}
		public EndpointAdapter<T> getAdapter()
		{
			return adapter;
		}
		public void setAdapter(EndpointAdapter<T> adapter)
		{
			this.adapter = adapter;
		}
	}
	
	
	public Converter<T1> getResult1()
	{
		return result1;
	}
	public void setResult1(Converter<T1> result1)
	{
		this.result1 = result1;
	}
	public Converter<T2> getResult2()
	{
		return result2;
	}
	public void setResult2(Converter<T2> result2)
	{
		this.result2 = result2;
	}
	public Converter<T3> getResult3()
	{
		return result3;
	}
	public void setResult3(Converter<T3> result3)
	{
		this.result3 = result3;
	}
	public Converter<T4> getResult4()
	{
		return result4;
	}
	public void setResult4(Converter<T4> result4)
	{
		this.result4 = result4;
	}
	public Converter<T5> getResult5()
	{
		return result5;
	}
	public void setResult5(Converter<T5> result5)
	{
		this.result5 = result5;
	}
	
}
