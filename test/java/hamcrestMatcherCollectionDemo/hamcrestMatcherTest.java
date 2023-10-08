package hamcrestMatcherCollectionDemo;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import io.restassured.specification.RequestSpecification;

public class hamcrestMatcherTest {
	
	@Test
	public void hamcrestMatcherMethodTest()
	{
		given()
		.baseUri("https://api.postman.com")
		.header("X-Api-Key","PMAK-64aa72b8c68cc70031d36d90-5e5d6e71bbb5c41e3b868d1df436bb75de")
		.when()
		.get("/workspaces")
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(200)
		.body("workspaces.name", hasItems("sujit","PostMan230","postMan 10 AM"))
		.body("workspaces.name", not(hasItems("sachin")));
		//.body("workspaces.name", contains("sujit"));
	}

	@Test
	public void hamcrestMatcherMethodTest2()
	{
		String name=given()
		.baseUri("https://api.postman.com")
		.header("X-Api-Key","PMAK-64aa72b8c68cc70031d36d90-5e5d6e71bbb5c41e3b868d1df436bb75de")
		.when()
		.get("/workspaces")
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(200)
		.extract()
		.response().path("workspaces[0].name");
		//assertThat(name,equalTo("sujit")); //using hamcrest
		Assert.assertEquals(name, "sujit"); //using TestNG Assert class
		
	}
}
