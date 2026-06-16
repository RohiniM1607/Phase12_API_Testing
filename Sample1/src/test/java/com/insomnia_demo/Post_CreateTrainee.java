package com.insomnia_demo;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Post_CreateTrainee {
	@Test
	public void createTrainee() {
		RestAssured.baseURI = "http://localhost:3000";
		Map<String, Object> payload = new HashMap<>();
		payload.put("name", "MNO");
		payload.put("email", "mno@gmail.com");
		payload.put("company", "Hello tech");
		
		Response response = RestAssured.given().contentType(ContentType.JSON).body(payload).when().post("/trainees");
		Assert.assertEquals(response.getStatusCode(), 201);
	}
}
