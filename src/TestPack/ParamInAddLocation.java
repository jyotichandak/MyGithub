package TestPack;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.payload;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class ParamInAddLocation {
	
	@Test(dataProvider="locationdata")
	public void addlocation(String locname,String addr)
	{
		RestAssured.baseURI ="https://rahulshettyacademy.com";
		
		String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(payload.addPayload(locname,addr))
		.when().post("maps/api/place/add/json")
		.then().log().all().statusCode(200).extract().response().toString();
				
		 System.out.println(response);
	}
	
	@DataProvider(name="locationdata")
	public Object[][] getdata()
	{
		return new Object[][] {{"loc1","add1"},{"loc2","add2"},{"loc3","add3"}};
	}

}
