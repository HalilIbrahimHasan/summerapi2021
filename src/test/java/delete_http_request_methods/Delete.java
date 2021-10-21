package delete_http_request_methods;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class Delete extends JsonPlaceHolderBaseUrl {

     /*
        When
	 		I send DELETE Request to the Url https://jsonplaceholder.typicode.com/todos/198
	 	Then
		 	Status code is 200
		 	And Response body is {}
    */


    @Test
    public void delete01(){

        //Set the URL
        spec.pathParams("first","todos","second", 198);


        //Set the expected Data
        Map<String, Object> expectedData = new HashMap<>();
        System.out.println(expectedData);


        //Send the Delete request and get the response
        Response response = given().spec(spec).when().delete("/{first}/{second}");

        response.prettyPrint();

        //Do the assertions and validate

        Map<String,Object> actualData = response.as(HashMap.class);
        System.out.println(actualData);
        assertEquals("The expected data Does Not Match!",expectedData, actualData );

        assertTrue(actualData.size() == 0);

    }



}
