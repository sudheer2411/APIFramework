package com.rest1;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class putreqest {
	
	@Test
	void postRequest_Demo()
	{
	    RestAssured.baseURI = "https://reqres.in/api/users";

	    String requestBody = "{\n" + " \"name\": \"sudhir\",\n" + " \"job\": \"tester\"\n" + "}";

	    Response response = RestAssured
	        .request("PUT")
	        .thenReturn();

	    response = RestAssured
	        .with()
	        .contentType(ContentType.JSON)
	        .body(requestBody)
	        .put("/users/1");

	    System.out.println("Response: " + response.asPrettyString());

	    Assert.assertEquals(response.statusCode(), 200);
	    Assert.assertEquals(response.jsonPath().getString("name"), "sudhir");

}}
