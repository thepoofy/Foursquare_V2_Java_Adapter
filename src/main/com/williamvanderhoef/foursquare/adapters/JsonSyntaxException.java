package com.williamvanderhoef.foursquare.adapters;

public class JsonSyntaxException extends Exception
{
	public JsonSyntaxException(com.google.gson.JsonSyntaxException jse)
	{
		super(jse);
	}

	
	public JsonSyntaxException(Exception e)
	{
		super(e);
	}



	private static final long serialVersionUID = 6522579434099065050L;	
}
