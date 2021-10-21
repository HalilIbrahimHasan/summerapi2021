package get_http_request_method;

import base_urls.DummyApiBaseUrl;
import com.google.gson.Gson;
import dummypojo.Employee;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;

public class Get06 extends DummyApiBaseUrl {

    /*
      When
        I send a GET Request to the URL http://dummy.restapiexample.com/api/v1/employees
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
        And
    User can see following employees in the system
    Doris Wilder, Jenette Caldwell and Bradley Greer

  */

    @Test
    public void get06(){
        //set the url
        spec.pathParams("first", "api","second","v1","third","employees");

        //set the expected data

        //send thr request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}/{third}");
        response.prettyPrint();

        //Do assertion and validate
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).
                body("data.employee_name",hasItems("Doris Wilder","Jenette Caldwell","Bradley Greer"));




    }







    @Test
    public void dummy() throws IOException {
        //set the url
        spec.pathParams("first", "api", "second", "v1", "third", "employees");

        //Send the request

        Response response = given().spec(spec).when().get("/{first}/{second}/{third}");

        ObjectMapper obj = new ObjectMapper();

//        Employee employees = obj.readValue(response.asString(),Employee.class );
//
//        System.out.println(employees.getData().get(0).getEmployee_name());
//        System.out.println(employees.getData().get(0).getEmployee_salary());
//        System.out.println(employees.getData().get(0).getEmployee_age());


        Map<String, Object> actualData = obj.readValue(response.asString(), HashMap.class);

        Gson gson = new Gson();

        System.out.println(actualData);

        Map<String, Object> actualData2 = gson.fromJson(response.asString(), HashMap.class);

        System.out.println(actualData2);

        Employee employees = gson.fromJson(response.asString(), Employee.class);

        System.out.println("Employee number: " +employees.getData().size());


        String json = gson.toJson(employees);

        System.out.println(json);

    }
}
