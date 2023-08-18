package api.endpoint;


/*
post   -    https://petstore.swagger.io/v2/user


get -  https://petstore.swagger.io/v2/user/{username}

put  - https://petstore.swagger.io/v2/user/{username}


delete  - https://petstore.swagger.io/v2/user/{username}
*/




public class Routes 
{
	public static String b_url = "https://petstore.swagger.io/v2/";
	
	// USER_MODULE
	public static String get_url = b_url+"user/{username}";
	public static String post_url = b_url+"user";
	public static String put_url = b_url+"user/{username}";
	public static String del_url = b_url+"user/{username}";
	
	
	
	
	
	
}
