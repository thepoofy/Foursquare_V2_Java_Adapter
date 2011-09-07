package com.williamvanderhoef.foursquare.responses;

import java.lang.reflect.Type;
import java.util.List;

import com.williamvanderhoef.foursquare.adapters.DefinedType;
import com.williamvanderhoef.foursquare.model.subtypes.Results;

public class Responses<
		T1 extends Results<?>,
		T2 extends Results<?>
	> implements GetResponseBase, DefinedType{

	private List<Results<? extends GetResponseBase>> responses;

	public List<Results<? extends GetResponseBase>> getResponses() {
		return responses;
	}

	public void setResponses(List<Results<? extends GetResponseBase>> responses) {
		this.responses = responses;
	}

	@Override
	public Type defineType() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
