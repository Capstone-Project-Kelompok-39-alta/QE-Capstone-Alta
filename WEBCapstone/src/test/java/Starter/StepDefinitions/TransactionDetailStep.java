package Starter.StepDefinitions;

import Starter.Pages.DashboardPage;
import Starter.Pages.LoginPage;
import Starter.Pages.TransactionPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class TransactionDetailStep {
    @Steps
    TransactionPage transactionPage;

    @Steps
    LoginPage loginPage;

    @Steps
    DashboardPage dashboardPage;

    @Given("I am on the Login Page")
    public void iAmOnTheLoginPage() {
        loginPage.openUrl("https://profound-chaja-c7a5cb.netlify.app/");
        loginPage.validateOnLoginPage();
    }

    @When("I input {string} NIPS")
    public void iInputNip(String nip) {
        loginPage.inputNip(nip);
    }

    @And("I input {string} PassworD")
    public void iInputPassword(String password) {

        loginPage.inputPassword(password);
    }

    @And("click Login Button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @And("I get to Dashboard Page")
    public void iGetToDashboardPage() {
        dashboardPage.headerTextEqual();
        dashboardPage.openUrl("https://profound-chaja-c7a5cb.netlify.app/dashboard");
    }

    @And("click Transaction Page")
    public void clickTransactionPage() {
        dashboardPage.clickTransactionPage();
    }

    @And("click detail transaction button")
    public void clickDetailTransaction() {
        transactionPage.clickDetailButton();
    }

    @Then("I validate the {string} Resultt")
    public void iGetTheResult(String result) {
        if (result.equals("invoice page")) {
            transactionPage.headerAppears();
            transactionPage.headerTextEqual();

        }
    }
}
