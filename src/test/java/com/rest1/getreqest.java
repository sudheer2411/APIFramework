package com.rest1;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class getreqest {
	
		
		@Test
		void getRequest_Demo() {
		    // Set Base URI
		    RestAssured.baseURI = "https://reqres.in/api/users/2";

		    // Send GET request
		    Response response = RestAssured.request("GET");

		    // Print the response
		    System.out.println("Response:" + response.asPrettyString());

		    // Validations
		    Assert.assertEquals(response.statusCode(), 200);
		    Assert.assertEquals(response.contentType(), "application/json; charset=utf-8");
		    String id = response.jsonPath().getString("data.id");
		    String email = response.jsonPath().getJsonObject("data.email");
		    Assert.assertEquals(id, "2");
		    Assert.assertEquals(email, "janet.weaver@reqres.in");
		}


}
