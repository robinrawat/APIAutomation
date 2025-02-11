package com.testautomation.apitesting.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.testautomation.apitesting.pojos.USD;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetAPIRequest {
	
	public static JsonPath jPathPost;
	
	
	@Test
	public void getAllPrices() {
		
		Response response =
		RestAssured
				.given()
					.contentType(ContentType.JSON)
					.baseUri("https://api.coindesk.com/v1/bpi/currentprice.json")
				.when()
					.get()
				.then()
					.assertThat()
					.statusCode(200)
					.statusLine("HTTP/1.1 200 OK")
					.header("Content-Type", "application/json; charset=utf-8")
				.extract()
					.response();
		jPathPost = response.jsonPath();
		
		
		String USD = jPathPost.getString("bpi.USD.code");
		String GBP = jPathPost.getString("bpi.GBP.code");
		String EUR = jPathPost.getString("bpi.EUR.code");
		String description = jPathPost.getString("bpi.GBP.description");
		
		Assert.assertEquals(USD, "USD");
		Assert.assertEquals(GBP, "GBP");
		Assert.assertEquals(EUR, "EUR");
		Assert.assertEquals(description, "British Pound Sterling");
		
		
		
	}

}
