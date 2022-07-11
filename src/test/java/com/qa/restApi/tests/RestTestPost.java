package com.qa.restApi.tests;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


import org.json.JSONObject;

public class RestTestPost {
	
	@Test
	public void postTest() {
		
				
		JSONObject j = new JSONObject();
		j.put("name", "dana");
		j.put("job", "kaayi");
		
		
		System.out.println(j.toString());
		System.out.println();
		
		given().
			header("Content-Type","application-json").
			contentType(ContentType.JSON).
			body(j.toString()).
		when().
			post("https://reqres.in/api/users?page=2").
		then().
			statusCode(201).
			log().all();

	}

}
