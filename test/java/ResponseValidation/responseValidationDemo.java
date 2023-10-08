package ResponseValidation;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
public class responseValidationDemo {

	@Test
	public void testResponseValidation()
	{
		Response response=given()
		.when()
		.get("https://reqres.in/api/users?page=2")
		.then().assertThat().extract().response();
		
		Assert.assertEquals(response.statusCode(), 202,"checking status code");
		
		Assert.assertEquals(response.statusCode(), 200);
		//Assert.assertEquals(response.time(), 5000);
		response.jsonPath().get("data[0].email");
		int page=response.jsonPath().get("page");
		int id=response.jsonPath().get("data[0].id");
		
	
		System.out.println(page);
		System.out.println(id);
	}
}
