package Starter.StepDefinitions;

import Starter.Pages.DashboardPage;
import Starter.Pages.InvoicePage;
import Starter.Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class InvoiceCancelSendStep {

    @Steps
    InvoicePage invoicePage;

    @Steps
    LoginPage loginPage;

    @Steps
    DashboardPage dashboardPage;

    @Given("I am on The Login pages")
    public void iAmOnTheLoginPages() {
        loginPage.openUrl("https://profound-chaja-c7a5cb.netlify.app/");
        loginPage.validateOnLoginPage();
    }

    @When("I inputt {string} NIPs")
    public void iInputNips(String nip) {
        loginPage.inputNip(nip);
    }

    @And("I inputt {string} Passwords")
    public void iInputPasswords(String password) {

        loginPage.inputPassword(password);
    }

    @And("Click Login buttons")
    public void clickLoginButtons() {
        loginPage.clickLoginButton();
    }

    @And("I Get to Dashboard Pages")
    public void iGetToDashboardPages() {
        dashboardPage.headerTextEqual();
        dashboardPage.openUrl("https://profound-chaja-c7a5cb.netlify.app/dashboard");
    }

    @And("Click Invoice Pages")
    public void clickInvoicePages() {
        dashboardPage.clickInvoicePage();
    }

    @And("Click send invoice button")
    public void clickSendInvoice() {
        invoicePage.clickSendButton();
    }

    @And("click cancel send invoice button")
    public void clickSendCancelInvoice() {
        invoicePage.clickCancelSendButton();
    }

    @Then("I Validate the {string} Results")
    public void iGetTheResults(String result) {
        if (result.equals("invoice page")) {
            invoicePage.headerAppears();
            invoicePage.headerTextEqual();

        }
    }
}
