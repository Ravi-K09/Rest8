package com.RestAssured_day8;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class Delete_user {

	@Test
	void delete(ITestContext context)
	{
//		String barertoken = "c596aae38606c732063c2cab7fb5309ae2322c2a0df13b3f67fa7b0a8ca84c9f";
		 Object token = context.getSuite().getAttribute("barertoken");
		int id = (int) context.getSuite().getAttribute("user_id");
				given()
		.headers("Authorization","Bearer "+token)
		.pathParam("id",id)
		.when()
		.delete("https://gorest.co.in/public/v2/users/{id}")
		.then()
		.statusCode(204)
		.log().all();
	}
}
