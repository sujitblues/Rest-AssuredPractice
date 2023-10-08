package HeaderDemo;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.testng.annotations.Test;

public class HeaderRequestTest {
	
	//Approach 1
	@Test
	public void automateHeader()
	{
		
			given()
			.baseUri("https://4ac42261-ea6a-4891-9661-592bcc56f6db.mock.pstmn.io")
			.header("role","HR")
			.header("x-mock-match-request-headers","role")
			.log().all() 
			.when()
			.get("/get")
			.then()
			.log().all()
			.assertThat()
			.statusCode(200);
		
	}
//Approach 2 using header class
	@Test
	public void automateHeader2()
	{
		Header header=new Header("role","employee");
		Header matchHeader=new Header("x-mock-match-request-headers","role");
		
			given()
			.baseUri("https://4ac42261-ea6a-4891-9661-592bcc56f6db.mock.pstmn.io")
			.header(header)
			.header(matchHeader)
			
			.log().all() 
			.when()
			.get("/get")
			.then()
			.log().all()
			.assertThat()
			.statusCode(200);
		
	}//Approach 3 using headers class
	@Test
	public void automateHeader3()
	{
		Header header=new Header("role","employee");
		Header matchHeader=new Header("x-mock-match-request-headers","role");
		Headers headers=new Headers(header,matchHeader);
			given()
			.baseUri("https://4ac42261-ea6a-4891-9661-592bcc56f6db.mock.pstmn.io")
			.headers(headers)
			.log().all() 
			.when()
			.get("/get")
			.then()
			.log().all()
			.assertThat()
			.statusCode(200);
		
	}

//Approach 4 using headers class map
@Test
public void automateHeader4()
{
	HashMap<String,String> headers=new HashMap<String,String>();
	headers.put("role","employee");
	headers.put("x-mock-match-request-headers","role");
	
		given()
		.baseUri("https://4ac42261-ea6a-4891-9661-592bcc56f6db.mock.pstmn.io")
		.headers(headers)
		.log().all() 
		.when()
		.get("/get")
		.then()
		.log().all()
		.assertThat()
		.statusCode(200);
		
	
}

//Multi value header approach 1
@Test
public void mutltiValueTest()
{

	
		given()
		.baseUri("https://4ac42261-ea6a-4891-9661-592bcc56f6db.mock.pstmn.io")
		.header("multivalueheader","value1","value2")
		.log().headers()
		.when()
		.get("/get")
		.then()
		.log().all()
		.assertThat()
		.statusCode(200);
	
}

//Multi value header approach 2
@Test
public void mutltiValueTest2()
{
	Header header1=new Header("multivalueheader","value1");
	Header header2=new Header("multivalueheader","value2");
	Headers headers=new Headers(header1,header2);
	
		given()
		.baseUri("https://4ac42261-ea6a-4891-9661-592bcc56f6db.mock.pstmn.io")
		.headers(headers)
		.log().headers()
		.when()
		.get("/get")
		.then()
		.log().all()
		.assertThat()
		.statusCode(200);
	
}
//header/headers Assertion
@Test
public void ResponseheaderAssert()
{
	HashMap<String,String> headers=new HashMap<String,String>();
	headers.put("headerName","value1");
	headers.put("x-mock-match-request-headers","headerName");
	
		given()
		.baseUri("https://4ac42261-ea6a-4891-9661-592bcc56f6db.mock.pstmn.io")
		.headers(headers)
		.log().headers()
		.when()
		.get("/get")
		.then()
		.log().all()
		.assertThat()
		.statusCode(200)
		//.headers("responeHeader", "resValue1","X-RateLimit-Limit", "120")
		.header("responeHeader", "resValue1")
		.header("X-RateLimit-Limit", "120")
		.header("ContentType", "application/json");
		
		
	
}
//Header assertion using extract 
@Test
public void ExtractHeadersTest()
{
	HashMap<String,String> headers=new HashMap<String,String>();
	headers.put("headerName","value1");
	headers.put("x-mock-match-request-headers","headerName");
	
		Headers extractHeaders=given()
		.baseUri("https://4ac42261-ea6a-4891-9661-592bcc56f6db.mock.pstmn.io")
		.headers(headers)
		.log().headers()
		.when()
		.get("/get")
		.then()
		.log().all()
		.assertThat()
		.statusCode(200)
		.extract()
		.headers();
	for(Header header:extractHeaders)
	{
		System.out.println("Header name"+header.getName()+",");
		System.out.println("Header value"+header.getValue());
	}
}
}
