package formurlEncodedDemo;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class formurlEncodedTest {
	
	@Test
	public void methodTest()
	{
		given()
		.baseUri("https://postman-echo.com")
		.config(config.encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
		.formParam("key1", "value1")
		.formParam("key2", "value2")
		.log().all()
		.when()
		.post("/post")
		.then()
		.log().all()
		.statusCode(200);
	}

}
