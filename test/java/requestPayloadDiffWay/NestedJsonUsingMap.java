package requestPayloadDiffWay;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;
import java.util.HashMap;
public class NestedJsonUsingMap {

	@Test
	public void requestPayloadNestedJson()
	{
		HashMap<String,Object> mainObject=new HashMap<String,Object>();
		HashMap<String,String>nestedObject=new HashMap<String,String>();
		nestedObject.put("name", "myworkspaceV1");
		nestedObject.put("type", "personal");
		nestedObject.put("description", "postman workspace created using api");
		mainObject.put("workspace",nestedObject);
		given()
		.baseUri("https://api.postman.com")
		.header("X-Api-Key","PMAK-64aa72b8c68cc70031d36d90-5e5d6e71bbb5c41e3b868d1df436bb75de")
		.body(mainObject)
		.log().all()
		.when()
		.post("/workspaces")
		.then()
		.log().all()
		.statusCode(200);
	}
}
