package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class P4_GetCommentsPostID1Test {
  @Test
  public void getCommentsPostId1Test() {

      RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
      Response response = RestAssured.given().queryParam("postId", 1)
                          .when().get("/comments");
      Assert.assertEquals(response.getStatusCode(), 200);
      System.out.println(response.asPrettyString());
  }
}
