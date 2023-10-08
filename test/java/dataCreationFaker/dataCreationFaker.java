package dataCreationFaker;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import com.github.javafaker.Faker;

import io.restassured.response.Response;
public class dataCreationFaker {

	
	//JsonObject
		@Test
		public void testCreateUser3()
		{
			
			JSONObject jsonData=new JSONObject();
			jsonData.put("Name","Sachin");
			jsonData.put("job", "QA");
			
			
			given()
			.header("ContentType","application/json")
			.body(jsonData)
			.log().all()
			.when()
			.post("https://reqres.in/api/users")
			.then()
			.log().all();
		}
	//JsonObject
	@Test
	public void testCreateUser()
	{
		Faker data=new Faker();
		JSONObject jsonData=new JSONObject();
		jsonData.put("Name", data.name());
		jsonData.put("job", data.job());
		jsonData.put("address", data.address());
		jsonData.put("phone", data.phoneNumber());
		jsonData.put("email", data.internet().emailAddress());
		
		given()
		.header("ContentType","application/json")
		.body(jsonData)
		.log().all()
		.when()
		.post("https://reqres.in/api/users")
		.then()
		.log().all();
	}
	//HashMap
		@Test(enabled=false)
		public void testCreateUser2()
		{
			Faker faker=new Faker();
			HashMap<String,Object> data=new HashMap<String,Object>();
			data.put("Name", faker.name());
			data.put("job", faker.job());
			
			given()
			.header("ContentType","application/json")
			.body(data)
			.when()
			.post("https://reqres.in/api/users")
			.then()
			.log().all();
		}
}
