package day2;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class postDemo {
	
	@Test
	public void creatUser()
	{
		String payload="{\r\n"
				+ "  \"id\": 1,\r\n"
				+ "  \"username\": \"Raju\",\r\n"
				+ "  \"firstName\": \"Raju\",\r\n"
				+ "  \"lastName\": \"Patel\",\r\n"
				+ "  \"email\": \"raju@mailinator.com\",\r\n"
				+ "  \"password\": \"1234\",\r\n"
				+ "  \"phone\": \"987654398\",\r\n"
				+ "  \"userStatus\": 1\r\n"
				+ "}";
		given()
		.header("ContentType","application/json")
		.body(payload)
		.when()
		.post("https://petstore.swagger.io/v2/user")
		.then()
		.log().all()
		.statusCode(200);
		
		
	}

}
