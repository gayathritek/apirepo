package com.training.restapitest;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiAutomation {
	
	String sHostUrl = "https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net";
	String sEPLogin = "/login";
	String sEPData = "/getdata";
	String sURI = "";
	Response response;
	
	@Test
	public void validateLogin() {
		sURI=sHostUrl+sEPLogin;
    RestAssured.baseURI=sURI;
	response = RestAssured.given().body("{\r\n"
			+ "    \"username\": \"gayatri@ta.com\", \r\n"
			+ "    \"password\": \"gayatri@1234\"\r\n"
			+ "}").when().contentType("application/json").post();
	System.out.println(response.getStatusCode());
	System.out.println(response.asString());	
//	System.out.println(response.getBody().asString());
//	System.out.println(response.jsonPath().get("token[0]"));
	
	sURI = sHostUrl+sEPData;
	RestAssured.baseURI=sURI;
	String sToken=response.jsonPath().get("token[0]");
	HashMap<String, String> header = new HashMap();
	header.put("token", sToken);
	response = RestAssured.given().headers(header).when().contentType("application/json").get();
	//response.prettyPrint();
	
	List<String> ids = response.jsonPath().getList("id");
	for(String id:ids)
		System.out.println(id);
	
	}
}
