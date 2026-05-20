package AutomationStepbyStep;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class getandPost {
	
	
	@Test
	public void testget() {
		
		
		RestAssured.baseURI = "https://reqres.in/api";
		
		given()
		.get("/users?page=2")
		.then()
		.statusCode(200)
		.body("data[4].first_name", equalTo("George"))
		.body("data.first_name", hasItems("George","Rachel"));
		
		
	}
	
	@Test
	public void testpost() {
		
		JSONObject jsonobj = new JSONObject();
		jsonobj.put("name", "sudhir");
		jsonobj.put("job", "teacher");
		
		
		System.out.println(jsonobj.toJSONString());
		
		RestAssured.baseURI = "https://reqres.in/api";
		
		given()
		.body(jsonobj.toJSONString())
		.when()
		.post("/users")
		.then()
		.statusCode(201)
		.log().all();
			
	}

}
