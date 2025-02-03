package Page;

import io.restassured.response.Response;
import org.junit.Assert;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ApiPage {
    public Response r;
    public void getApi(String url ){
        r = given().when().get(url).then().statusCode(200).extract().response();
    }
    public void verifyResponse(){
        Map<String,Object> map = r.jsonPath().getMap("bpi");
        assertEquals("API response does not contain 3 BPIs", 3, map.size());
        assertTrue("API response does not contains USD",map.containsKey("USD"));
        assertTrue("API response does not contains GBP",map.containsKey("GBP"));
        assertTrue("API response does not contains EUR",map.containsKey("EUR"));

        String gbpDesc = r.jsonPath().getString("bpi.GBP.description");
        Assert.assertEquals("GBP Descrition is Incorrect", "British Pound Sterling", gbpDesc);
    }
}

