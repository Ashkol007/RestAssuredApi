package Day1;

import static io.restassured.response.Response.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.http.ContentType;

import java.util.HashMap;

import org.testng.annotations.Test;


public class Queryparameters {
	
	@Test
	public void checkQuerys() {
		
		given()
		      .pathParam("path1", "users")
		      .queryParam("page", 2)
		      .queryParam("id", 12)
		      .header("x-api-key","reqres-free-v1")
	    .when()
	          .get("https://reqres.in/api/{path1}")
	    .then()
	          .statusCode(200)
	          .log().all();
		
		
	}
	
	

}
