package com.williamvanderhoef.foursquare.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple class that allows us to generate the results of a foursquare endpoint purely in java.
 * 
 * 
 * 
 * 
 * @author Willum
 *
 */
public class TestFileFetcher {

	private static final String URL_BASE = "https://api.foursquare.com/v2/";
	
	//XXX add your own token here.
	private static final String TOKEN = "";	

	//XXX change this to a different endpoint  
	private static final Foursquare ENDPOINT_DEF = Foursquare.MultiVenuesVenues;
	
	//XXX update the date to get a specific version
	private static final String REVISION = "20110914";
	
	/**
	 * TODO add more endpoint definitions here.
	 * 
	 * @author Willum
	 *
	 */
	public static enum Foursquare{
		
		Settings("settings/sendToTwitter/set", true, new KeyValuePair("value", "0")),
		CheckinsAdd("checkins/add", true, new KeyValuePair("venueId","4cf714d381cd6dcbbbcb7f0d"),new KeyValuePair("broadcast","private")),

		MultiVenuesVenues("multi", false, new KeyValuePair("requests",new KeyValuePair("/venues/search?","ll=40.75,-74.0&limit=1"),new KeyValuePair("/venues/search?","ll=40.75,-73.98&limit=1")));
		
		public final String uri;
		public List<KeyValuePair>params;
		public final boolean isPost;
		private Foursquare(String uri, boolean isPost, KeyValuePair... params)
		{
			this.uri = uri;
			this.params = Arrays.asList(params);
			this.isPost = isPost;
		}
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<KeyValuePair> params = new ArrayList<KeyValuePair>();
		params.add(new KeyValuePair("oauth_token", TOKEN));
		params.add(new KeyValuePair("v",REVISION));
		
		
		for(KeyValuePair param : ENDPOINT_DEF.params)
		{
			params.add(param);
		}
		
		String result = null; 
		if(ENDPOINT_DEF.isPost)
		{
			result = doPost(URL_BASE+ENDPOINT_DEF.uri, params);
		}
		else
		{
			result = doGet(URL_BASE+ENDPOINT_DEF.uri, params);
		}

		System.out.println(result);
		
		if(result != null)
		{
			try
			{
				File f= null;
				int i = 0;
				do{
					f = new File("src/test/v2."+ENDPOINT_DEF.uri.replaceAll("/", ".")+"."+REVISION+"."+i+".json");
					++i;
				}while(f.exists());
				
				FileWriter writer= new FileWriter(f);
				
				writer.write(result);
				
				writer.flush();
				
				writer.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			System.err.println(":( result was null");
		}
	}
	
	private static String doPost(String address, List<KeyValuePair>params) {
		try {
			// Construct data
			StringBuilder data = new StringBuilder();
			for(KeyValuePair param : params)
			{
				data.append(URLEncoder.encode(param.key, "UTF-8"))
				.append("=")
				.append(URLEncoder.encode(param.value, "UTF-8"))
				.append("&");
			}
			
				
			// Send data
			URL url = new URL(address);
			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(conn.getOutputStream());
			outputStreamWriter.write(data.toString());
			outputStreamWriter.flush();

			// Get the response
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			StringBuilder sb = new StringBuilder();
			
			while(br.ready())
			{
				sb.append(br.readLine());
			}
			
			outputStreamWriter.close();
			br.close();
			
			return sb.toString();
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
	private static String doGet(String address, List<KeyValuePair>params) {
		try {
			// Construct data
			StringBuilder data = new StringBuilder();
			for(KeyValuePair param : params)
			{
				data.append(URLEncoder.encode(param.key, "UTF-8"))
				.append("=")
				.append(URLEncoder.encode(param.value, "UTF-8"))
				.append("&");
			}
			
				
			// Send data
			URL url = new URL(address+"?"+data.toString());
			System.out.println(url.toExternalForm());
			URLConnection conn = url.openConnection();

			// Get the response
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			StringBuilder sb = new StringBuilder();
			
			while(br.ready())
			{
				sb.append(br.readLine());
			}
			
			br.close();
			
			return sb.toString();
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}

	private static class KeyValuePair{
		public String key;
		public String value;
		public KeyValuePair(String key, String value){
			this.key = key;
			this.value = value;
		}
		public KeyValuePair(String key, KeyValuePair ... pairs){
			this.key = key;
			
			StringBuilder sb = new StringBuilder();
			for(KeyValuePair pair : pairs){
				try
				{
					sb.append(pair.key);
					sb.append(URLEncoder.encode(pair.value, "UTF-8"));
					sb.append(",");
				}
				catch(UnsupportedEncodingException uee)
				{
					uee.printStackTrace();
				}	
			}
			this.value = sb.toString();
		}
	}
	
}
