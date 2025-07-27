package Day1;

import static io.restassured.response.Response.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;
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
	
	
	@Test
	public void checkJSONData() {
		
		Response res = given()
				.when()
				      .get("http://localhost:3000/students");
		
		System.out.println(res.asString());
		
		JSONArray jo = new JSONArray(res.asString());
		
		Boolean status = false;
		
		for(int i=0;i<=jo.length();i++) {
			
			System.out.println(jo.getJSONObject(i).get("name").toString());
			String name = jo.getJSONObject(i).get("name").toString();
			
			if(name.equalsIgnoreCase("Ashitosh")) {
				status = true;
				break;
			}
		}
		
		Assert.assertEquals(status,true);
				      
	}

}
