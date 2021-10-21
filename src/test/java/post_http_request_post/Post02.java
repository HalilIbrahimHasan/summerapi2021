package post_http_request_post;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.Todo;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post02 extends JsonPlaceHolderBaseUrl {

    /*
        When
	  		I send POST Request to the Url https://jsonplaceholder.typicode.com/todos
	  		with the request body {
								    "userId": 55,
								    "title": "Tidy your room",
								    "completed": false
								   }
		Then
			Status code is 201
			And response body is like {
									    "userId": 55,
									    "title": "Tidy your room",
									    "completed": false,
									    "id": 201
									  }
     */

    @Test
    public void post02(){

        //Set the URL
        spec.pathParam("first", "todos");

        //Set the expected data
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("userId", 55);
        expectedData.put("title", "Tidy your room");
        expectedData.put("completed", false);

        Todo todo = new Todo(55,1,"Tidy your room",true);
        //Send the Post request and get the response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(todo).when().post("/{first}");



        //do assertion and validate
        response.then().assertThat().statusCode(201);

        response.prettyPrint();


        Map<String,Object> actualData = response.as(HashMap.class);


//        assertEquals("The expected data does not Match!",expectedData.get("userId"),actualData.get("userId") );
//        assertEquals("The expected data does not Match!",expectedData.get("title"),actualData.get("title") );
//        assertEquals("The expected data does not Match!",expectedData.get("completed"),actualData.get("completed") );

    }


}
