package Day1.CRUD_Api_Chaining;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;


import io.restassured.response.Response;

public class UpdateUser {
	
	
	@Test(priority=1)
	public void updateUser(ITestContext context) {
		
		
		Faker faker = new Faker();
		
		JSONObject data = new JSONObject();
		          data.put("name", faker.name());
		          data.put("email", faker.internet().emailAddress());
		          data.put("gender", "Female");
		          data.put("status", "active");
		
		
		Response res=  given().
		 headers("Authorization","Bearer 4dc24ba2410a70730ce461083267eb2fd2514a5b79b1f30c9c25c17d743fcdae")
		.contentType("application/json")
		.body(data.toString())
		.pathParam("id", context.getAttribute("userId"))
		.when()
		.put("https://gorest.co.in/public/v2/users/{id}");
		
		  

		 System.out.println("Update user Response : "+res.asPrettyString());

		
		
	}
	

}
