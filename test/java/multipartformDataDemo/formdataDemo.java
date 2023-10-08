package multipartformDataDemo;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class formdataDemo {
	
	@Test
	public void formdataTest()
	{
		given()
		.baseUri("https://postman-echo.com")
		.multiPart("key1","value1")
		.multiPart("key2","value2")
		.when()
		.log().all()
		.post("/post")
		.then()
		.log().all()
		.assertThat()
		.statusCode(200);
	}

}
