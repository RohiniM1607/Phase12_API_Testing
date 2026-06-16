package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class P2_GetPost1Test {
  @Test
  public void getUser1Test() {
	  Response response = RestAssured.given().pathParam("id", 1)
			  .when().get("https://jsonplaceholder.typicode.com/posts/{id}");
	  Assert.assertEquals(response.getStatusCode(), 200);
	  Assert.assertEquals(response.jsonPath().getInt("id"), 1);
	  System.out.println(response.asPrettyString());
  }
}
