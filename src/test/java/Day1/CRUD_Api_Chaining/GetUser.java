package Day1.CRUD_Api_Chaining;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class GetUser {

	
	@Test()
	public void getUser(ITestContext context) {
		
		
		
		Response res=  given().
				 headers("Authorization","Bearer 4dc24ba2410a70730ce461083267eb2fd2514a5b79b1f30c9c25c17d743fcdae")
				.contentType("application/json")
				.pathParam("id", context.getAttribute("userId"))
				.when()
				.put("https://gorest.co.in/public/v2/users/{id}");
	
		     
		
		
	   
	        System.out.println("Get user Response : "+res.asPrettyString());
		
	}
	
}
