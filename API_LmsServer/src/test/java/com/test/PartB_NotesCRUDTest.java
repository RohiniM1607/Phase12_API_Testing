package com.test;

import static io.restassured.RestAssured.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PartB_NotesCRUDTest extends BaseTest {

    @Test(dependsOnMethods = "com.test.AuthenticationTest.authenticationTest")
    public void notesCRUDTest() {
        String token = AuthenticationTest.token;
        //6. Create Note
        Map<String, Object> payload = new HashMap<>();
        payload.put("title", "API Test Note");
        payload.put("content", "Created by tester");
        payload.put("tags", Arrays.asList("qa", "demo"));
        payload.put("color", "#ffeb3b");
        payload.put("isPinned", false);

        Response createResponse = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post("/create/notes");

        Assert.assertEquals(createResponse.getStatusCode(), 201);
        String noteId = createResponse.jsonPath().getString("data._id");

        System.out.println("\nCREATE NOTE");
        System.out.println("Message : " +createResponse.jsonPath().getString("message"));
        System.out.println("Note ID : " + noteId);
        //7. Get all notes
        Response getAllResponse = given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/getAll/notes");

        Assert.assertEquals(getAllResponse.getStatusCode(), 200);
        System.out.println("\nGET ALL NOTES");
        //getAllResponse.prettyPrint();
        System.out.println("Title: "+getAllResponse.jsonPath().getString("data.title"));
		System.out.println("Content: "+getAllResponse.jsonPath().getString("data.content"));
		System.out.println("Tags: "+getAllResponse.jsonPath().getString("data.tags")); 
		System.out.println("IsPinned: "+getAllResponse.jsonPath().getString("data.isPinned"));
		System.out.println("Color: "+getAllResponse.jsonPath().getString("data.color"));
		System.out.println("Last Edited: "+getAllResponse.jsonPath().getString("data.lastEdited"));
		System.out.println("Id: "+getAllResponse.jsonPath().getString("data._id")); 
		System.out.println("Created at: "+getAllResponse.jsonPath().getString("data.createdAt"));
		System.out.println("Updated at: "+getAllResponse.jsonPath().getString("data.updatedAt"));
	
        // 8. GET NOTE BY ID
        Response getByIdResponse = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .pathParam("id", noteId)
                .when()
                .get("/getById/notes/{id}");

        Assert.assertEquals(getByIdResponse.getStatusCode(), 200);

        System.out.println("\nGET NOTE BY ID");
        System.out.println("Title : "+ getByIdResponse.jsonPath().getString("data.title"));
        //getAllResponse.prettyPrint();

        //9. Update Note
        Map<String, Object> updatePayload = new HashMap<>();
        updatePayload.put("title", "API Test Note (edited)");
        updatePayload.put("content", "Updated content");

        Response updateResponse = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .pathParam("id", noteId)
                .body(updatePayload)
                .when()
                .put("/update/notes/{id}");

        Assert.assertEquals(updateResponse.getStatusCode(), 200);
        System.out.println("\nUPDATE NOTE");
        System.out.println("Message : "+ updateResponse.jsonPath().getString("message"));

        //10. Toggle Pin
        Response pinResponse = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .pathParam("id", noteId)
                .when()
                .put("/toggle-pin/notes/{id}");

        Assert.assertEquals(pinResponse.getStatusCode(), 200);
        System.out.println("\n===== TOGGLE PIN =====");
        System.out.println("Message : "+ pinResponse.jsonPath().getString("message"));
        System.out.println("Pinned : "+ pinResponse.jsonPath().getBoolean("data.isPinned"));

        //11. Delete Note
        Response deleteResponse = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .pathParam("id", noteId)
                .when()
                .delete("/delete/notes/ById/{id}");

        Assert.assertEquals(deleteResponse.getStatusCode(), 200);

        System.out.println("\n===== DELETE NOTE =====");
        System.out.println("Message : "+ deleteResponse.jsonPath().getString("message"));
        System.out.println("Deleted Count : "+ deleteResponse.jsonPath().getInt("deletedCount"));

        Assert.assertEquals(deleteResponse.jsonPath().getString("message"),"Notes deleted successfully");
    }
}