package day1;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
public class getUserLIst {
	@Test(priority=-1)
	public void getUserList()
	{
		given()
		.log().all()
		.when()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.log().all()
		.statusCode(200);
		
		
	}
	@Test(priority=2)
	public void createUser()
	{
		
	}
	@Test(priority=3)
	public void updateUser()
	{
		
	}
	@Test(priority=4)
	public void deleteUser()
	{
		
	}

}
