package Starter.StepDefinitions;

import Starter.Pages.DashboardPage;
import Starter.Pages.HistoryEmailPage;
import Starter.Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class DeleteHistoryEmailStep {

    @Steps
    HistoryEmailPage historyEmailPage;

    @Steps
    LoginPage loginPage;

    @Steps
    DashboardPage dashboardPage;

    @Given("I am on the Login Pages")
    public void iAmOnTheLoginPage() {
        loginPage.openUrl("https://profound-chaja-c7a5cb.netlify.app/");
        loginPage.validateOnLoginPage();
    }

    @When("I input {string} NipS")
    public void iInputNip(String nip) {
        loginPage.inputNip(nip);
    }

    @And("I input {string} PASSWORD")
    public void iInputPassword(String password) {

        loginPage.inputPassword(password);
    }

    @And("click Login Buttons")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @And("I get to Dashboard pages")
    public void iGetToDashboardPages() {
        dashboardPage.headerTextEqual();
        dashboardPage.openUrl("https://profound-chaja-c7a5cb.netlify.app/dashboard");
    }

    @And("click History Email Pages")
    public void clickHistoryPage() {
        dashboardPage.clickHistoryPage();
    }

    @And("click delete buttons")
    public void clickDeleteButton() {
       historyEmailPage.clickDeleteButton();
    }

    @Then("I validate the {string} results")
    public void iGetTheResult(String result) {
        if (result.equals("history page")) {
            historyEmailPage.headerAppears();
            historyEmailPage.headerTextEqual();

        }
    }
}
