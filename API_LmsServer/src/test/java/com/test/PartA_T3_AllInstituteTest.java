package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PartA_T3_AllInstituteTest extends BaseTest{
	@Test
	public void getAllInstitution() {
		Response response = RestAssured.given().when()
				.get("/getAll/institution");
		Assert.assertEquals(response.getStatusCode(), 200);
//		System.out.println(response.getBody().asPrettyString());
		Assert.assertEquals(response.jsonPath().getString("message[0].value"),"Institution Retrieved successfully");
		System.out.println(response.jsonPath().getString("message[0].value"));
		System.out.println("Id: "+response.jsonPath().getString("getAllInstitution._id"));
		System.out.println("Institution Id: "+response.jsonPath().getString("getAllInstitution.inst_id"));
		System.out.println("Institution Name: "+response.jsonPath().getString("getAllInstitution.inst_name"));
		System.out.println("Insttitution Owner: "+response.jsonPath().getString("getAllInstitution.inst_owner"));        

	}
}
