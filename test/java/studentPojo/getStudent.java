package studentPojo;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;



public class getStudent {
	
	@Test
	public void testGetStudent()
	{
	  instructorPojo response=given() .log().all() .when()
	  .get("https://6e49d649-c6f7-4c5e-a395-2707499d3a71.mock.pstmn.io/getcourse").
	  as(instructorPojo.class); 
	  String inst=response.getInstructor();
	  Assert.assertEquals(inst, "Sujit"); 
	}

}
