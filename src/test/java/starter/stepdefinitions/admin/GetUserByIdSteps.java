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

    @Then("Admin receive valid HTTP response code 200 for get user")
    public void adminReceiveValidHTTPResponseCodeForGetUser() {
        get.receiveValidDataResponseCode200();
    }

    @And("Admin receive detail data for user")
    public void adminReceiveDetailDataForUser() {
        get.receiveDetailDataForUser();
    }


    @Then("Admin receive valid HTTP response code 400 for get user")
    public void adminReceiveValidHTTPResponseCode400ForGetUser() {
        get.receiveCode400ForGetUser();
    }

    @And("Admin receive message invalid or expired jwt for get user")
    public void adminReceiveMessageInvalidOrExpiredJwtForGetUser() {
        get.receiveMsgExpiredJwt();
    }

    @When("Admin send GET HTTP request for get user wihout login")
    public void adminSendGETHTTPRequestForGetUserWihoutLogin() {
        get.sendHttpRequestWithoutLogin();
    }
}
