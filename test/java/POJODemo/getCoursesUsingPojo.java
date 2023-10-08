package POJODemo;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class getCoursesUsingPojo {
	
	@Test
	public void testGetCourses()
	{
		String[] coursetitle= {"Selenium","Cypress","playWrite"};
		GetCourses res=given()
				.log().all()
		.when()
		.get("https://6e49d649-c6f7-4c5e-a395-2707499d3a71.mock.pstmn.io/getcourse").as(GetCourses.class);
		String linkedIntext=res.getLinkedIn();
		String instructor=res.getInstructor();
		String actualExperties=res.getExpertise();
		String actualCourseTitle=res.getCourses().getApi().get(1).getCourseTitle();
		Assert.assertEquals(actualCourseTitle, "SoapUi");
		Assert.assertEquals(actualExperties, "Automation");
		Assert.assertEquals(linkedIntext, "http://www.linkedin.com");
		Assert.assertEquals(instructor, "Sujit");
		
		//get the price of soapUI course
		String Atualprice="";
		List<API> apicourse=res.getCourses().getApi();
		for(int i=0;i<apicourse.size();i++)
		{
			if(apicourse.get(i).getCourseTitle().equalsIgnoreCase("SoapUi"))
			{
				Atualprice=apicourse.get(i).getPrice();
			}
		}
		Assert.assertEquals(Atualprice, "40");
		
		//Get all course Title of WebAutomation
		ArrayList<String> a=new ArrayList<String>();
		
		List<WebAutomation> webautomation=res.getCourses().getWebAutomation();
		for(int i=0;i<webautomation.size();i++)
		{
			a.add(webautomation.get(i).getCourseTitle());
			//System.out.println(webautomation.get(i).getCourseTitle());
		}
		List<String>expectTitle=Arrays.asList(coursetitle);
		Assert.assertEquals(a, expectTitle);
		//Assert.assertTrue(a.equals(expectTitle));
		
		
	}

}
