package Day1.CRUD_Api_Chaining;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class DeleteUser {

	
	@Test()
	public void deleteUser(ITestContext context) {
		
		
		int id =  (Integer) context.getAttribute("userId");
		
	    Response res=  given()
		.header("Authoriztion","Bearer 4dc24ba2410a70730ce461083267eb2fd2514a5b79b1f30c9c25c17d743fcdae")
		.contentType("application/json")
		.pathParam("id", id)
		.when()
		.delete("https://gorest.co.in/public/v2/users/{id}");
	    
	    System.out.println("Delete : "+res.asPrettyString());
		
	      
		     
		
		
	   
		
	}
	
}
