package starter.stepdefinitions.admin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.invoice.GetAll;
import starter.invoice.GetById;
import starter.invoice.Post;

public class InvoiceSteps {

    @Steps
    Post post;

    @Steps
    GetAll getAll;

    @Steps
    GetById getById;


    @Given("Admin success auth using new user for Invoice")
    public void adminSuccessAuthUsingNewUserForInvoice() {
        post.adminSuccesAuthNewUserForInvoice();
    }

    @When("Admin set POST api endpoint for Invoice")
    public void adminSetPOSTApiEndpointForInvoice() {
        post.adminSetPostApiForInvoice();
    }

    @And("Admin send POST HTTP request for Invoice")
    public void adminSendPOSTHTTPRequestForInvoice() {
        post.adminSendPostHttpForInvoice();
    }

    @Then("Admin receive valid HTTP response code {int} for Invoice")
    public void adminReceiveValidHTTPResponseCodeForInvoice(int arg0) {
        post.receiveValidCode201ForInvoice();
    }

    @And("Admin receive detail Invoice")
    public void adminReceiveDetailInvoice() {
        post.receiveDetailInvoice();
    }

    @Given("Admin success auth using new user for Get All Invoice")
    public void adminSuccessAuthUsingNewUserForGetAllInvoice() {
        getAll.adminSuccesAuthNewUserForGetAllInvoice();
    }

    @When("Admin set GET api endpoint for Get All Invoice")
    public void adminSetGETApiEndpointForGetAllInvoice() {
        getAll.adminSetGetApiForGetAll();
    }

    @And("Admin send GET HTTP request for Get All Invoice")
    public void adminSendGETHTTPRequestForGetAllInvoice() {
        getAll.adminSendHttpRequestForGetAllInvoice();
    }

    @Then("Admin receive valid HTTP response code {int} for Get All Invoice")
    public void adminReceiveValidHTTPResponseCodeForGetAllInvoice(int arg0) {
        getAll.receiveValidResponseCode200();
    }

    @And("Admin receive detail All Invoice")
    public void adminReceiveDetailAllInvoice() {
        getAll.receiveDetailAllInvoice();
    }


    @Given("Admin success auth using new user for Get Invoice by Id")
    public void adminSuccessAuthUsingNewUserForGetInvoiceById() {
        getById.adminSuccesAuthNewUserForGetInvoiceById();
    }

    @When("Admin set GET api endpoint for Get Invoice by Id")
    public void adminSetGETApiEndpointForGetInvoiceById() {
        getById.adminSetGetApiForGetById();
    }

    @And("Admin send GET HTTP request for Get Invoice by Id")
    public void adminSendGETHTTPRequestForGetInvoiceById() {
        getById.adminSendHttpRequestForGetInvoiceById();
    }

    @Then("Admin receive valid HTTP response code {int} for Get Invoice by Id")
    public void adminReceiveValidHTTPResponseCodeForGetInvoiceById(int arg0) {
        getById.receiveValidResponseCode200GetInvoiceById();
    }

    @And("Admin receive detail Invoice by Id")
    public void adminReceiveDetailInvoiceById() {
        getById.receiveDetailInvoiceById();
    }

    @Then("Admin receive invalid HTTP response code 400 for Invoice")
    public void adminReceiveValidHTTPResponseCode() {
        getAll.receiveStatusCode400();
    }

    @And("Admin receive message invalid or expired jwt")
    public void adminReceiveMessageInvalidOrExpiredJwt() {
        getAll.receiveMessageExpiredJwt();

    }

    @Then("Admin receive invalid HTTP response code 500 for Invoice")
    public void adminReceiveInvalidHTTPResponseCodeForInvoice() {
        post.receiveStatusCode500ForInvoice();
    }

    @And("Admin receive message Internal Server Error")
    public void adminReceiveMessageInternalServerError() {
        post.receiveMessageServerError();
    }

    @And("Admin send POST HTTP request for Invoice with different extensions")
    public void adminSendPOSTHTTPRequestForInvoiceWithDifferentExtensions() {
        post.sendHttpForDifferent();
    }

    @Then("Admin receive valid HTTP response code 400 for Invoice with different extensions")
    public void adminReceiveValidHTTPResponseCodeForInvoiceWithDifferentExtensions() {
        post.receiveHttp400ForDifferent();
    }

    @And("Admin receive message invalid extension file")
    public void adminReceiveMessageInvalidExtensionFile() {
        post.receiveMsgInvalidExtension();
    }

    @When("Admin send GET HTTP request for Get All Invoice without send file csv")
    public void adminSendGETHTTPRequestForGetAllInvoiceWithoutSendFileCsv() {
        post.sendWithoutSendFileCsv();
    }

    @When("Admin send GET HTTP request for Get All Invoice without login")
    public void adminGetAllInvoiceWithoutLogin(){
        getAll.sendGetAllInvoiceWithoutLogin();

    }

    @When("Admin send GET HTTP request for Get Invoice by Id without login")
    public void sendHttpInvoiceByIdWithoutLogin(){
        getById.sendHttpInvoiceByIdWithoutLogin();
    }

    @When("Admin send POST HTTP request for Invoice without login")
    public void sendPostForInvoiceWithoutLogin(){
        post.sendPostForInvoiceWithoutLogin();

    }
}


