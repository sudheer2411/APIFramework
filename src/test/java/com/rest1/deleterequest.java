package com.rest1;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class deleterequest {
	
	@Test
	void postRequest_Demo()
	{
	    RestAssured.baseURI = "https://reqres.in/api/users";

	//    String requestBody = "{\n" + " \"name\": \"John\",\n" + " \"job\": \"Developer\"\n" + "}";

	    Response response = RestAssured
	        .delete("/users/1");

	  
	    System.out.println("Statuscode: " + response.statusCode());

	    Assert.assertEquals(response.statusCode(), 204);
	   

}
}