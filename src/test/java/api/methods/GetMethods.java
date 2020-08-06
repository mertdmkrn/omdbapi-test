package api.methods;


import org.apache.log4j.Logger;

import api.connection.ApiConnection;
import io.restassured.specification.RequestSpecification;


public class GetMethods {
	
	private static RequestSpecification requestSpecification;
	
	private static Logger log = Logger.getLogger(GetMethods.class);
	
	public static RequestSpecification getMovieByName(String name) {
		
		requestSpecification = ApiConnection.getConnection();
		requestSpecification.
				param("s", name).
		        param("apikey","8492b5f4");
		
		log.info(name + " movies found.");
		
		return requestSpecification;
		
	}
	
	public static RequestSpecification getMovieByImdbId(String imdbId) {
		
		requestSpecification = ApiConnection.getConnection();
		requestSpecification.
				param("i", imdbId).
		        param("apikey","8492b5f4");
		
		log.info(imdbId + " id movie found.");
		
		return requestSpecification;
		
	}
		
}
