package Auth;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Auth2 {
	private String token;
	@Test
	public void getAccessToken()
	{
		String client_id="AX_tLWfeEFeaYeg5B7zMY6lswRi9lYUr2M5udXn97zNya-FeYJog8xw1Y2QTCSSRRn704jLnxWjglJGf";
		String client_secret="EEM3Lc6lXRMVoK82oZY6xZ-14GmziyLKgHYRr3IAwQGxAAjyDjEqU7CYLVKhlQ8NBVXA3pvEF15EEXJn";
		Response response=RestAssured.given()
		.auth().preemptive().basic(client_id, client_secret)
		.queryParam("grant_type", "client_credentials")
		.when()
		.post("https://api-m.sandbox.paypal.com/v1/oauth2/token")
		.then()
		.log().all().extract().response();
		
		token=response.jsonPath().get("access_token");
		System.out.println(token);
	}
	@Test
	public void getInvoice()
	{
		Response response=RestAssured.given()
		.queryParam("page", 1)
		.queryParam("page_size", 4)
		.queryParam("total_count_required", true)
		.header("Authorization","Bearer "+token)
		.when()
		.get("https://api-m.sandbox.paypal.com/v1/invoicing/invoices")
		.then()
		.log().all().extract().response();
//Approach 1:		
int status_code=response.statusCode();
Assert.assertEquals(status_code, 200);

//Approach 2:
Assert.assertEquals(response.statusCode(), 200);
Assert.assertEquals(response.statusLine(), "HTTP/1.1 200 OK");	
int totalc=response.jsonPath().get("total_count");
Assert.assertEquals(totalc, 0);
Assert.assertEquals(response.header("Content-Type"), "application/json");

		
	}
}
