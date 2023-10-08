package day3;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class demoStringPayload {

	@Test
	public void crateUser()
	{
		String payload="{\r\n"
				+ "  \"id\": 1,\r\n"
				+ "  \"username\": \"sujit\",\r\n"
				+ "  \"firstName\": \"sujit\",\r\n"
				+ "  \"lastName\": \"kumar\",\r\n"
				+ "  \"email\": \"sujit@mailnator.com\",\r\n"
				+ "  \"password\": \"Hello@1234\",\r\n"
				+ "  \"phone\": \"987654567\",\r\n"
				+ "  \"userStatus\": 0\r\n"
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

}
