package petPojo;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
public class createPetRequest {
	
	@Test
	public void testCreatePetUsingPojo()
	{
		String[] photourl= {"photourl"};
		
		Category catdata=new Category();
		catdata.setId(1);
		catdata.setName("pamerian");
		
		Tags tagdata=new Tags();
		tagdata.setId(1);
		tagdata.setName("dog");
		
		createPet data=new createPet();
		data.setId(2);
		data.setCategory(catdata);
		data.setPhotourl(photourl);
		data.setTags(tagdata);
		data.setStatus("available");
		
		createPet res=given()
		.contentType(ContentType.JSON)
		.body(data)
		.log().all()
		.when()
		.post("https://petstore.swagger.io/v2/pet").as(createPet.class);
		int catId=res.getCategory().getId();
		Assert.assertEquals(catId, 1);
		
	}

}
