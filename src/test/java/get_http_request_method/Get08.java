package get_http_request_method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.Todo;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class Get08 extends JsonPlaceHolderBaseUrl {

    /*
     Given
            https://jsonplaceholder.typicode.com/todos/2
     When I send a Get Request

     Then the actual data should be as following;
        {
        "userId": 1,
        "id": 2,
        "title": "quis ut nam facilis et officia qui",
        "completed": false
    }

     */

    @Test
    public void get08(){

        //Set the URL
        spec.pathParams("first","todos","second",2);

        //Set the expected data
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("userId", 1);
        expectedData.put("id", 2);
        expectedData.put("title", "quis ut nam facilis et officia qui");
        expectedData.put("completed", false);

        //Send the Get request and get the Response
        Response response = given().spec(spec).when().get("/{first}/{second}");

        Map<String, Object> actualData = response.as(HashMap.class);

        System.out.println("actualData: "+actualData);


        //Do the assertions / validate them
        assertEquals("The data does not Match!",expectedData.get("userId"), actualData.get("userId"));
        assertEquals("The data does not Match!",expectedData.get("id"), actualData.get("id"));
        assertEquals("The data does not Match!",expectedData.get("title"), actualData.get("title"));
        assertEquals("The data does not Match!",expectedData.get("completed"), actualData.get("completed"));

    }


    @Test
    public void get09(){
        //1) Set the Url
        spec.pathParams("first", "todos","second",2);

        //Set the expected data
        Todo expectedTodo = new Todo(1,2,"quis ut nam facilis et officia qui",false);



        //Send the request and get the response

        Response response = given().spec(spec).when().get("/{first}/{second}");


        Todo actualTodo = response.as(Todo.class);

        assertEquals("The data does not Match!",expectedTodo.getId(),actualTodo.getId());
        assertEquals("The data does not Match!",expectedTodo.getTitle(),actualTodo.getTitle());





    }


}
