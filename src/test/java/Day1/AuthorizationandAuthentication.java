package Day1;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import io.restassured.http.ContentType;

public class AuthorizationandAuthentication {
	
	String token = "4dc24ba2410a70730ce461083267eb2fd2514a5b79b1f30c9c25c17d743fcdae";
	int userId;
	
	
	  @Test(priority=1)
	  public void checkBearerToken() {
		  
		  
		  Response res = given()
		            .header("Accept", "application/json")
		            .header("Content-Type", "application/json")
		            .header("Authorization", "Bearer" + token)
		        .when()
		            .get("https://gorest.co.in/public/v2/users")
		        .then()
		            .statusCode(200)
		            .extract().response();
		            

		        System.out.println(res.asPrettyString());
		 
		  
	  }
	  
	  
	  @Test(priority=2)
	  public void getUserVerified() {
		  
		   HashMap<String,String> data = new HashMap<>();
		                     data.put("name", "Chinmayananda Shukla");
		                     data.put("gender", "female");
		                     data.put("email", "shukla_chinmayananda@kihn-halvorson.example");
		                     data.put("status", "active");
		                     
		            Response res =  given()

				      .header("Accept", "application/json")
				      .header("Content-Type", "application/json")		
		              .header("Authorization", "Bearer " + token)
		              .contentType(ContentType.JSON)
		             .when()
		               .get("https://gorest.co.in/public/v2/users/8057856")
		             .then()
		               .statusCode(200)
		               .body("name", equalTo(data.get("name")))
		               .body("gender", equalTo(data.get("gender")))
		               .body("status", equalTo(data.get("status")))
		               .extract().response();
		             
		             
//		             userId = res.jsonPath().getInt("id");
//		             System.out.println("userId : "+ userId);

				        System.out.println(res.asPrettyString());
		             
		  
	  }

}
