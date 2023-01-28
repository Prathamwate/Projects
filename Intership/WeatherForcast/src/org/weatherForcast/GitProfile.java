package org.weatherForcast;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class GitProfile {

	public void getProfile() throws URISyntaxException, IOException {
		
		URIBuilder builder=new URIBuilder("https://api.github.com/users/mechanware");
		
	     HttpGet getData=new HttpGet(builder.build());
		
		CloseableHttpClient httpclient=HttpClients.createDefault();
		
		CloseableHttpResponse response=httpclient.execute(getData);
		
	
	
		if(response.getStatusLine().getStatusCode()==200) {
			
			HttpEntity responseEntity=response.getEntity();
			
			String result=EntityUtils.toString(responseEntity);
			
            // formatting is pending
			///System.out.println(result);
			
		JSONObject  responseObject=new JSONObject(result);
		
	 	String Name=responseObject.getString("login");
	 	int id=responseObject.getInt("id");
	 	
	 	System.out.println("Login Name :"+Name);
	 	System.out.println("Login id :"+id);
		
		}else {
			
			throw new ExceptionFound("Something Went Wrong !");
		
		}
		httpclient.close();
	
	}
}
