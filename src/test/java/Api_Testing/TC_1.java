package Api_Testing;





import org.apache.logging.log4j.LogManager;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;

import com.github.fge.jsonschema.examples.Example1;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import Api_Testing.base;

public class TC_1 extends base{
	
	

	
	@Test
	public void auth() {
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
	 request = RestAssured.given();
	 
	 JSONObject req = new JSONObject();
	 req.put("username","admin");
	 req.put("password","password123");
	 request.header("Content-Type","application/json");
	 request.body(req.toJSONString());
		response =request.post("/auth");
		String Responsebody = response.getBody().asString();
		logger.info("Auth response body "+Responsebody);
		JsonPath js = response.jsonPath();
		String tok= js.get("token");

		int statuscode = response.statusCode();
		
		logger.info("Auth status code "+statuscode);
		
		
	}
	
	@Test
	public void get() {
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		 request = RestAssured.given();
		 request.header("Content-Type","application/json");
		 
			response =request.get("/booking");
			String Responsebody = response.getBody().asString();
			logger.info("Get response body "+Responsebody);

			int statuscode = response.statusCode();
			
			logger.info("Get status code "+statuscode);
	}
	@Test
	public void getById() {
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		 request = RestAssured.given();
		 request.header("Content-Type","application/json");
		 
			response =request.get("/booking/"+id);
			String Responsebody = response.getBody().asString();
			logger.info("Get by ID  response body "+Responsebody);
			
			int statuscode = response.statusCode();
			
			logger.info("Get by ID status code "+statuscode);

	
	}
	@Test
	public void post() {
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		 request = RestAssured.given();
		 
		
		 request.header("Content-Type","application/json");
		
			response =request.body(payloadpost).post("/booking");
			String Responsebody = response.getBody().asString();
			logger.info("Post response body "+Responsebody);
			JsonPath js = response.jsonPath();
			idput= js.get("bookingid");

			int statuscode = response.statusCode();
			
			logger.info("Post status code "+statuscode);
			
			
	}
	@Test
	public void put() {
	RestAssured.baseURI="https://restful-booker.herokuapp.com";
	 request = RestAssured.given();
	 
	
	 request.header("Content-Type","application/json");
	 request.header("Authorization","Basic "+basic);
	
		response =request.body(payloadput).put("/booking/"+idput);
		String Responsebody = response.getBody().asString();
		logger.info("Put response body "+Responsebody);
		
		int statuscode = response.statusCode();
		
		logger.info("Put status code "+statuscode);
	
}
	@Test
	public void xpatch() {
		
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		 request = RestAssured.given();
		
		 request.header("Content-Type","application/json");
		 request.header("Authorization","Basic "+basic);
		 response =request.body(payloadpatch).patch("/booking/"+idput);
			String Responsebody = response.getBody().asString();
			logger.info("Patch response body "+Responsebody);
			
			int statuscode = response.statusCode();
			
			logger.info("Patch status code "+statuscode);
		
	}
	@Test
	public void ydelete() {
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		 request = RestAssured.given();
		 request.header("Content-Type","application/json");
		 request.header("Authorization","Basic "+basic);
		 response =request.delete("/booking/"+idput);
			String Responsebody = response.getBody().asString();
			logger.info("Delete  response body "+Responsebody);
			
			int statuscode = response.statusCode();
			
			logger.info("Delete status code "+statuscode);
			
			logger.info("------------------------The End------------------------");
			
			 /*String j = response.asString();
				ValidatableResponse v = response.then();
				v.time(Matchers.lessThan(500l));
			
			
			JsonPath Js=response.jsonPath();
			fn=Js.get("firstname");
			Assert.assertTrue(fn.equalsIgnoreCase("Sallyy")); */
			
	}
	public void demo() {
		System.out.println("Demo");
	}
	
}
