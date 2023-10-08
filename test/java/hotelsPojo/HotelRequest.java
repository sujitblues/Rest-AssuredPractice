package hotelsPojo;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import POJODemo.GetCourses;
import io.restassured.http.ContentType;

public class HotelRequest {
	
	@Test
	public void testHoteRequest()
	{
		HotelList hotellistdata=new HotelList();
		hotellistdata.setCity("New Delhi");
		hotellistdata.setDestinationCountry("UK");
		String[] hotels= {"1089449"};
		hotellistdata.setHotels(hotels);
		
		Pax paxdata=new Pax();
		paxdata.setAdultcount(2);
		paxdata.setChildcount(0);
		int[] childages= {5};
		paxdata.setChildrenAges(childages);
		
		Request reqdata=new Request();
		reqdata.setHotelList(hotellistdata);
		reqdata.setCheckindate("2023-10-16");
		reqdata.setCheckoutdate("2023-10-18");
		reqdata.setDuration(2);
		reqdata.setAgencyCountry("AE");
		reqdata.setGuestCountry("c");
		reqdata.setPax(paxdata);
		reqdata.setRatetype("APIClient");
		reqdata.setResponseTime("10000");
		reqdata.setBookingDate("2023-07-26");
		reqdata.setRoomcount(1);
		reqdata.setDateRecency("low");
		
		GetHotels data=new GetHotels();
		data.setLob("Hotel");
		data.setRequest(reqdata);
		
		given()
		.contentType(ContentType.JSON)
		.body(data)
				.log().all()
		.when()
		.post("https://6e49d649-c6f7-4c5e-a395-2707499d3a71.mock.pstmn.io/getHotels")
		.then().log().all().statusCode(200);
		
		
	}

}
