package com.qa.restApi.tests;

import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;



public class DeleteTest {
	
	@Test
	public void deleteTest() {

		
		given().
		when().
			delete("https://reqres.in/api/users/2").
		then().
			statusCode(204).
			log().all();
		
	}

}
