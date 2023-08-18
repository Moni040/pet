package api.test;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoint.UserEndPoints;
import api.payload.Users;
import io.restassured.response.Response;
public class TestUser 
{
	Faker fake;
	Users up;
	
	@BeforeClass
	public void setData()
	{
		fake = new Faker();
		up = new Users();
		
		up.setId(fake.idNumber().hashCode());
		up.setUsername(fake.name().username());
		up.setFirstName(fake.name().firstName());
		up.setLastName(fake.name().lastName());
		up.setEmail(fake.internet().safeEmailAddress());
		up.setPassword(fake.internet().password(5,10));
		up.setPhone(fake.phoneNumber().cellPhone());
	}
	
	@Test(priority = 1)
	public void postUser()
	{
		Response response = UserEndPoints.createUser(up);
		response.then().log().all();
	}
	
	@Test(priority = 2)
	public void testReadUser()
	{
		Response res = UserEndPoints.readUser(this.up.getUsername());
		res.then().log().all();
		//Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test
	public void updateUser()
	{
		up.setFirstName(fake.name().firstName());
		up.setLastName(fake.name().lastName());
		up.setEmail(fake.internet().safeEmailAddress());
		
		Response response = UserEndPoints.updateUser(this.up.getUsername(),up);
		response.then().log().body();
		
		Response resup = UserEndPoints.readUser(this.up.getUsername());
		resup.then().log().all();
		
		
	}
	
}
