package com.insomnia_demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Get_InvalidTrainee {
	@Test
	public void invalidTrainee() {
		RestAssured.baseURI = "http://localhost:3000";
		Response response = RestAssured.given().when().get("/Trainees/78");
		Assert.assertEquals(response.getStatusCode(), 404);
	}
}
