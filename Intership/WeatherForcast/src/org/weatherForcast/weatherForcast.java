package org.weatherForcast;

//import org.apache.client.utils.URIBuilder;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class weatherForcast {

	public static void main(String[] args) {
		//System.out.println("Hello Weather");
		try {
			
			GitProfile gp=new GitProfile();
			gp.getProfile();
			//callWeatherForcastApi();
		}
		catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		
	}
	
	public static void callWeatherForcastApi() throws URISyntaxException,IOException{
		Scanner sc=new Scanner(System.in);
		System.out.println("Eneter Location");
		String location=sc.nextLine();
		sc.close();
		
	
		URIBuilder builder=new URIBuilder("https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/weatherdata/forecast");
		
		builder.setParameter("aggregateHours","24");
		builder.setParameter("contentType","json");
		builder.setParameter("unitGroup","metric");
		builder.setParameter("locationMode","single");
		builder.setParameter("key","1PYNQ6AWUDJE9AFERDCHJHSXK");
		builder.setParameter("location",location);
		
		HttpGet getData=new HttpGet(builder.build());
		
		CloseableHttpClient httpclient=HttpClients.createDefault();
		
		CloseableHttpResponse  response=httpclient.execute(getData);
		
		httpclient.close();
		if(response.getStatusLine().getStatusCode()==200) {
			HttpEntity responseEntity=response.getEntity();
			String result=EntityUtils.toString(responseEntity);
		
			
			JSONObject  responseObject=new JSONObject(result);
			JSONObject  locationObject=responseObject.getJSONObject("location");
			JSONArray valueObject=locationObject.getJSONArray("values");
			
			System.out.println("DateTime \t\t\t MinTemp \t MaxTemp \t Humidity \t Visibility");
			for(int i=0;i<valueObject.length();i++) {
				
				JSONObject values= valueObject.getJSONObject(i);
				String dateTime=values.getString("datetimeStr");
				Double minTemp=values.getDouble("mint");
				Double maxTemp=values.getDouble("maxt");
				Double Humidity=values.getDouble("humidity");
				Double Visibility=values.getDouble("visibility");
		
			System.out.printf("%s \t %f \t %f \t %f \t %f \n",dateTime , minTemp , maxTemp , Humidity , Visibility);	
			}
			
			
		}else {
			throw new ExceptionFound("Something Went Wrong !");
		
		}
	}
		
		
}


