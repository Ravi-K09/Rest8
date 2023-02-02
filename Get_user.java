package com.RestAssured_day8;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class Get_user {

	@Test
	void getuser(ITestContext context)
	{

		//String barertoken = "c596aae38606c732063c2cab7fb5309ae2322c2a0df13b3f67fa7b0a8ca84c9f";
		
//		int id =(int) context.getAttribute("user_id"); //accessing a variable from test level
		
	 Object token = context.getSuite().getAttribute("barertoken");
	 
		int id =(int) context.getSuite().getAttribute("user_id"); // Accessing a variable from suit level
	//getSuit() used for get variable from suit level
		
		given()
		.headers("Authorization","Bearer "+token)
		.pathParam("id",id)
		
		.when()
		.get("https://gorest.co.in/public/v2/users/{id}")
		
		.then()
		.statusCode(200)
		.log().all();
	
		
	}
	
}
