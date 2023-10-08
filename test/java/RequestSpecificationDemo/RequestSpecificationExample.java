package RequestSpecificationDemo;

import org.testng.annotations.Test;

import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class RequestSpecificationExample {

	@Test
	public void validate_Status_code()
	{
		RequestSpecification requestSpecification=given();

		
	}
}
