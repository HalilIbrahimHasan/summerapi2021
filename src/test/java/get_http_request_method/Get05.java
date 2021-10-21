package get_http_request_method;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertTrue;

public class Get05 extends HerOkuAppBaseUrl {

    /*
            Given
                https://restful-booker.herokuapp.com/booking
            When
                User send a request to the URL
            Then
                Status code is 200
            And
               Among the data there should be someone whose firstname is "Jim" and last name is "Jackson"
 */


    @Test
    public void get05(){

        //Set the url
        spec.pathParam("first","booking").queryParams("firstname","Mark"
        ,"lastname","Wilson");

        //Set the expected data

        //send the request and get the response
        Response response = given().spec(spec).when().get("/{first}");

        response.prettyPrint();

        assertTrue(response.asString().contains("bookingid"));


    }


}
