package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PartA_T5_AllCoursesTest {
	@Test(dependsOnMethods = "com.test.AuthenticationTest.authenticationTest")
	public void AllCourseStructure() {
		Response response = RestAssured.given().header("Authorization", "Bearer " + AuthenticationTest.token)
				.when().get("/courses-structure/getAll");
		//System.out.print(response.asPrettyString());
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("Status Code: " + response.getStatusCode());
        Assert.assertEquals(response.jsonPath().getString("message[0].value"),"Course structures retrieved successfully");
		System.out.println(response.jsonPath().getString("message[0].value"));
		System.out.println("Id: "+response.jsonPath().getString("data._id"));
		System.out.println("Institution: "+response.jsonPath().getString("data.institution"));
		System.out.println("Course Code: "+response.jsonPath().getString("data.courseCode")); 
		System.out.println("Course Name: "+response.jsonPath().getString("data.courseName"));
	
	}
}
