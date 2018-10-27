package com.scp.client;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.scp.bean.Product;
import com.scp.entities.ProductEntity;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ConsumeProductService {
	public static void main(String[] args) throws JSONException {
		Response response = RestAssured.get("http://localhost:8090/REST_API_Produce_Consume_Example/webapi/products");
		String responseString = response.asString();
		JSONArray jsonArray = new JSONArray(responseString);
		JSONObject json =null;
		List<Product> productList = new ArrayList<>();
		for(int i=0;i<jsonArray.length();i++){
			 json = new JSONObject(jsonArray.get(i).toString());
			 productList.add(new Product(json.getInt("productId"),  json.getString("productName"), json.getInt("productPrice"),json.getString("productCategory")));
		}
		System.out.println("Webservice json to Java Object---"+productList);
	}
}
