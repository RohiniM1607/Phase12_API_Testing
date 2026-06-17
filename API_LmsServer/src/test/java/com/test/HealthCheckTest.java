package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class HealthCheckTest extends BaseTest{
	@Test
    public void healthCheck() {
        Response response = RestAssured.given().when().get("/");
        System.out.println("Status code: "+response.statusCode());
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.getBody().asString(), "API Running");
    }
}
