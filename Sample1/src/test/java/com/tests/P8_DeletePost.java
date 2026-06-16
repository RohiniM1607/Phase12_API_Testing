package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class P8_DeletePost {
	@Test
	public void deletePost() {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        Response response = RestAssured.given()
                            		   .when()
                            		   .delete("/posts/1");
        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("Post deleted successfully");
	}
}
