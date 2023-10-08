package day4;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
public class StringPayloadDemo {
	
	@Test
	public void createUser()
	{
		String payload="{\r\n"
				+ "  \"id\": 2,\r\n"
				+ "  \"username\": \"Deepika\",\r\n"
				+ "  \"firstName\": \"Deepika\",\r\n"
				+ "  \"lastName\": \"X\",\r\n"
				+ "  \"email\": \"Deepika@mailinator.com\",\r\n"
				+ "  \"password\": \"Hello@123\",\r\n"
				+ "  \"phone\": \"987655434567\",\r\n"
				+ "  \"userStatus\": 1\r\n"
				+ "}";
		given()
		.header("Content-Type","application/json")
		.body(payload)
		.log().all()
		.when()
		.post("https://petstore.swagger.io/v2/user")
		.then()
		.log().all()
		.statusCode(200);
	}
	@Test
	public void createPet()
	{
		String payload="{\r\n"
				+ "  \"id\": 0,\r\n"
				+ "  \"category\": {\r\n"
				+ "    \"id\": 0,\r\n"
				+ "    \"name\": \"string\"\r\n"
				+ "  },\r\n"
				+ "  \"name\": \"doggie\",\r\n"
				+ "  \"photoUrls\": [\r\n"
				+ "    \"string\"\r\n"
				+ "  ],\r\n"
				+ "  \"tags\": [\r\n"
				+ "    {\r\n"
				+ "      \"id\": 0,\r\n"
				+ "      \"name\": \"string\"\r\n"
				+ "    }\r\n"
				+ "  ],\r\n"
				+ "  \"status\": \"available\"\r\n"
				+ "}";
		given()
		.header("Content-Type","application/json")
		.body(payload)
		.log().all()
		.when()
		.post("https://petstore.swagger.io/v2/pet")
		.then()
		.log().all()
		.statusCode(200);
	}

}
