package Day1;

import static io.restassured.response.Response.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

public class checkResponseData {
	
	@Test
	public void checkJSON() {
		
	Response res =given()
		    .contentType(ContentType.JSON)
		.when()
		     .get("http://localhost:3000/students");
//		.then()
//		      .statusCode(201);
	
	       Assert.assertEquals(res.getHeader("Content-Type"), "application/json; charset=utf-8");
	       Assert.assertEquals(res.statusCode(), 200);
		
		
	}

}
