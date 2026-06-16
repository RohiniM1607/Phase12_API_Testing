package com.insomnia_demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Delete_Trainee {
	@Test
	public void deleteTrainee() {
		RestAssured.baseURI = "http://localhost:3000";
		Response response = RestAssured.given().when().delete("/trainees/Gjc0o2BZlI4");
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
