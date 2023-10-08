package fileUploadDownloadDemo;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class FileUpload {
	
	@Test
	public void fileUploadTest()
	{
		RestAssured.given()
		.multiPart(new File("D:\\API Testing\\src\\test\\resources\\listuser.json"))
		.baseUri("https://postman-echo.com")
		.log().all()
		.when()
		.post("/post")
		.then().assertThat().statusCode(200);
	
	}

}
