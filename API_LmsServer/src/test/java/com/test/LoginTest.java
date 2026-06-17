package com.test;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LoginTest extends BaseTest{
	public static String token;
	
	@Test
	public void loginTest() {
		
		Map<String, Object> payload = new HashMap<>();
		payload.put("email", "sam@gmail.com");
		payload.put("password", "123");
		Response response = RestAssured.given().contentType(ContentType.JSON).body(payload).when().post("/user/login");
		Assert.assertEquals(response.getStatusCode(), 201);
		System.out.println(response.getBody().asPrettyString());
	}
}
