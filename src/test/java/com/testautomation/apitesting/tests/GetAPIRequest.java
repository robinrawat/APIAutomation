package com.testautomation.apitesting.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.testautomation.apitesting.pojos.USD;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;

import java.util.Set;

import org.json.JSONObject;


public class GetAPIRequest {
	
	public static JsonPath jPathPost;
	
	
	@Test
	public void getAllPrices() {
		
		String response =
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
					.response()
					.asString();
		String res = response.toString();
		System.out.println(res);
		JSONObject mainObject = new JSONObject(res);
		JSONObject posts = mainObject.getJSONObject("bpi");
		Set<String> keys = posts.keySet();
		System.out.println(keys);
		String descrip = posts.getJSONObject("GBP").getString("description");
		
		for (String value : keys) {
			if(value.equalsIgnoreCase("USD")) {
				Assert.assertTrue(true);
			}
			else if(value.equalsIgnoreCase("GBP")) {
				Assert.assertTrue(true);
			}
			else if(value.equalsIgnoreCase("EUR")) {
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
		Assert.assertEquals(descrip, "British Pound Sterling");
		
		
		
	}

}
