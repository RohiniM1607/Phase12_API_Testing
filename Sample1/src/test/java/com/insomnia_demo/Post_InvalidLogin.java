package com.insomnia_demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Post_InvalidLogin {
	@Test
	public void invalidLogin() {
		RestAssured.baseURI = "http://localhost:5000";

        String payload = "{"+ "\"username\":\"admin\","
                + "\"password\":\"admin12\""+ "}";
        Response response = RestAssured.given().contentType(ContentType.JSON).body(payload)
        								.when().post("/login");
        Assert.assertEquals(response.getStatusCode(), 401);
	}
}
