package Starter.StepDefinitions;

import Starter.Pages.DashboardPage;
import Starter.Pages.InvoicePage;
import Starter.Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class InvoiceDetailStep {


    @Steps
    InvoicePage invoicePage;

    @Steps
    LoginPage loginPage;

    @Steps
    DashboardPage dashboardPage;

    @Given("I am on the Login page")
    public void iAmOnTheLoginPage() {
        loginPage.openUrl("https://profound-chaja-c7a5cb.netlify.app/");
        loginPage.validateOnLoginPage();
    }

    @When("I input {string} NIP")
    public void iInputNip(String nip) {
        loginPage.inputNip(nip);
    }

    @And("I input {string} Password")
    public void iInputPassword(String password) {

        loginPage.inputPassword(password);
    }

    @And("click Login button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @And("I get to Dashboard page")
    public void iGetToDashboardPage() {
        dashboardPage.headerTextEqual();
        dashboardPage.openUrl("https://profound-chaja-c7a5cb.netlify.app/dashboard");
    }

    @And("click Invoice Page")
    public void clickInvoicePage() {
        dashboardPage.clickInvoicePage();
    }

    @And("click detail invoice button")
    public void clickDetailInvoice() {
        invoicePage.clickDetailButton();
    }

    @Then("I validate the {string} Result")
    public void iGetTheResult(String result) {
        if (result.equals("invoice page")) {
            invoicePage.headerAppears();
            invoicePage.headerTextEqual();

        }
    }
}