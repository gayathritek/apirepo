package com.training.restapitest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestApiCountries {

	String sHostURL ="https://restcountries.com/v3.1";
    String sEPData = "/all";
	String sURI = "";
    Response response;
    
    @Test
	public void getCountries() {
		
		sURI = sHostURL+sEPData;
		RestAssured.basePath = sURI;
		response = RestAssured.given().get();
		System.out.println(response.getStatusCode());
	}
	
	
}
