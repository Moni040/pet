package api.endpoint;

import static io.restassured.RestAssured.given;

import api.payload.Users;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class UserEndPoints 
{
	public static Response createUser(Users payload)
	{
		Response res = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
			.when()
				.post(Routes.post_url);
		
		return res;
	 }
	
	public static Response readUser(String userName)
	{
		Response res = given()
				.pathParam("username", userName)
			.when()
				.post(Routes.get_url);
		
		return res;
	 }
	
	public static Response updateUser(String userName,Users payload)
	{
		Response res = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", userName)
				.body(payload)
			.when()
				.post(Routes.put_url);
		
		return res;
	 }
	
	public static Response deleteUser(String userName)
	{
		Response res = given()
				.pathParam("username", userName)
			.when()
				.post(Routes.del_url);
		
		return res;
	 }
}
