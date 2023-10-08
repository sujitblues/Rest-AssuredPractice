package day4;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import org.testng.annotations.Test;
import org.json.JSONObject;
public class strpayloadDemo {
	@Test(priority=1)
	public void creatUserUsingString()
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
		.when()
		.post("https://petstore.swagger.io/v2/user")
		.then()
		.log().all()
		.statusCode(200);
	
	}
@Test(priority=2)
	public void creatUserUsingHashMap()
	{
		HashMap<String,Object>payload=new HashMap<String,Object>();
		payload.put("id", 2);
		payload.put("username", "Himani");
		payload.put("firstName", "Himani");
		payload.put("lastName", "Gupta");
		payload.put("email", "himani@mailnator.com");
		payload.put("password", "1234");
		payload.put("phone", "879654367");
		payload.put("userStatus", 1);
		given()
		.header("Content-Type","application/json")
		.body(payload)
		.when()
		.post("https://petstore.swagger.io/v2/user")
		.then()
		.log().all()
		.statusCode(200)
		.header("Content-Type","application/json");

	
	}
@Test(priority=3)
public void creatUserUsingJsonObject()
{
	JSONObject payload=new JSONObject();
	payload.put("id", 2);
	payload.put("username", "Himani");
	payload.put("firstName", "Himani");
	payload.put("lastName", "Gupta");
	payload.put("email", "himani@mailnator.com");
	payload.put("password", "1234");
	payload.put("phone", "879654367");
	payload.put("userStatus", 1);
	given()
	.header("Content-Type","application/json")
	.body(payload.toString())
	.when()
	.post("https://petstore.swagger.io/v2/user")
	.then()
	.log().all()
	.statusCode(200)
	.header("Content-Type","application/json");


}

}
