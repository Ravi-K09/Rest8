package com.RestAssured_day8;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class Update_user {

	@Test
	void update(ITestContext context)
	{
		Faker faker=new Faker();
		JSONObject jobj=new JSONObject();
		
		jobj.put("name", faker.name().fullName());
		jobj.put("gender", "male");
		jobj.put("email", faker.internet().emailAddress());
		jobj.put("status", "active");
		
//		String barertoken = "c596aae38606c732063c2cab7fb5309ae2322c2a0df13b3f67fa7b0a8ca84c9f";
		 Object token = context.getSuite().getAttribute("barertoken");
		int id =(int) context.getSuite().getAttribute("user_id");
		given()
		.headers("Authorization","Bearer "+token)
		.contentType("application/json")
		.pathParam("id", id)
		.body(jobj.toString())
		
		.when()
		.put("https://gorest.co.in/public/v2/users/{id}")
		
		.then()
		.statusCode(200)
		.log().all();
		
		
	}
}
