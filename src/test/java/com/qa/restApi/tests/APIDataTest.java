package com.qa.restApi.tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import TestData.DataForTests;
import io.restassured.http.ContentType;

public class APIDataTest extends DataForTests{
	
	
	
	
	@Test(dataProvider = "dataForApi")
	public void postTest(String firstName, String lastName, String placeName, int comment) {
		baseURI = "http://127.0.0.1:3000/";
		
		JSONObject jo = new JSONObject();
		
		jo.put("firstName", firstName);
		jo.put("lastName", lastName);
		jo.put("place", placeName);
		jo.put("comments", comment);
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			header("Content-Type", "application/json").
			body(jo.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).
			log().all();
		
	}

	@Test(dataProvider = "deleteData")
	public void deleteTest(int userId) {
		baseURI = "http://127.0.0.1:3000/";
		
		when().
			delete("/users/"+userId).
		then().
			statusCode(200);
	}
	
	@Parameters({"userId"})
	@Test
	public void deleteTest2(String userId) {
		System.out.println("userID value is: " + userId);
		baseURI = "http://127.0.0.1:3000/";
		
		when().
			delete("/users/"+userId).
		then().
			statusCode(200);
	}
	
}
