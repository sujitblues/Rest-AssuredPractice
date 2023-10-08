package XMLCRUD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;

public class xmlOperationPOJO {
	int addResult;
	int subResult;
	int mulResult;
	int divResult;
	@Test(priority=1)
	public void add()
	{   
		AddRequest request = new AddRequest();
		request.setIntA(120);
		request.setIntB(45);

        // Send the POST request
      Response response=  RestAssured.given()
            .header("Content-Type","text/xml; charset=utf-8")
            .header("SOAPAction", "http://tempuri.org/Add")
        

            .body(request, ObjectMapperType.JAXB) // Serialize the POJO as XML 
            .log().all()
            .when()
            .post("http://www.dneonline.com/calculator.asmx?op=Add") 
            .then().log().all().extract().response();
            
        addResult = response
                .xmlPath()
                .getInt("Envelope.Body.AddResponse.AddResult");
        System.out.println("AddResult: " + addResult);
    }
	
	@Test(priority=2)
public void sub()
{
		SubtractRequest request = new SubtractRequest();
		request.setIntA(addResult);
		request.setIntB(5);

// Send the POST request
Response response=  RestAssured.given()
    .header("Content-Type","text/xml; charset=utf-8")
    .header("SOAPAction", "http://tempuri.org/Subtract")


    .body(request, ObjectMapperType.JAXB) // Serialize the POJO as XML 
    .log().all()
    .when()
    .post("http://www.dneonline.com/calculator.asmx?op=Subtract") 
    .then().log().all().extract().response();
    
subResult = response
        .xmlPath()
        .getInt("Envelope.Body.SubtractResponse.SubtractResult");
System.out.println("AddResult: " + addResult);
}
@Test(priority=3)
public void mult()
{
	MultiplyRequest request = new MultiplyRequest();
	request.setIntA(subResult);
	request.setIntB(10);
    
    
// Send the POST request
Response response=  RestAssured.given()
    .header("Content-Type","text/xml; charset=utf-8")
    .header("SOAPAction","http://tempuri.org/Multiply")
    .body(request, ObjectMapperType.JAXB)
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
	DivideRequest request = new DivideRequest();
	request.setIntA(mulResult);
	request.setIntB(5);
    
// Send the POST request
Response response=  RestAssured.given()
    .header("Content-Type","text/xml; charset=utf-8")
    .header("SOAPAction","http://tempuri.org/Divide")
    .body(request, ObjectMapperType.JAXB)
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
