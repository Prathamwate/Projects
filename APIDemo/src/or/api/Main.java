package or.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {

		String url="https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=IBM&interval=5min&apikey=demo";
		//Building Request
		HttpRequest request=HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
		//Getting  the Http Client Object
		HttpClient client=HttpClient.newBuilder().build();
		//Printing Body And Status Code
		HttpResponse<String> httpResponse=client.send(request,HttpResponse.BodyHandlers.ofString());
		System.out.println(httpResponse.statusCode());
		System.out.println(httpResponse.body());
		

	}

}
