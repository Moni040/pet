package api.test;

import org.testng.annotations.Test;

import api.endpoint.UserEndPoints;
import api.payload.Users;
import api.utilities.DataProviders;
import groovyjarjarantlr4.v4.parse.ANTLRParser.id_return;
import io.restassured.response.Response;

public class DDtest 
{
	@Test(priority = 1,dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void testPostUser(String uId,String userName, String fName, String lName, String email, String password, String	phone) 
	{
		Users userPayloadUsers = new Users();
		
		userPayloadUsers.setId(Integer.parseInt(uId));
		userPayloadUsers.setUsername(userName);
		userPayloadUsers.setFirstName(fName);
		userPayloadUsers.setLastName(lName);
		userPayloadUsers.setEmail(email);
		userPayloadUsers.setPassword(password);
		userPayloadUsers.setPhone(phone);
		
		Response response = UserEndPoints.createUser(userPayloadUsers);
		
		
	}
	
}
