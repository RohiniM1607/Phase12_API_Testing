package com.insomnia_demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Option_Trainee {
	@Test
	public void optionTrainee() {
		RestAssured.baseURI = "http://localhost:3000";
		Response response = RestAssured.given().when().options("/trainees");
		Assert.assertEquals(response.getStatusCode(), 204);
	}
}
