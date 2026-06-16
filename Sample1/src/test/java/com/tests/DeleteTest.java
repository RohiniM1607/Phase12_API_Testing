package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteTest {
	@Test
	public void deleteTest() {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        Response getResponse = RestAssured.given()
                						  .queryParam("title", "3")
                						  .when()
                						  .get("/posts");
        int postId = getResponse.jsonPath().getInt("[0].id");
        System.out.println("Post ID: " + postId);
        
        Response deleteResponse = RestAssured.given()
                							 .when()
                							 .delete("/posts/" + postId);

        Assert.assertEquals(deleteResponse.getStatusCode(), 200);
        System.out.println("Deleted successfully");
	}
}
