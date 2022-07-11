package com.qa.restApi.tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

//import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class restTestOne {
	
	@Test
	public void testSomething() {
		given().
		when().
			get("http://ergast.com/api/f1/2017/circuits.json").
		then().
			assertThat().
			statusCode(200).
			and().
			body("MRData.CircuitTable.Circuits.circuitId", hasSize(20)).
			and().
			header("content-length", equalTo("4551"));
	}
	
	@Test
	public void testTwo() {
		Response response = get("https://reqres.in/api/users?page=2");
		
		System.out.println(response.asString());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getTime());	
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test
	public  void testThree() {
		given().
		get("https://reqres.in/api/users?page=2").
			then().
				statusCode(200).
				body("data.id[0]", equalTo(7));
	}

}
