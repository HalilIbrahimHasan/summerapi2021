package get_http_request_method;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get02 extends HerOkuAppBaseUrl {



/*

            Given https://restful-booker.herokuapp.com/booking/1001

            When user sends a GET request to the url

            Then HTTP status code should be 404

            And   response body contains "Not Found"

            And status line should be HTTP/1.1 404 Not Found

            And body does not contain "techproed"

            And Server is "Cowboy"
             */
            //Set the url
            //String url = "https://restful-booker.herokuapp.com/booking/1001"


    @Test
    public void get02(){

        //when you name path params, names can be anything
        //Set the url
        spec.pathParams("first","booking","second",1001);



        //Set the expected data

        //Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");

        response.prettyPrint();


//        System.out.println("status code : "+response.statusCode());
//        System.out.println("status line : "+response.getStatusLine());
//        System.out.println("ALl headers : "+response.getHeaders());

        System.out.println("Response Body: "+ response.asString());


        //Do assertions / validation
        response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");

        System.out.println(response.asString().contains("Not Found"));

        //This is only used for true statements / when you have true statements, it will work fine
        assertTrue("The expected data does not match with actual data!",response.asString().contains("Not Found"));

        assertFalse(response.asString().contains("techproed"));



    }

}
