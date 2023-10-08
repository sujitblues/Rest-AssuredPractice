package XMLCRUD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class XMLOperation {
	int addResult;
	int subResult;
	int mulResult;
	int divResult;
	@Test(priority=1)
	public void add()
	{   
        String xmlPayload = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"
        		+ "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n"
        		+ "  <soap:Body>\r\n"
        		+ "    <Add xmlns=\"http://tempuri.org/\">\r\n"
        		+ "      <intA>45</intA>\r\n"
        		+ "      <intB>45</intB>\r\n"
        		+ "    </Add>\r\n"
        		+ "  </soap:Body>\r\n"
        		+ "</soap:Envelope>";

        // Send the POST request
      Response response=  RestAssured.given()
            .header("Content-Type","text/xml; charset=utf-8")
            .baseUri("http://www.dneonline.com")
            .body(xmlPayload) 
            .log().all()
            .when()
            .post("/calculator.asmx?op=Add") 
            .then().log().all().extract().response();
            
        addResult = response
                .xmlPath()
                .getInt("Envelope.Body.AddResponse.AddResult");
        System.out.println("AddResult: " + addResult);
    }
	
	@Test(priority=2)
public void sub()
{
	String jsonPayload = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"
			+ "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n"
			+ "  <soap:Body>\r\n"
			+ "    <Subtract xmlns=\"http://tempuri.org/\">\r\n"
			+ "      <intA>"+addResult+"</intA>\r\n"
			+ "      <intB>45</intB>\r\n"
			+ "    </Subtract>\r\n"
			+ "  </soap:Body>\r\n"
			+ "</soap:Envelope>";

    // Send the POST request
  Response response=  RestAssured.given()
        .header("Content-Type","text/xml; charset=utf-8")
        .body(jsonPayload) 
        .log().all()
        .when()
        .post("http://www.dneonline.com/calculator.asmx?op=Subtract") 
        .then().log().all().extract().response();
        
    subResult = response
            .xmlPath()
            .getInt("Envelope.Body.SubtractResponse.SubtractResult");
    System.out.println("AddResult: " + subResult);
}
@Test(priority=3)
public void mult()
{
	String xmlPayload = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"
			+ "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n"
			+ "  <soap:Body>\r\n"
			+ "    <Multiply xmlns=\"http://tempuri.org/\">\r\n"
			+ "      <intA>"+subResult+"</intA>\r\n"
			+ "      <intB>45</intB>\r\n"
			+ "    </Multiply>\r\n"
			+ "  </soap:Body>\r\n"
			+ "</soap:Envelope>";

    // Send the POST request
  Response response=  RestAssured.given()
        .header("Content-Type","text/xml; charset=utf-8")
        .body(xmlPayload) 
        .log().all()
        .when()
        .post("http://www.dneonline.com/calculator.asmx?op=Multiply") 
        .then().log().all().extract().response();
        
    mulResult = response
            .xmlPath()
            .getInt("Envelope.Body.MultiplyResponse.MultiplyResult");
    System.out.println("AddResult: " + mulResult);
}
@Test(priority=4)
public void div()
{
	String xmlPayload = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"
			+ "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n"
			+ "  <soap:Body>\r\n"
			+ "    <Divide xmlns=\"http://tempuri.org/\">\r\n"
			+ "      <intA>"+mulResult+"</intA>\r\n"
			+ "      <intB>45</intB>\r\n"
			+ "    </Divide>\r\n"
			+ "  </soap:Body>\r\n"
			+ "</soap:Envelope>";

    // Send the POST request
  Response response=  RestAssured.given()
        .header("Content-Type","text/xml; charset=utf-8")
        .body(xmlPayload) 
        .log().all()
        .when()
        .post("http://www.dneonline.com/calculator.asmx?op=Divide") 
        .then().log().all().extract().response();
        
    divResult = response
            .xmlPath()
            .getInt("Envelope.Body.DivideResponse.DivideResult");
    System.out.println("AddResult: " + divResult);
}

}
