package xmlparsing;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
public class getBook {
	
	@Test
	public void GetBook()
	{
		Response response=RestAssured.given()
		.baseUri("https://59d6c27c-66e2-4335-95fa-3bf6a1caf146.mock.pstmn.io")
		.log().all()
		.when()
		.get("/xmlBook")
		.then()
		.log().all().extract().response();
		String lang=response.xmlPath().get("bookstore.book[0].title.@lang").toString();
		Assert.assertEquals(lang, "en");
		//.statusCode(200);
	}
	@Test
	public void GetBook2()
	{
		
		Response response=RestAssured.given()
		.baseUri("https://59d6c27c-66e2-4335-95fa-3bf6a1caf146.mock.pstmn.io")
		.log().all()
		.when()
		.get("/xmlBook");
		
		//book language :Approach 1
		response.then().body("bookstore.book.title.@lang",hasItem("en"));
		
		//book language :Approach 2
		String lang=response.xmlPath().get("bookstore.book.title.@lang");
		Assert.assertEquals(lang, "en");
		
		// Validate the "category" attribute with the value "cooking" for a specific book
        response.then()
            .body("bookstore.book.find { it.@category == 'cooking' }", notNullValue());

		 response.prettyPrint();
	}
	@Test
	public void ValidateCategoires() throws SAXException, IOException, ParserConfigurationException
	{
		
		Response response=RestAssured.given()
		.baseUri("https://59d6c27c-66e2-4335-95fa-3bf6a1caf146.mock.pstmn.io")
		.log().all()
		.when()
		.get("/xmlBook");
		
		// Parse the XML response
        org.w3c.dom.Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(response.getBody().asString());

        // Define expected categories
        List<String> expectedCategories = Arrays.asList("cooking", "children", "web", "web");

        // Extract actual categories from the XML
        List<String> actualCategories = Arrays.asList(
            document.getElementsByTagName("book").item(0).getAttributes().getNamedItem("category").getNodeValue(),
            document.getElementsByTagName("book").item(1).getAttributes().getNamedItem("category").getNodeValue(),
            document.getElementsByTagName("book").item(2).getAttributes().getNamedItem("category").getNodeValue(),
            document.getElementsByTagName("book").item(3).getAttributes().getNamedItem("category").getNodeValue()
        );

        // Compare expected and actual categories
        for (int i = 0; i < expectedCategories.size(); i++) {
            assert expectedCategories.get(i).equals(actualCategories.get(i));
        }
		
	}
}
