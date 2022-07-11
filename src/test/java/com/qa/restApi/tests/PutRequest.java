package com.qa.restApi.tests;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PutRequest {
	
	@Test
	public void putRequestTest() {
		
		JSONObject response = new JSONObject();
		
		response.put("name", "dana");
		response.put("job", "kaayi");
		
		System.out.println(response.toJSONString());
		
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(response.toJSONString()).
		when().
			put("https://reqres.in/api/users/2").
		then().
			statusCode(200).
			log().all();
		
		
	}

}
