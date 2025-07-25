package Day1;

import static io.restassured.response.Response.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.http.ContentType;

import java.util.HashMap;

import org.testng.annotations.Test;

public class HttpRequest {
	
	int id;
	
	
	@Test
	 public void getUsers() {
		
		given()
		
		.when()
		     .get("https://reqres.in/api/users?page=2")
		
		.then()
		     .statusCode(200)
		     .body("page",equalTo(2))
		     .log().all();
		
	}
	
	@Test(priority = 1)
	public void createUser() {
		
		HashMap data = new HashMap();
		data.put("name", "ashitosh");
		data.put("job", "Leader");
		
		
		id = given()
		      .contentType("application/json")
		      .header("x-api-key","reqres-free-v1")
		      .body(data)
		.when()
		      .post("https://reqres.in/api/users")
              .jsonPath().getInt("id"); 
//  		.then()
//		      .statusCode(201)
//		      .log().all();
		
	}
	
	@Test(priority=2)
	public void updateUser() {
		HashMap data = new HashMap();
		data.put("name", "soham");
		data.put("job", "Intern");
		
		
		given()
		      .contentType("application/json")
		      .header("x-api-key","reqres-free-v1")
		      .body(data)
		.when()
		      .put("https://reqres.in/api/users/"+id)
        .then()
		      .statusCode(200)
		      .log().all();
		
		
	}
	
	
	@Test(priority=4)
	public void delete() {
		
		
		
		given()
	      .contentType("application/json")
	      .header("x-api-key","reqres-free-v1")
	      
	    .when()
	      .delete("https://reqres.in/api/users/"+id)
        .then()
	      .statusCode(204)
	      .log().all();
	}

	

	
	
	

	
}
