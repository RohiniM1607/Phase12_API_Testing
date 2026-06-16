package com.insomnia_demo;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Put_UpdateTrainee {
	@Test
	public void updateTrainee() {
		RestAssured.baseURI = "http://localhost:3000";

		Map<String, Object> payload = new HashMap<>();
		payload.put("name", "Hello");
		payload.put("email", "hello@gmail.com");
		payload.put("company", "Hello Tech");

		Response response = RestAssured.given().contentType(ContentType.JSON).body(payload).when()
				.put("/trainees/7VUWZw7rnQU");
		System.out.println(response.asPrettyString());

	}
}
