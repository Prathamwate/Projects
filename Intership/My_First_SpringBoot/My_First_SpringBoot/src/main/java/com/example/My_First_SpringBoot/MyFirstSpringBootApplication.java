package com.example.My_First_SpringBoot;

import java.io.File;
import java.io.IOException;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//@SpringBootApplication

public class MyFirstSpringBootApplication {

	public static void main(String[] args) throws IOException {
		
		
		RestTemplate restTemplet =new RestTemplate();
		
		String url="https://simple-books-api.glitch.me/books";
		
		ResponseEntity<String>  response=restTemplet.getForEntity(url, String.class);
		
		String output=response.getBody();
		
		ObjectMapper mapper=new ObjectMapper();
		
		Book[] book=mapper.readValue(output, Book[].class);
		
		for(Book books:book) {
			
			System.out.println(books);
			
			
			
		}
		
		
	//	mapper.writeValue(new File("F:\\car.json"), output);
		
		
		//SpringApplication.run(MyFirstSpringBootApplication.class, args);
	}

}
