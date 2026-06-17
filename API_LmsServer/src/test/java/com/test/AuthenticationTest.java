package com.test;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class AuthenticationTest extends BaseTest {

    public static String token;

    @Test(priority = 1)
    public void authenticationTest() {
        Map<String, Object> payload = new HashMap<>();
        payload.put("email", "sam@gmail.com");
        payload.put("password", "123");

        Response response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(payload)
                    .when()
                    .post("/user/login");
                    
        token = response.jsonPath().getString("token");
        System.out.println("Generated Token: " + token);
    }
}