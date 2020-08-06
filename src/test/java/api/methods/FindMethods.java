package api.methods;

import static io.restassured.RestAssured.baseURI;

import java.util.List;

import org.apache.log4j.Logger;

import api.test.ApiTest;
import io.restassured.specification.RequestSpecification;

public class FindMethods {
	
	private static RequestSpecification requestSpecification;
	
	private static Logger log = Logger.getLogger(ApiTest.class);
	
	public static String findImdbIdByTitle(String name,String title) {
		
		requestSpecification = GetMethods.getMovieByName(name);
		
		int index=0;
		
    	List<String> titles = requestSpecification
    								.when()
    								.get(baseURI)
    								.then()
    								.extract()
    								.jsonPath()
    								.getList("Search.Title");
    	
    	for(String t:titles) { 		
    		
    		if(t.equals(title)) 
    			break;
    		
    		index++;
    		
    	}
    	
    	log.info(title + " movie found.");
    	
    	String imdbId = requestSpecification
    							.when()
    							.get(baseURI)
    							.then()
    							.extract()
    							.jsonPath()
    							.get("Search["+index+"].imdbID");
    	
    	log.info("ImdbId = "+imdbId);
	
		return imdbId;	
    	
	}

}
