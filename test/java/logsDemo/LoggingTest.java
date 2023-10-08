package logsDemo;

import org.testng.annotations.Test;

import io.restassured.config.LogConfig;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Set;
import java.util.HashSet;
public class LoggingTest {
	
	@Test
	public void requestResponseTest()
	{
		given()
		.baseUri("https://api.postman.com")
		.header("X-Api-Key","PMAK-64aa72b8c68cc70031d36d90-5e5d6e71bbb5c41e3b868d1df436bb75de")
		//.log().all() //log all request
		.log().headers()
		.when()
		.get("/workspaces")
		.then()
		//.log().all()//log all response
		.log().body()
		.assertThat()
		.statusCode(200);
	}
	
	//log only if any error in the response
	@Test
	public void logOnlyIfError()
	{
		given()
		.baseUri("https://api.postman.com")
		.header("X-Api-Key","PMAK1-64aa72b8c68cc70031d36d90-5e5d6e71bbb5c41e3b868d1df436bb75de")
		.log().all()
		.when()
		.get("/workspaces")
		.then()
		.log().ifError()
		.assertThat()
		.statusCode(200);
	}

	@Test
	public void logOnlyIfValidationFails()
	{
		given()
		.baseUri("https://api.postman.com")
		.header("X-Api-Key","PMAK-64aa72b8c68cc70031d36d90-5e5d6e71bbb5c41e3b868d1df436bb75de")
		//avoid duplicate code
		//.config(config.logConfig(LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails()))
		.log().ifValidationFails()
		.when()
		.get("/workspaces")
		.then()
		.log().ifValidationFails()
		.assertThat()
		.statusCode(201);
	}
	
	@Test
	public void headerBlackList()
	{
		given()
		.baseUri("https://api.postman.com")
		.header("X-Api-Key","PMAK-64aa72b8c68cc70031d36d90-5e5d6e71bbb5c41e3b868d1df436bb75de")
		.config(config.logConfig(LogConfig.logConfig().blacklistHeader("X-Api-Key")))
		.log().all()
		.when()
		.get("/workspaces")
		.then()
		.log().all()
		.assertThat()
		.statusCode(200);
	}
	@Test
	public void MultipleHeaderBlackList()
	{
		Set<String> headers=new HashSet<String>();
		headers.add("X-Api-Key");
		headers.add("Accept");
		given()
		.baseUri("https://api.postman.com")
		.header("X-Api-Key","PMAK-64aa72b8c68cc70031d36d90-5e5d6e71bbb5c41e3b868d1df436bb75de")
		.config(config.logConfig(LogConfig.logConfig().blacklistHeaders(headers)))
		.log().all()
		.when()
		.get("/workspaces")
		.then()
		.log().all()
		.assertThat()
		.statusCode(200);
	}
}
