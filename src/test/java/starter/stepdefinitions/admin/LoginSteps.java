package starter.stepdefinitions.admin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.login.Post;

public class LoginSteps {
    @Steps
    Post post;

    @Given("Admin set POST api endpoint for login")
    public void setApiforLogin(){
        post.setPostApiEndpointsForLogin();

    }
    @When("Admin send POST HTTP request for login")
    public void sendApiForLogin(){
        post.sendPostHttpRequestForLogin();

    }

    @Then("Admin receive valid HTTP response code 200 for login")
    public void adminReceiveValidHTTPResponseCodeForLogin() {
        post.receiveHttpResponseCode200();
    }


    @And("Admin receive token and message")
    public void adminReceiveMessage() {
        post.receiveTokenAndMessage();
    }
}
