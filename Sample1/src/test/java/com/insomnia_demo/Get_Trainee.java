package com.insomnia_demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Get_Trainee {
	@Test
	public void getTrainee() {
		RestAssured.baseURI = "http://localhost:3000";
		Response response = RestAssured.given().when().get("/trainees/27");
		System.out.print(response.asPrettyString());
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
