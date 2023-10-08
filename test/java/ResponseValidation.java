
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;
public class ResponseValidation {

	@Test
	public void responseCheck()
	{
		Response response=given()
				.contentType(ContentType.JSON)
			.when()
				.get("https://reqres.in/api/users?page=2");
			Assert.assertEquals(response.statusCode(), 200,"checking status code");
			Assert.assertEquals(response.header("Content-Type"),"application/json; charset=utf-8");
			long time=response.getTime();
			//Assert.assertEquals(time, 300);
			if(time<500)
			{
				
			}
			else
			{
				
			}
			String firstName=response.jsonPath().get("data[1].first_name").toString();
			Assert.assertEquals(firstName, "Lindsay");
			String total=response.jsonPath().get("total_pages").toString();
			System.out.println(total);
			Assert.assertEquals(total, "2");
			//assertThat.response.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("listuser.json"));
			//assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("listuser.json"));
	}
	@Test
	public void validateJsonSchema()
	{
		 given()
		   .when()
		   .get("https://reqres.in/api/users?page=2")
		   .then()
		   .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("listuser.json"));
	}
	
}
