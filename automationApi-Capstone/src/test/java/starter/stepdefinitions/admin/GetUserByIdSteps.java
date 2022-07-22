package starter.stepdefinitions.admin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.getuserbyid.Get;

public class GetUserByIdSteps {
    @Steps
    Get get;

    @Given("Admin success auth using new user")
    public void adminSuccessAuthUsingNewUser() {
        get.adminSuccesAuthNewUser();
    }

    @When("Admin set GET api endpoint for get user")
    public void adminSetGETApiEndpointForGetUser() {
        get.setGetApiForGetUser();
    }


    @And("Admin send GET HTTP request for get user")
    public void adminSendGETHTTPRequestForGetUser() {
        get.sendGetHttpForGetUser();
    }

    @Then("Admin receive valid HTTP response code {int} for get user")
    public void adminReceiveValidHTTPResponseCodeForGetUser(int arg0) {
        get.receiveValidDataResponseCode200();
    }

    @And("Admin receive detail data for user")
    public void adminReceiveDetailDataForUser() {
        get.receiveDetailDataForUser();
    }


}
