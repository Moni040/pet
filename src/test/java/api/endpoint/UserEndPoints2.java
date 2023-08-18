package api.endpoint;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.Users;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class UserEndPoints2 
{
	public static ResourceBundle getURL() 
	{
		ResourceBundle routes = ResourceBundle.getBundle("routes");
		return routes;

	}
	
	
	
	
	
	public static Response createUser(Users payload)
	{
		String post_url =getURL().getString("post_url");
		Response res = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
			.when()
				.post(post_url);
		
		return res;
	 }
	
	public static Response readUser(String userName)
	{
		String get_url =getURL().getString("get_url");
		Response res = given()
				.pathParam("username", userName)
			.when()
				.post(get_url);
		
		return res;
	 }
	
	public static Response updateUser(String userName,Users payload)
	{
		String put_url =getURL().getString("put_url");
		Response res = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", userName)
				.body(payload)
			.when()
				.post(put_url);
		
		return res;
	 }
	
	public static Response deleteUser(String userName)
	{
		String del_url =getURL().getString("del_url");
		Response res = given()
				.pathParam("username", userName)
			.when()
				.post(del_url);
		
		return res;
	 }
}
