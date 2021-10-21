package get_http_request_method;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Get01 {

    /*

        Given https://restful-booker.herokuapp.com/booking/3

        When user sends a GET request to the url

        Then HTTP status code should be 200

        And   content type should be Json

        And status line should be HTTP/1.1 200 OK
 */

    @Test
    public void get01(){

        //1.set the url
        String url = "https://restful-booker.herokuapp.com/booking/3";

        //2.Set the expected data


        //3.Send the request and get the response
        Response response  = given().when().get(url);

        response.prettyPrint();



        //Do assertions / Do validations
        //we are making "Hard Assertion"
        response.then().assertThat().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");






    }




}
