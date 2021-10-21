package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class HerOkuAppBaseUrl {

    //this will be data type/ reference that we need to setup
    protected RequestSpecification spec;

    //This annotation will run before each test case / @Test
    @Before
    public void setup(){

        //we will set our base url
        spec = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();


    }


}
