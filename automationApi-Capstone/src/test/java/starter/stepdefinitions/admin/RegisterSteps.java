package starter.stepdefinitions.admin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import starter.register.Post;

public class RegisterSteps {
    @Steps
    Post post;

    @Given("Admin set POST api endpoint for register")
    public void setPostApiEndpoint(){
        post.setPostApiEndpoints();

    }

    @When("Admin send POST HTTP request for register")
    public void iSendPOSTHTTPRequest() {
        post.sendPostHttpRequest();
    }

    @Then("Admin receive valid HTTP response code 201")
    public void iReceiveValidHTTPResponseCode() {
        post.receiveHttpResponseCode201();
    }

    @And("Admin receive valid data for new user")
    public void iReceiveValidDataForNewUser() {
        post.receiveDataNewUser();

    }


    @Then("Admin receive valid HTTP response code 406")
    public void adminReceiveValidHTTPResponseCode() {
        post.adminReceveiveCode406();
    }

    @And("Admin receive message User exists")
    public void adminReceiveMessage() {
        post.receiveMessageUserExists();
    }
}
