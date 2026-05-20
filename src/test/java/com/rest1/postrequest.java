package com.rest1;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class postrequest {
	
	@Test
	void postRequest_Demo()
	{
	    RestAssured.baseURI = "https://reqres.in/api/users";

	    String requestBody = "{\n" + " \"name\": \"John\",\n" + " \"job\": \"Developer\"\n" + "}";

	    Response response = RestAssured
	        .request("POST")
	        .thenReturn();

	    response = RestAssured
	        .with()
	        .contentType(ContentType.JSON)
	        .body(requestBody)
	        .post("/users");

	    System.out.println("Response: " + response.asPrettyString());

	    Assert.assertEquals(response.statusCode(), 201);
	    Assert.assertEquals(response.jsonPath().getString("name"), "John");
	}


}
