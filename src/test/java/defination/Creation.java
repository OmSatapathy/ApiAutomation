package defination;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.CoreMatchers;

import static org.hamcrest.CoreMatchers.equalTo;

public class Creation {

    private ValidatableResponse validatableResponse;
    private String endpoint = "http://dummy.restapiexample.com/api/v1/employee/1";

    @Given("^I send a request to the URL to get user details$")
    public void i_send_a_request_to_the_URL_to_get_user_details() throws Throwable {

        validatableResponse = RestAssured.given().contentType(ContentType.JSON)
                .when().get(endpoint).then();

        System.out.println("Response :"+validatableResponse.extract().toString());

        throw new PendingException();
    }

    @Then("^Creation.the_response_will_return_status_and_id_and_salary_and_name_and_age_and_message(int,int,int,String,int,String)\n")
    public void the_response_will_return_status_and_id_and_salary_and_name_and_age_and_message(int statusCode, int id, int emp_Salary, String emp_name, int emp_age, String message) throws Throwable {


        validatableResponse.assertThat().statusCode(statusCode);

        validatableResponse.assertThat().body("data.id",equalTo(id));

        validatableResponse.assertThat().body("data.employee_salary",equalTo(emp_Salary));

        validatableResponse.assertThat().body("data.employee_name",equalTo(emp_name));

        validatableResponse.assertThat().body("data.employee_age", equalTo(emp_age));

        validatableResponse.assertThat().body("message", equalTo(message));
        throw new PendingException();
    }
}
