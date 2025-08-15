package Day1.CRUD_Api_Chaining;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;


import io.restassured.response.Response;

public class CreateUser {
	
	
	@Test(priority=1)
	public void createUser(ITestContext context) {
		
		
		Faker faker = new Faker();
		
		JSONObject data = new JSONObject();
		          data.put("name", faker.name());
		          data.put("email", faker.internet().emailAddress());
		          data.put("gender", "Male");
		          data.put("status", "inactive");
		
		
		Response res=  given().
		 headers("Authorization","Bearer 4dc24ba2410a70730ce461083267eb2fd2514a5b79b1f30c9c25c17d743fcdae")
		.contentType("application/json")
		.body(data.toString())
		.when()
		.post("https://gorest.co.in/public/v2/users");
		
		  
		 int id =  res.jsonPath().getInt("id");

		 System.out.println("Create user Response : "+ res.asPrettyString());
		 context.setAttribute("userId", id);
		
		
	}
	

}
