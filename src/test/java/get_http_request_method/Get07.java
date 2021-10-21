package get_http_request_method;

import base_urls.DummyApiBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Get07 extends DummyApiBaseUrl {



    /*
        Given
             http://dummy.restapiexample.com/api/v1/employee/7
        When
	 	    I send a GET request to the Url

	    Then
	        HTTP Status Code should be 200
	    And
	        Response format should be "application/json"
	    And
	        Herrod Chandler should be the employee name
	    And
	        "employee_salary":137500 should be expected salary
	    And
	       "id":7 should be expected id
     */

    @Test
    public void get07(){

        //Set the url
        spec.pathParams("first","api","second","v1","third","employee","final",7);

        //send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}/{third}/{final}");

//        response.prettyPrint();

        //1. way of validation
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).
                body("data.employee_name",equalTo("Herrod Chandler")).
                body("data.employee_salary",equalTo(137500)).
                body("data.id",equalTo(7));

        //2. way of validation

        JsonPath json = response.jsonPath();

        System.out.println(json.getString("data.employee_name"));
        System.out.println(json.getString("data.employee_salary"));

        response.prettyPrint();
        //Soft assert will assert and validate all scenarios
        SoftAssert softAssert = new SoftAssert();


        softAssert.assertEquals( "Herrod Chandler", json.getString("data.employee_name"),"The data does match!");
        softAssert.assertEquals( 137500, json.getInt("data.employee_salary"),"The data does match!");


        softAssert.assertAll();


    }

}
