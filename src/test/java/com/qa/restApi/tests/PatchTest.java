package com.qa.restApi.tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PatchTest {
	
	@Test
	public void patchTest() {
		
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
			patch("https://reqres.in/api/users/2").
		then().
			statusCode(200).
			log().all();
	}

}
