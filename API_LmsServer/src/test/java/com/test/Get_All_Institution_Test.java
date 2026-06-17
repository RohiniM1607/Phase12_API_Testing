package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Get_All_Institution_Test extends BaseTest{
	@Test
	public void getAllInstitution() {
		Response response = RestAssured.given().when()
				.get("/getAll/institution");
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println(response.getBody().asPrettyString());
	}
}
