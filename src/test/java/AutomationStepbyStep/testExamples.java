package AutomationStepbyStep;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class testExamples {
	
	@Test
	public void test() {
		
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getStatusLine());
		System.out.println(response.getContentType());
		System.out.println(response.getHeader("content-type"));
		
		int status = response.getStatusCode();
		
		Assert.assertEquals(status, 200 );	
		
	}

}
