package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Get_All_Roles_Test extends BaseTest {

    @Test(priority = 2, dependsOnMethods = "com.test.AuthenticationTest.authenticationTest")
    public void get_all_roles() {
        Response response =RestAssured.given()
                    .header("Authorization", "Bearer " + AuthenticationTest.token)
                    .when()
                    .get("/roles/getAll");
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("Status Code: " + response.getStatusCode());
    }
}