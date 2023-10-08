package day4;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Fakerdemo {

@Test
	public void createUser()
	{
	Faker faker=new Faker();
	HashMap<String,Object> payload=new HashMap<String,Object>();
	//payload.put("name", "sujit");
	payload.put("name", faker.name().firstName());
	payload.put("job", "SQA");
	payload.put("email", faker.internet().emailAddress());
	
	
	given()
	.header("ContentType","application/json")
	.body(payload)
	.log().all()
	.when()
	.post("https://reqres.in/api/users")
	.then().log().all();
	
	}

}
