package payloadExternalFile;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.io.*;
import org.testng.annotations.Test;
public class payloadExternal {
	
	@Test
	public void payloadUsingExternalFile()
	{
		File payload=new File("D:\\API Testing\\src\\test\\resources\\payload.json");
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
