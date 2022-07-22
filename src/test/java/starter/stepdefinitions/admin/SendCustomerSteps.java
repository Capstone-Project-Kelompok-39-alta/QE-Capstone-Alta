package starter.stepdefinitions.admin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.sendcustomer.Post;

public class SendCustomerSteps {
    @Steps
    Post post;


    @Given("Admin success auth using new user for send email")
    public void adminSuccessAuthUsingNewUserForSendEmail() {
        post.adminSuccesAuthNewUserForSendEmail();
    }

    @When("Admin set POST api endpoint for send email")
    public void adminSetPOSTApiEndpointForSendEmail() {
        post.adminSetPostApiForSendEmail();
    }

    @And("Admin send POST HTTP request for send email")
    public void adminSendPOSTHTTPRequestForSendEmail() {
        post.adminSendPostHttpForSendEmail();
    }

    @Then("Admin receive valid HTTP response code {int} for send email")
    public void adminReceiveValidHTTPResponseCodeForSendEmail(int arg0) {
        post.receiveValidCode201ForSendEmail();
    }

    @And("Admin receive detail for send email")
    public void adminReceiveDetailForSendEmail() {
        post.receiveDetailForSendEmail();
    }
}
