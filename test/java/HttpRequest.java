import org.testng.annotations.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.json.JSONTokener;
public class HttpRequest {
	
	@Test(priority=1)
	 void listUser()
	{
		given()
		.pathParam("mypath", "users")
		.queryParam("page", 2)
		.when()
		.get("https://reqres.in/api/{mypath}")
		.then()
		.statusCode(200).log().all();
	
		
		
	}
	//hashmap
	//pojo
	//jsonObject
	//external file
@Test(priority=2)
public void createUser()

{
	HashMap<String,Object> payload=new HashMap<String,Object>();
	payload.put("name", "Ramesh");
	payload.put("job", "QA");
	payload.put("mobile", 98765478);
	String courses[]= {"Postman","Rest-Assured"};
	payload.put("courses",courses);
	
	given()
	.contentType("application/json")
	.body(payload)
	.log().all()
	.when()
	.post("https://reqres.in/api/users")
	.then()
	.statusCode(201)
	.log().all();
	
}
@Test
public void createUserUsingJsonObject()

{
	JSONObject payload=new JSONObject();
	payload.put("name", "Ramesh");
	payload.put("job", "QA");
	payload.put("mobile", 98765478);
	String courses[]= {"Postman","Rest-Assured"};
	payload.put("courses",courses);
	
	given()
	.contentType("application/json")
	.body(payload)
	.log().all()
	.when()
	.post("https://reqres.in/api/users")
	.then()
	.statusCode(201)
	.log().all();
	
}
@Test
public void createUserUsingPOJO()

{
	POJORequest payload=new POJORequest();
	payload.setName("Rames");
	payload.setJob("SQA");
	payload.setMobile("9876545678");
	String courses[]= {"postman","Rest-Assured"};	
	payload.setCourses(courses);
	given()
	.contentType("application/json")
	.body(payload)
	.log().all()
	.when()
	.post("https://reqres.in/api/users")
	.then()
	.statusCode(201)
	.log().all();
	
}
@Test
public void createUserUsingExternalFile() throws FileNotFoundException

{
	File f=new File(".\\body.json");
	FileReader fr=new FileReader(f);
	JSONTokener jt=new JSONTokener(fr);
	JSONObject payload=new JSONObject(jt);
	//File f=new File("D:\\API Testing\\body.json");
	given()
	.contentType("application/json")
	.body(payload)
	.log().all()
	.when()
	.post("https://reqres.in/api/users")
	.then()
	.statusCode(201)
	.log().all();
	
}
@Test(priority=3)
public void updateUser()
{
	HashMap<String,Object> payload=new HashMap<String,Object>();
	payload.put("name", "Ramesh Reddy");
	payload.put("job", "Test Lead");
	payload.put("mobile", 98765478);
	given()
	.contentType("application/json")
	.body(payload)
	.log().all()
	.when()
	.put("https://reqres.in/api/users/134")
	.then()
	.statusCode(200)
	.log().all();
	
}
@Test(priority=4)
public void deleteUser()
{
	
	given()
	.contentType("application/json")
	.log().all()
	.when()
	.delete("https://reqres.in/api/users/134")
	.then()
	.statusCode(204)
	.log().all();
	
}
}
