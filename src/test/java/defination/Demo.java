package defination;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

public class Demo {

    @Given("^url is ready$")
    public void url_is_ready() throws Throwable {

        System.out.println("helo");

    }

    @When("^get url hitted$")
    public void get_url_hitted() throws Throwable {

      Response response = (Response) RestAssured.given().get("https://gorest.co.in/public/v2/users").body();

      int code = response.getStatusCode();
      String email = response.getBody().jsonPath().getJsonObject("email[0]");
      String name =  response.getBody().jsonPath().getJsonObject("name[0]");


        System.out.println(email);
    }

    @Then("^validate response$")
    public void validate_response() throws Throwable {

        System.out.println("helo4");
        System.out.println("helo 5");

        System.out.println();
    }
}
