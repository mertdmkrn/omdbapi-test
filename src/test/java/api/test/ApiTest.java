package api.test;

import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import api.methods.FindMethods;
import api.methods.GetMethods;

import static io.restassured.RestAssured.baseURI;

import static org.junit.Assert.assertNotNull;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiTest {
	
	 private RequestSpecification requestSpecification;
	 
	 private static Logger log = Logger.getLogger(ApiTest.class);
	 
	 @Before
	 public void setUp(){

	 	String imdbId = FindMethods.findImdbIdByTitle("Harry Potter","Harry Potter and the Sorcerer's Stone");
	 		
	 	requestSpecification = GetMethods.getMovieByImdbId(imdbId);
	               
	}
	 	
	 @Test
	 public void testDoRequestForStatusCode(){
	 		 
	 	 requestSpecification
	 	        .when()
	 	        .get(baseURI)
	 	        .then()
	 	        .statusCode(HttpStatus.SC_OK);
	 		   
	     log.info("Status Code = 200");
	         
	 }
	 	 
	 @Test
	 public void testResponseIsEmpty(){   		
		 
		 Response response = requestSpecification.get();
		 assertNotNull(response);
	    		
	     log.info("Response is not empty.");	
	    		
	 }

	 @After
     public void tearDown(){
	    	
    	log.info("Test finished.");
	    
	 }

}
