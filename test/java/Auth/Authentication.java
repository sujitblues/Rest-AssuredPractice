package Auth;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Authentication {
	
	@Test(priority=1)
	public void BasicAuth()
	{
		RestAssured.given()
		.auth().basic("postman", "password")
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.log().all()
		.statusCode(200);
	}
	@Test(priority=2)
	public void digestAuth()
	{
		RestAssured.given()
		.auth().digest("postman", "password")
		.when()
		.get("https://postman-echo.com/digest-auth")
		.then()
		.log().all()
		.statusCode(200);
	}
	@Test(priority=3)
	public void BerrarToken()
	{
		RestAssured.given()
		.header("Authorization","Bearer "+"1b12c0a69e060daa4cfdb44d95ab08c5d135a70e2555cde2e2e8f6a27f3813ff")
		.when()
		.get("https://gorest.co.in/public/v2/users")
		.then()
		.log().all()
		.statusCode(200);
	}
	@Test(priority=4)
	public void APIKey()
	{
		RestAssured.given()
		.queryParam("appid", "566be371a97a11b1763b0cdaaca945d8")
		.queryParam("q", "delhi")
		.when()
		.get("https://api.openweathermap.org/data/2.5/weather")
		.then()
		.log().all()
		.statusCode(200);
	}

}
