package fileUploadDownloadDemo;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class FileUP {
	
	@Test
	public void fileUp()
	{
		RestAssured.given()
		.multiPart(new File("D:\\API Testing\\src\\test\\resources\\payload.json"))
		.baseUri("https://postman-echo.com/")
		.log().all()
		.when()
		.post("/post")
		.then().log().all().assertThat().statusCode(200);
	}

}
