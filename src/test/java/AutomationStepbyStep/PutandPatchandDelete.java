package AutomationStepbyStep;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PutandPatchandDelete {
	
	@Test
	public void testput() {
		
		JSONObject jsonobj = new JSONObject();
		jsonobj.put("name", "sudhir");
		jsonobj.put("job", "teacher");
		
		
		System.out.println(jsonobj.toJSONString());
		
		RestAssured.baseURI = "https://reqres.in/api";
		
		given()
		.header("Content-Type","application/json")
		.contentType(ContentType.JSON)
		.body(jsonobj.toJSONString())
		.when()
		.put("/users/2")
		.then()
		.statusCode(200)
		.log().all();
			
	}
	
	@Test
	public void testpatch() {
		
		JSONObject jsonobj = new JSONObject();
		jsonobj.put("name", "vinod");
		jsonobj.put("job", "dancer");
		
		
		System.out.println(jsonobj.toJSONString());
		
		RestAssured.baseURI = "https://reqres.in";
		
		given()
		.header("Content-Type","application/json")
		.contentType(ContentType.JSON)
		.body(jsonobj.toJSONString())
		.when()
		.patch("/api/users/2")
		.then()
		.statusCode(200)
		.log().all();
			
	}
	
	@Test
	public void testDelete() {
		
		RestAssured.baseURI = "https://reqres.in";
		
		given()	
		.when()
		.delete("/api/users/2")
		.then()
		.statusCode(204)
		.log().all();
			
	}

}
