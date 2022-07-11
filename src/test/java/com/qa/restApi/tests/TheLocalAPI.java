package com.qa.restApi.tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import utils.ExcelUtils2;

public class TheLocalAPI {
	String path = "./data/theTestData.xlsx";
	String sheet = "dataSetOne";
	//ExcelUtils excel = new ExcelUtils();
	ExcelUtils2 excel = new ExcelUtils2("C:\\Project\\RestAPITest\\data\\theTestData.xlsx", "dataSetOne");

	//@Test
	public void getTest() {
		baseURI = "http://127.0.0.1:3000/";
		
		given().
			param("firstName","Adarsha").
			get("/users").
		then().
			statusCode(200).
			log().all();
	}
	
	
	@Test
	public void postTest() {
		baseURI = "http://127.0.0.1:3000/";
		
		JSONObject jo = new JSONObject();
		
//		jo.put("firstName",excel.getData(3, 1));
//		jo.put("lastName",excel.getData(3,2));
//		jo.put("place", excel.getData(3,3));
//		jo.put("comments", excel.getData(3,4));
		
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

	@Test
	public void patchTest() {
		baseURI = "http://127.0.0.1:3000/";
		
		JSONObject jo = new JSONObject();
		
	
		jo.put("place", "bengaluru");
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			header("Content-Type", "application/json").
			body(jo.toJSONString()).
		when().
			patch("/users/5").
		then().
			statusCode(200).
			log().all();
		
	}
	
	@Test
	public void putTest() {
		baseURI = "http://127.0.0.1:3000/";
		
		JSONObject jo = new JSONObject();
		
		jo.put("firstName", "Swathi");
		jo.put("lastName", "goobi");
		jo.put("comments", "2");
		jo.put("place", "udupi");
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			header("Content-Type", "application/json").
			body(jo.toJSONString()).
		when().
			put("/users/5").
		then().
			statusCode(200).
			log().all();
		
	}
	
	@Test
	public void deleteTest() {
		baseURI = "http://127.0.0.1:3000/";
		
		when().
			delete("/users/5").
		then().
			statusCode(200);
	}
}
