package com.williamvanderhoef.foursquare;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.williamvanderhoef.foursquare.adapters.JsonSyntaxException;
import com.williamvanderhoef.foursquare.model.notification.NotificationTray;
import com.williamvanderhoef.foursquare.model.notification.Notifications;
import com.williamvanderhoef.foursquare.model.subtypes.Results;
import com.williamvanderhoef.foursquare.parsers.ResultsParser;

public abstract class BaseTest<T>{

	public abstract String getFileName();

	private ResultsParser<T> loader = null;
	private String fileContents;
	
	/**
	 * 
	 * @param loader
	 */
	public BaseTest(ResultsParser<T> loader){
		this.loader = loader;
	}
	

	protected void setFileContents(String fileContents)
	{
		this.fileContents = fileContents;
	}
	protected String getFileContents()
	{
		return this.fileContents;
	}


	private Results<T> results;

	public void setResults(Results<T> results)
	{
		this.results = results;
	}

	public Results<T> getResults()
	{
		return this.results;
	}




	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		FileInputStream fis = new FileInputStream(getFileName());
		InputStreamReader in = new InputStreamReader(fis, "UTF-8");

		BufferedReader br = new BufferedReader(in);

		StringBuilder sb = new StringBuilder();
		while(br.ready())
		{
			sb.append(br.readLine());
		}

		br.close();
		in.close();
		fis.close();

		fileContents = sb.toString();
		
		setResults(loader.fromJson(fileContents));
	}

	@Test
	public void isRepeatable() throws JsonSyntaxException
	{
		Assert.assertNotNull(fileContents);
		
		Results<T> originalResults = loader.fromJson(fileContents);
		Assert.assertNotNull(originalResults);
		
		String s = loader.toJson(originalResults);
		Assert.assertNotNull(s);
		
		Results<T> secondPass = loader.fromJson(s);
		Assert.assertNotNull(secondPass);
		
		Assert.assertNotNull(originalResults.getMeta());
		Assert.assertNotNull(secondPass.getMeta());
		
		Assert.assertNotNull(originalResults.getNotifications());
		Assert.assertNotNull(secondPass.getNotifications());
		
		Assert.assertEquals(originalResults.getMeta().getCode(), secondPass.getMeta().getCode());
		Assert.assertEquals(originalResults.getNotifications().size(), secondPass.getNotifications().size());
		
		testEquality(originalResults, secondPass);
		
//		Assert.assertEquals(fileContents, s);
	}
	
	
	public abstract void testEquality(Results<T> original, Results<T> secondBuild);
	

	@Test
	public void testResults()
	{
		Results<T> results = getResults();

		Assert.assertNotNull(results);

		Assert.assertNotNull(results.getMeta());

		Assert.assertNotNull(results.getResponse());
	}

	@Test
	public void testNotifications()
	{
		Results<T> results = getResults();

		List<Notifications> notifications = results.getNotifications();

		Assert.assertNotNull(notifications);

		Assert.assertTrue(!notifications.isEmpty());

		Notifications notification = notifications.get(0);
		Assert.assertNotNull(notification);

		Assert.assertNotNull( notification.getItem());
		Assert.assertEquals(NotificationTray.class, notification.getItem().getClass());
	}
}
