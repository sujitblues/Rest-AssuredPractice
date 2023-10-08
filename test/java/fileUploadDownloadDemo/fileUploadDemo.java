package fileUploadDownloadDemo;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import java.io.*;

public class fileUploadDemo {
	
	@Test
	public void fileUploadTest()
	{
		String atrvlue="{\"name\":\"aws-setup.ext\",\"parent\":{\"id\":\"12345\"}}";
		given()
		.baseUri("https://postman-echo.com")
		.multiPart("file",new File("C:\\Users\\sujit\\OneDrive\\Documents\\aws-setup.txt"))
		.multiPart("attributes",atrvlue, "application/json")
		.when()
		.log().all()
		.post("/post")
		.then()
		.log().all()
		.assertThat()
		.statusCode(200);
	
	}
	@Test(enabled=false)
	public void dwonloadFile()
	{
		String atrvlue="{\"name\":\"aws-setup.ext\",\"parent\":{\"id\":\"12345\"}}";
		given()
		.baseUri("https://postman-echo.com")
		.multiPart("file",new File("C:\\Users\\sujit\\OneDrive\\Documents\\aws-setup.txt"))
		.multiPart("attributes",atrvlue, "application/json")
		.when()
		.log().all()
		.post("/post")
		.then()
		.log().all()
		.assertThat()
		.statusCode(200);
	
	}

}
