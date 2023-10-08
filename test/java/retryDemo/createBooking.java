package retryDemo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class createBooking {
	
	public static int create()
	{
		int randomNumber=(int)((Math.random()*(50-1))+1);
		System.out.println(randomNumber);
		String payload="{\r\n"
				+ "    \"firstname\" : \"Jim\",\r\n"
				+ "    \"lastname\" : \"Brown\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n"
				+ "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}";
		if(randomNumber%2==0)
		{
			
		System.out.println("Creating Booking...");
		return RestAssured.given()
		.contentType(ContentType.JSON)
		.body(payload)
		.post("https://restful-booker.herokuapp.com/booking")
		.statusCode();
		
		}
		else
		{
			System.out.println("Booking creation failed");
			return 0;
		}
	}

}
