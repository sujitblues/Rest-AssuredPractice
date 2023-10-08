package ApiChainingPet;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
public class APIChaining {
	public int responseID=0;
	@Test(priority=1)
	public void AddPet()
	{
		String payload="{\r\n"
				+ "  \"id\": 1,\r\n"
				+ "  \"category\": {\r\n"
				+ "    \"id\": 0,\r\n"
				+ "    \"name\": \"pamerian\"\r\n"
				+ "  },\r\n"
				+ "  \"name\": \"doggie\",\r\n"
				+ "  \"photoUrls\": [\r\n"
				+ "    \"string\"\r\n"
				+ "  ],\r\n"
				+ "  \"tags\": [\r\n"
				+ "    {\r\n"
				+ "      \"id\": 0,\r\n"
				+ "      \"name\": \"puppy\"\r\n"
				+ "    }\r\n"
				+ "  ],\r\n"
				+ "  \"status\": \"available\"\r\n"
				+ "}";
		responseID=given().header("content-Type","application/json")
				.body(payload).log().all()
		 .when().post("https://petstore.swagger.io/v2/pet")
		 .jsonPath().getInt("id");	
		System.out.println(responseID);
		
	}
	@Test(priority=2,dependsOnMethods="AddPet")
	public void updatePet()
	{

		String payload="{\r\n"
				+ "  \"id\":"+responseID+",\r\n"
				+ "  \"category\": {\r\n"
				+ "    \"id\": 0,\r\n"
				+ "    \"name\": \"pamerian\"\r\n"
				+ "  },\r\n"
				+ "  \"name\": \"doggie\",\r\n"
				+ "  \"photoUrls\": [\r\n"
				+ "    \"string\"\r\n"
				+ "  ],\r\n"
				+ "  \"tags\": [\r\n"
				+ "    {\r\n"
				+ "      \"id\": 0,\r\n"
				+ "      \"name\": \"dog\"\r\n"
				+ "    }\r\n"
				+ "  ],\r\n"
				+ "  \"status\": \"available\"\r\n"
				+ "}";
		given()
		.header("content-Type","application/json")
		.body(payload).log().all()
		 .when().put("https://petstore.swagger.io/v2/pet")
		 .then().log().all().statusCode(200);
	}
	
	@Test(priority=3)
	public void getPet()
	{
		given().pathParam("id",responseID)
		.log().all()
		 .when().get("https://petstore.swagger.io/v2/pet/{id}")
		 .then().statusCode(200).log().all();
		
		
	}
	
	@Test(priority=4)
	public void deletePet()
	{
		given().pathParam("id",responseID)
		.log().all()
		 .when().delete("https://petstore.swagger.io/v2/pet/{id}")
		 .then().statusCode(200).log().all();
	}

}
