package com.RestAssured_day8;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class Create {

	

	@Test
	void createuser(ITestContext context)
	{
		Faker faker=new Faker();
		JSONObject jobj=new JSONObject();
		
		jobj.put("name", faker.name().fullName());
		jobj.put("gender", "male");
		jobj.put("email", faker.internet().emailAddress());
		jobj.put("status", "inactive");
		
		String barertoken = "c596aae38606c732063c2cab7fb5309ae2322c2a0df13b3f67fa7b0a8ca84c9f";
	
		int id = given()
		.headers("Authorization","Bearer "+barertoken)
		.contentType("application/json")
		.body(jobj.toString())
		
		.when()
		.post("https://gorest.co.in/public/v2/users")
		.jsonPath().getInt("id");
		
		System.out.println("id is:" +id);
		context.getSuite().setAttribute("user_id",id);
		context.getSuite().setAttribute("barertoken", barertoken);
	
	}
}
