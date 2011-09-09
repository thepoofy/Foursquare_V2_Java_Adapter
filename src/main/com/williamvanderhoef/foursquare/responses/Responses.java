package com.williamvanderhoef.foursquare.responses;

import java.lang.reflect.Type;

import com.williamvanderhoef.foursquare.adapters.DefinedType;
import com.williamvanderhoef.foursquare.model.subtypes.Results;

public class Responses<
		T1 extends Results<?>,
		T2 extends Results<?>
	> implements GetResponseBase, DefinedType{

	private T1 result1;
	private T2 result2;

	

	@Override
	public Type defineType() {
		// TODO Auto-generated method stub
		return null;
	}



	public T1 getResult1() {
		return result1;
	}
	public void setResult1(T1 result1) {
		this.result1 = result1;
	}
	public T2 getResult2() {
		return result2;
	}
	public void setResult2(T2 result2) {
		this.result2 = result2;
	}
}
