package post_http_request_post;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post01 extends HerOkuAppBaseUrl {


     /*
        When
	 		I send POST Request to the Url https://restful-booker.herokuapp.com/booking
	 		with the request body {
								    "firstname": "Osman",
								    "lastname": "Ak",
								    "totalprice": 11111,
								    "depositpaid": true,
								    "bookingdates": {
								        "checkin": "2021-09-09",
								        "checkout": "2021-09-21"
								     }
								  }
	 	Then
	 		Status code is 200
	 		And response body should be like {
											    "bookingid": 11,
											    "booking": {
											        "firstname": "Osman",
											        "lastname": "Ak",
											        "totalprice": 11111,
											        "depositpaid": true,
											        "bookingdates": {
											            "checkin": "2021-09-09",
											            "checkout": "2021-09-21"
											        }
											    }
											 }
     */

    @Test
    public void post01(){

        //Set the URL
        spec.pathParam("first","booking");

        //Set the expected data
        Map<String,Object> expectedBookingdates = new HashMap<>();
        expectedBookingdates.put("checkin","2021-09-09");
        expectedBookingdates.put("checkout","2021-09-21");

        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("firstname", "Osman");
        expectedData.put("lastname", "Ak");
        expectedData.put("totalprice", 11111);
        expectedData.put("depositpaid", true);
        expectedData.put("bookingdates", expectedBookingdates);

        //Send the Post request and get the response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");

        //Do the assertion / validate
        response.then().assertThat().statusCode(200);

        Map<String,Object> actualData = response.as(HashMap.class);

        response.prettyPrint();
        assertEquals("The expected Data does not Match!", expectedData.get("firstname"),((Map)actualData.get("booking")).get("firstname"));
        assertEquals("The expected Data does not Match!", expectedData.get("lastname"),((Map)actualData.get("booking")).get("lastname"));
        assertEquals("The expected Data does not Match!", expectedData.get("depositpaid"),((Map)actualData.get("booking")).get("depositpaid"));
        assertEquals("The expected Data does not Match!", expectedData.get("totalprice"),((Map)actualData.get("booking")).get("totalprice"));

    }
}
