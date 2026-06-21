package com.test;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PartA_T2_LoginTest extends BaseTest{
	public static String token;
	
	@Test
	public void loginTest() {
		Map<String, Object> payload = new HashMap<>();
		payload.put("email", "sam@gmail.com");
		payload.put("password", "123");
		Response response = RestAssured.given().contentType(ContentType.JSON).body(payload).when().post("/user/login");
		int statusCode = response.getStatusCode();
		if (statusCode == 201) {
		    Assert.assertEquals(response.jsonPath().getString("message[0].value"),"Admin logged in successfully");
		    System.out.println(response.jsonPath().getString("message[0].value"));
		    System.out.println("User Id: " + response.jsonPath().getString("user._id"));
		    System.out.println("User Email: " + response.jsonPath().getString("user.email"));
		    System.out.println("User FirstName: " + response.jsonPath().getString("user.firstName"));
		    System.out.println("User LastName: " + response.jsonPath().getString("user.lastName"));
		    Assert.assertEquals(response.jsonPath().getString("user.email"),"sam@gmail.com");
		    Assert.assertEquals(response.jsonPath().getString("user.role.originalRole"),"Admin");
		    Assert.assertEquals(response.jsonPath().getString("user.status"), "active");
		} 
		else if (statusCode == 400) {

		    String errorMessage = response.jsonPath().getString("message[0].value");
		    System.out.println("Error Message: " + errorMessage);
		    Assert.assertTrue(errorMessage.equals("Email is invalid") || errorMessage.equals("Password is incorrect")|| errorMessage.equals("All fields are required"));
		} 
		else {
		    Assert.fail("Unexpected Status Code: " + statusCode);
		}

	}
}
