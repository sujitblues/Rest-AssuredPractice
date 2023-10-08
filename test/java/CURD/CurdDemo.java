package CURD;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

public class CurdDemo {
	public int userid;
	@Test(priority=1)
	public void creatUser()
	{
		HashMap<String,Object>payload=new HashMap<String,Object>();
	payload.put("name", "Deepika");
	payload.put("job", "SQA");
	userid=given()
		.header("Content-Type","application/json")
		.body(payload)
		.when()
		.post("https://reqres.in/api/users")
		.jsonPath().getInt("id");//jsonpath
		

	
	}
	@Test(priority=2,dependsOnMethods="creatUser")
	public void getSingleUserUsingPathParam()
	{
		String demo="https://reqres.in/api/users/"+"userid";
		System.out.println(demo);
		
		  given()
		  .pathParam("userid", userid)
		  .when()
		  .get("https://reqres.in/api/users/{userid}") .then();
		 
		
	}
	@Test(priority=2,dependsOnMethods="creatUser",enabled=false)
	public void getSingleUserUsingStr()
	{
		String demo="https://reqres.in/api/users/"+"userid";
		System.out.println(demo);
		
		  given() 
		  .when()
		  .get("https://reqres.in/api/users/"+userid) 
		  .then();
		 
		
	}
	@Test(priority=3)
	public void updateUser()
	{
		HashMap<String,Object>payload=new HashMap<String,Object>();
		payload.put("name", "Deepika Gupta");
		payload.put("job", "API Automation");
		given()
		.header("Content-Type","application/json")
		.pathParam("userid", userid)
		.body(payload)
		.when()
		.put("https://reqres.in/api/users/{userid}")
		.then();
	}
	@Test(priority=4)
	public void deleteUser()
	{
		
		
		  given() 
		  .when()
		  .delete("https://reqres.in/api/users/"+userid) 
		  .then();
		 
		
	}
}
