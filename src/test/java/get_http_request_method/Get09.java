package get_http_request_method;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.Todo;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class Get09 extends HerOkuAppBaseUrl {

    /*
        When
	 		I send GET Request to https://restful-booker.herokuapp.com/booking/1
	 	Then
	 		Response body should be like that;
	 		{
			    "firstname": "Susan",
			    "lastname": "Ericsson",
			    "totalprice": 564,
			    "depositpaid": false,
			    "bookingdates": {
			        "checkin": "2018-08-19",
			        "checkout": "2021-06-20"
			     }
			}
     */

    @Test
    public void get09(){

        //Set the URL
        spec.pathParams("first", "booking", "second",1);

        //Set the expected data
        Map<String,Object> expectedBookingdates = new HashMap<>();
        expectedBookingdates.put("checkin","2016-08-02");
        expectedBookingdates.put("checkout","2017-04-30");

        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("firstname", "Susan");
        expectedData.put("lastname", "Jones");
        expectedData.put("totalprice", 974);
        expectedData.put("depositpaid", true);
        expectedData.put("bookingdates", expectedBookingdates);


        //Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");

        Map<String, Object> actualData = response.as(HashMap.class);

        System.out.println("actual Data: "+ actualData);
        response.prettyPrint();

        assertEquals("The expected data Match!",expectedData.get("firstname"),actualData.get("firstname"));
        assertEquals("The expected data Match!",expectedData.get("lastname"),actualData.get("lastname"));
        assertEquals("The expected data Match!",expectedBookingdates.get("checkin"),((Map)actualData.get("bookingdates")).get("checkin"));
        assertEquals("The expected data Match!",expectedBookingdates.get("checkout"),((Map)actualData.get("bookingdates")).get("checkout"));
    }


}
