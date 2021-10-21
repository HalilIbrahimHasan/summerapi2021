package get_http_request_method;

import base_urls.DummyApiBaseUrl;
import com.google.gson.Gson;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import pojos.Employee;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertTrue;

public class Get11 extends DummyApiBaseUrl {

    /*
      When
        I send a GET Request to the URL http://dummy.restapiexample.com/api/v1/employees

       Status code should be 200
       Use Gson and ObjectMapper

       make sure you have 24 records for data


  */

    @Test
    public void get11() throws IOException {

        //Set the URL
        spec.pathParams("first", "api","second","v1","third","employees");


        //Set the expected data
        ObjectMapper obj = new ObjectMapper();

        //Send the Get request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}/{third}");

//        response.prettyPrint();

        //This action converts all data from Json to Java
        Employee employees = obj.readValue(response.asString(),Employee.class);





        for (int i = 0; i < employees.getData().size() ; i++) {

            System.out.println("Employee name : "+employees.getData().get(i).getEmployee_name());
            System.out.println("Employee age : "+employees.getData().get(i).getEmployee_age());
            System.out.println("Employee salary : "+employees.getData().get(i).getEmployee_salary());
        }


        //Do the assertion and validate
        assertTrue("The expected data Does Not Match!",employees.getData().size() == 24 );


        Map<String, Object> expectedDataMap = obj.readValue(response.asString(), HashMap.class);
        System.out.println(expectedDataMap);



    }



    @Test
    public void get12() throws IOException {

        //Set the URL
        spec.pathParams("first", "api", "second", "v1", "third", "employees");


        //Set the expected data / use GSON for deserialization
        Gson gson = new Gson();

        //Send the Get request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}/{third}");

        Employee employees = gson.fromJson(response.asString(), Employee.class);

        System.out.println("Employee salary : " + employees.getData().get(0).getEmployee_salary());

        assertTrue("The data does not Match!",employees.getData().size() ==24 );


        Map<String, Object> expectedData = gson.fromJson(response.asString(), HashMap.class);

        System.out.println(expectedData);

    }

    }
