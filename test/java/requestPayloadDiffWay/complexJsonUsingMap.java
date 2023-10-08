package requestPayloadDiffWay;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.ArrayList;
import java.util.HashMap;
public class complexJsonUsingMap {
	
	@Test
	public void createPayload()
	{
	List<Integer> id=new ArrayList<Integer>();
	id.add(5);
	id.add(8);
	HashMap<String,Object>batter1=new HashMap<String,Object>();
	batter1.put("id","1001");
	batter1.put("type", "regular");
	HashMap<String,Object>batter2=new HashMap<String,Object>();
	batter2.put("id", id);
	batter2.put("type", "Chocolate");
	List<HashMap<String,Object>> betterdata=new ArrayList<HashMap<String,Object>>();
	betterdata.add(batter1);
	betterdata.add(batter2);
	List<String>Listtoppingarray=new ArrayList<String>();
	Listtoppingarray.add("test1");
	Listtoppingarray.add("test2");
	HashMap<String,Object>topping1=new HashMap<String,Object>();
	topping1.put("id", "1001");
	topping1.put("type", "None");
	HashMap<String,Object>topping2=new HashMap<String,Object>();
	topping2.put("id", "5002");
	topping2.put("type", Listtoppingarray);
	
	List<HashMap<String,Object>>toppingdata=new ArrayList<HashMap<String,Object>>();
	toppingdata.add(topping1);
	toppingdata.add(topping2);
	
	HashMap<String,Object>mainpayload=new HashMap<String,Object>();
	mainpayload.put("id", "0001");
	mainpayload.put("type", "donut");
	mainpayload.put("name", "Cake");
	mainpayload.put("ppu", 0.55);
	mainpayload.put("batters", betterdata);
	mainpayload.put("topping", toppingdata);
	
	given()
	.baseUri("https://6e49d649-c6f7-4c5e-a395-2707499d3a71.mock.pstmn.io")
	.contentType(ContentType.JSON)
	.body(mainpayload)
	.when()
	.log().all()
	.post("/complexJsonPayload")
	.then()
	.log().all()
	.statusCode(200);
	}

}
