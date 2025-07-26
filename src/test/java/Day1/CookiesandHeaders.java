package Day1;

import static io.restassured.response.Response.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class CookiesandHeaders {
	
	
	@Test
	public void checkCookiesandHeaders() {
		
		
		Response res=  
				given()
		      .when()
		      .get("https://www.google.com/");
		
		      System.out.println(res.cookies());
		      
		   Map<String,String> cookies = res.cookies();
		   
		   for(String k : cookies.keySet()) {
			     System.out.println(k +" : " + res.getCookie(k));
			  
		   }
		
		
	}
	
	@Test(priority=1)
	public void checkHeaders() {
		
		given()
		.when()
		     .get("https://tutorialsninja.com/demo/")
		.then()
		     .header("Content-Type", "text/html; charset=utf-8")
		     .header("Server", "nginx")
		     .header("Content-Encoding", "gzip")
		     .log().all();
		     
	}
	
	@Test
	public void getheaders() {
		

	 Response res = given()
		    .when()
		          .get("https://tutorialsninja.com/demo/");
		    
		       String header =  res.getHeader("Content-Encoding");
		       System.out.println("header1 : "+ header);
		       
		       Headers allheader = res.getHeaders();
		       
		       for(Header head: allheader) {
		    	   
		    	    System.out.println(head);
		    	    
		       }
		
	}
	

}
