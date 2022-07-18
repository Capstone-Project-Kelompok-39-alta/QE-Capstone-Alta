package Starter.StepDefinitions;

import Starter.Pages.DashboardPage;
import Starter.Pages.InvoicePage;
import Starter.Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class InvoiceSendStep {
    @Steps
    InvoicePage invoicePage;

    @Steps
    LoginPage loginPage;

    @Steps
    DashboardPage dashboardPage;

    @Given("I am on the Login pages")
    public void iAmOnTheLoginPages() {
        loginPage.openUrl("https://profound-chaja-c7a5cb.netlify.app/");
        loginPage.validateOnLoginPage();
    }

    @When("I input {string} NIPs")
    public void iInputNips(String nip) {
        loginPage.inputNip(nip);
    }

    @And("I input {string} Passwords")
    public void iInputPasswords(String password) {

        loginPage.inputPassword(password);
    }

    @And("click Login buttons")
    public void clickLoginButtons() {
        loginPage.clickLoginButton();
    }

    @And("I get to Dashboard Pages")
    public void iGetToDashboardPages() {
        dashboardPage.headerTextEqual();
        dashboardPage.openUrl("https://profound-chaja-c7a5cb.netlify.app/dashboard");
    }

    @And("click Invoice Pages")
    public void clickInvoicePages() {
        dashboardPage.clickInvoicePage();
    }

    @And("click send invoice button")
    public void clickSendInvoice() {
        invoicePage.clickSendButton();
    }

    @Then("I validate the {string} Results")
    public void iGetTheResults(String result) {
        if (result.equals("invoice page")) {
            invoicePage.headerAppears();
            invoicePage.headerTextEqual();

        }
    }
}
