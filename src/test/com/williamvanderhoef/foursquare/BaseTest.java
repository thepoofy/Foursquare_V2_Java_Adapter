package com.williamvanderhoef.foursquare;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.williamvanderhoef.foursquare.model.notification.Notifications;
import com.williamvanderhoef.foursquare.model.notification.NotificationTray;
import com.williamvanderhoef.foursquare.types.Results;

public abstract class BaseTest<T>{

	public abstract String getFileName();
	

	
	private String fileContents;
	
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
		
		setFileContents(sb.toString());
	}
	
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
