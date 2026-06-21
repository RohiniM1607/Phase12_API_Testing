package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class PartA_T4_AllRolesTest extends BaseTest {

    @Test(dependsOnMethods = "com.test.AuthenticationTest.authenticationTest")
    public void get_all_roles() {
        Response response =RestAssured.given()
                    .header("Authorization", "Bearer " + AuthenticationTest.token)
                    .when()
                    .get("/roles/getAll");
        //response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("Status Code: " + response.getStatusCode());
        Assert.assertEquals(response.jsonPath().getString("message[0].value"),"Role Retrieved successfully");
		System.out.println(response.jsonPath().getString("message[0].value"));
		System.out.println("Id: "+response.jsonPath().getString("roles._id"));
		System.out.println("Institution: "+response.jsonPath().getString("role.institution"));
		System.out.println("Role Value: "+response.jsonPath().getString("role.roleValue"));     
		if (response.getStatusCode() != 200)
			System.out.println("User is not logged in");
    }
}