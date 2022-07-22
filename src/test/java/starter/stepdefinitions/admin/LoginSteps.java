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

    @When("Admin send POST HTTP request for invalid password")
    public void adminSendPOSTHTTPRequestForInvalidPassword() {
        post.sendInvalidPassword();
    }

    @Then("Admin receive invalid HTTP response code 401 for login")
    public void adminReceiveInvalidHTTPResponseCodeForLogin() {
        post.receive401forInvalidPassword();
    }

    @And("Admin receive message")
    public void adminReceiveMessageForInvalidPassword() {
        post.receiveMessageForInvalidPassword();
    }


    @When("Admin send POST HTTP request for invalid idpegawai")
    public void adminSendPOSTHTTPRequestForInvalidIdpegawai() {
        post.sendPostForInvalidIdpegawai();
    }

    @When("Admin send POST HTTP request for null idpegawai and password")
    public void adminSendPOSTHTTPRequestForNullIdpegawaiAndPassword() {
        post.sendPostNulldata();

    }

    @Then("Admin receive invalid HTTP response code 400")
    public void adminReceiveValidHTTPResponseCode() {
        post.receiveStatusCode400();
    }

    @And("Admin receive message bad request")
    public void adminReceiveMessageBadRequest() {
        post.receiveMessageBadRequest();
    }


    @When("Admin send POST HTTP request for login with unregistered data")
    public void adminSendPOSTHTTPRequestForLoginWithUnregisteredData() {
        post.sendRequestForLoginWithUnregisteredData();
    }
}
