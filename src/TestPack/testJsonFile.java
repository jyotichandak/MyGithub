package TestPack;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.Test;

import files.payload;
import io.restassured.RestAssured;

public class testJsonFile {
	
	@Test
	public void readjsonfile() throws IOException
			{
	RestAssured.baseURI ="https://rahulshettyacademy.com";
	
	//add place
	
	String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
	.body(payload.convertJsonToString("D:\\WORK\\ECLIPSE\\REST API Auto Demo\\src\\files\\addlocationfile.json"))
	.when().post("maps/api/place/add/json")
	.then().assertThat().statusCode(200).extract().response().asString();
   
     System.out.println(response);
			}
}
