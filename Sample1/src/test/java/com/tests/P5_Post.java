package com.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class P5_Post {
    @Test
    public void createPost() {

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        Map<String, Object> payload = new HashMap<>();

        payload.put("title", "My First Post");
        payload.put("body", "Learning Rest Assured");
        payload.put("userId", 1);

        Response response = RestAssured.given()
                                    .contentType(ContentType.JSON)
                                    .body(payload)
                                    .when().post("/posts");
        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertEquals(response.jsonPath().getString("title"), "My First Post");
        System.out.println(response.asPrettyString());
    }
}