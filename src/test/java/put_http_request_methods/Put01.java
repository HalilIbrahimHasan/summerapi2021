package put_http_request_methods;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.Todo;
import test_data.JsonPlaceHolderData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class Put01 extends JsonPlaceHolderBaseUrl {

         /*
         When
	 		I send PUT Request to the Url https://jsonplaceholder.typicode.com/todos/198
	 		with the PUT Request body like {
										    "userId": 21,
										    "title": "Wash the dishes",
										    "completed": false
										   }
	     Then
	   	   Status code is 200
	   	   And response body is like   {
									    "userId": 21,
									    "title": "Wash the dishes",
									    "completed": false,
									    "
									   }
     */


    @Test
    public void put01(){

        //Set the URL
        spec.pathParams("first", "todos","second",198);


        //Set the expected data
        JsonPlaceHolderData data = new JsonPlaceHolderData();
//        Map<String, Object> expectedDataMap = data.expectedDataSetup();
        Map<String, Object> expectedDataMap = new HashMap<>();
        expectedDataMap.put("userId",21);
        expectedDataMap.put("title","Wash the dishes");
        expectedDataMap.put("completed",false);

        //2. way of setting the data
        Todo expectedTodo = new Todo(21, 2,"Wash the dishes", false);

        Todo todo = new Todo();
        todo.setCompleted(false);
        todo.setUserId(21);
        todo.setTitle("Wash the dishes");
        todo.setId(2);


        //Send the Put request and get the response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(todo).when().put("/{first}/{second}");


        response.prettyPrint();

        //Do the assertions and validate them
        //1. way of validation
        response.then().assertThat().statusCode(200).body("title",equalTo("Wash the dishes")).
                body("userId",equalTo(21)).body("completed",equalTo(false));


        //2. way of validation
        Map<String, Object> actualData = response.as(HashMap.class);

        assertEquals("The expected data Does Not Match!!",expectedDataMap.get("userId"), actualData.get("userId") );
        assertEquals("The expected data Does Not Match!!",expectedDataMap.get("title"), actualData.get("title") );
        assertEquals("The expected data Does Not Match!!",expectedDataMap.get("completed"), actualData.get("completed") );


        //3.way of validation
        Todo actualTodo = response.as(Todo.class);

        assertEquals("The expected Data Does Not Match!",expectedTodo.getUserId(), actualTodo.getUserId() );
        assertEquals("The expected Data Does Not Match!",expectedTodo.getTitle(), actualTodo.getTitle() );
        assertEquals("The expected Data Does Not Match!",expectedTodo.isCompleted(), actualTodo.isCompleted() );


        //4. way of validation

        JsonPath json = response.jsonPath();

        System.out.println(json.getString("userId"));
        System.out.println(json.getInt("id"));
        System.out.println(json.getString("title"));

        assertEquals("The expected Data Does Not Match!!", expectedTodo.getUserId(), Integer.parseInt(json.getString("userId")));



    }




}
