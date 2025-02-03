package StepDef;


import Page.ApiPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.Map;

import static org.junit.Assert.*;

public class ApiStepDef {
    public static Response r;
    ApiPage apiPage = new ApiPage();

    @Given("Send GET request on {string}")
    public void getAPI(String string){
        apiPage.getApi(string);

    }

    @Then("Verify response")
    public void verifyResponse(){
        apiPage.verifyResponse();
    }
}

