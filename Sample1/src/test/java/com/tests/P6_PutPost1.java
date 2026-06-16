package com.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class P6_PutPost1 {
	@Test
	public void putPost1() {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        Map<String, Object> payload = new HashMap<>();
        payload.put("id", 1);
        payload.put("title", "Updated Title");
        payload.put("body", "Updated Body");
        payload.put("userId", 1);

        Response response = RestAssured.given()
                                 	   .contentType(ContentType.JSON)
                                 	   .body(payload)
                                 	   .when()
                                 	   .put("/posts/1");
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("title"),"Updated Title");
        System.out.println(response.asPrettyString());
	}
}
