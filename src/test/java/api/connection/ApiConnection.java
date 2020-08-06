package api.connection;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class ApiConnection {

	private final static String URI = "http://www.omdbapi.com";
	
	private static RequestSpecification requestSpecification = null;
	
	public static RequestSpecification getConnection() {
		
		RestAssured.baseURI = URI;
	    requestSpecification = RestAssured.given();

	    return requestSpecification;

	}
}
