package com.williamvanderhoef.foursquare.types;

/**
 * 
 * @author <a href="mailto://william.vanderhoef@gmail.com">William Vanderhoef</a>
 *
 */
public class Meta
{
	private int code;
	private String errorType;
	private String errorDetail;

	public int getCode()
	{
		return code;
	}

	public void setCode(int code)
	{
		this.code = code;
	}

	/**
	 * @return the errorType
	 */
	public String getErrorType()
	{
		return errorType;
	}

	/**
	 * @param errorType the errorType to set
	 */
	public void setErrorType(String errorType)
	{
		this.errorType = errorType;
	}

	/**
	 * @return the errorDetail
	 */
	public String getErrorDetail()
	{
		return errorDetail;
	}

	/**
	 * @param errorDetail the errorDetail to set
	 */
	public void setErrorDetail(String errorDetail)
	{
		this.errorDetail = errorDetail;
	}
}