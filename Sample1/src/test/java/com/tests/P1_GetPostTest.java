package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class P1_GetPostTest {
  @Test
  public void getPostTest() {
	  Response response = RestAssured.given().when().get("https://jsonplaceholder.typicode.com/posts");
	  System.out.println(response.statusCode());
	  Assert.assertEquals(response.statusCode(), 200);
	  System.out.println(response.getHeader("content-Type"));
	  System.out.println(response.getHeaders());
  }
}
