package patch_http_request_methods;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.Todo;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class Patch01 extends JsonPlaceHolderBaseUrl {


     /*
        When
	 		I send PATCH Request to the Url https://jsonplaceholder.typicode.com/todos/198
	 		with the PUT Request body like {
										    "title": "Tidy your room"
										   }
	   Then
	   	   Status code is 200
	   	   And response body is like  {
									    "userId": 10,
									    "title": "Tidy your room",
									    "completed": true,
									    "id": 198
									  }
     */

    @Test
    public void patch01(){

        //Set the URL
        spec.pathParams("first","todos","second",198);

        //Set the expected data
        Map<String,Object> expectedData = new HashMap<>();
        expectedData.put("userId",29);

        Todo expectedTodo = new Todo();
        expectedTodo.setTitle("Tidy your room");

        //Send the request and get the response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().patch("/{first}/{second}");

        response.prettyPrint();
        //Do the assertion and validate

        Map<String , Object> actualData = response.as(HashMap.class);
        assertEquals("The expected Data Does Not Match!!!",expectedData.get("userId"), actualData.get("userId") );







    }



}
