package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class P3_GetPost1CommandsTest {
  @Test
  public void getPost1CommandsTest() {
	  Response response = RestAssured.given().pathParam("id", 1)
			  .when().get("https://jsonplaceholder.typicode.com/posts/{id}/comments");
	  Assert.assertEquals(response.getStatusCode(), 200);
	  System.out.println(response.jsonPath().getList("id"));
	  System.out.println(response.asPrettyString());
  }
}
