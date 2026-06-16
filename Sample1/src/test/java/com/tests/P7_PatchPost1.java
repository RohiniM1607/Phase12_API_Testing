package com.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class P7_PatchPost1 {
	@Test
	public void patchPost() {

		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        Map<String, Object> payload = new HashMap<>();
        payload.put("title", "Patched Title");
        Response response = RestAssured.given()
                                    .contentType(ContentType.JSON)
                                    .body(payload)
                                    .when()
                                    .patch("/posts/1");

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("title"),"Patched Title");
        System.out.println(response.asPrettyString());
	}
}
