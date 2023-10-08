package day2;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class day2 {
	@Test(priority=1)
	public void getUser()
	{
		given()
		
		.when()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.log().all()
		.statusCode(200);
		
	}
	@Test()
	public void creatUser()
	{
		HashMap<String,Object> payload=new HashMap<String,Object>();
		payload.put("name", "Himani");
		payload.put("job", "SQA");
		payload.put("salary",80000);
		String skill[]= {"api","Functional","java"};
		
		System.out.println(skill[1]);
		
		payload.put("skills", skill);
		given()
		.header("ContentType","application/json")
		.body(payload)
		.log().all()
		.when()
		.post("https://reqres.in/api/users")
		.then()
		.log().all()
		.statusCode(201);
		
	}
	@Test
	public void updateUser()
	{
		HashMap<String,Object> payload=new HashMap<String,Object>();
		payload.put("name", "Himani Gupta");
		payload.put("job", "QA");
		payload.put("salary",80000);
		String skill[]= {"api","Functional","java"};
		
		System.out.println(skill[1]);
		
		payload.put("skills", skill);
		given()
		.header("ContentType","application/json")
		.body(payload)
		.log().all()
		.when()
		.put("https://reqres.in/api/users/108")
		.then()
		.log().all()
		.statusCode(200);
		
	}
	@Test
	public void deleteUser()
	{
		
	given()
		
		.when()
		.delete("https://reqres.in/api/users/108")
		.then()
		
		.statusCode(204);
	}
}
