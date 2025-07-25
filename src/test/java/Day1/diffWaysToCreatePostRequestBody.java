package Day1;

import java.util.HashMap;


import static io.restassured.RestAssured.given;
import static io.restassured.response.Response.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

public class diffWaysToCreatePostRequestBody {
	
	
	

	@Test(priority=1)
    public void testPostUsingHasmap() {
	   
		JSONObject data = new JSONObject();
		    data.put("id", 3);
		    data.put("name", "Soham");
		    data.put("phone", "9295959295");
		    
		    String courses[] = {"js","C++"};
		    data.put("courses", courses);
		    
		    
		    given()
		           .contentType("application/json")
		           .body(data.toString())
		    .when()
		          .post("http://localhost:3000/students")
		          
		    .then()
		          .statusCode(201)
		          .body("name",equalTo("Soham"))
		          .body("phone",equalTo("9295959295"))
		          .body("courses[0]", equalTo("js"))
		          .body("courses[1]", equalTo("C++"))
		          .header("Content-Type", "application/json; charset=utf-8")
		          .log().all();
		          
		  }
	
	@Test(priority=2)
	public void testDelete() {
		
		given()
		      
		.when()
		      .delete("http://localhost:3000/students/3")
		.then()
		      .statusCode(200);
	}

	
	
	

}
