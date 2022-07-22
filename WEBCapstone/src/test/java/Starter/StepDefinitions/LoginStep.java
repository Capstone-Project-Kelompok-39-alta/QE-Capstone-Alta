package Starter.StepDefinitions;

import Starter.Pages.DashboardPage;
import Starter.Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class LoginStep {

    @Steps
    LoginPage loginPage;

    @Steps
    DashboardPage dashboardPage;


    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        loginPage.openUrl("https://profound-chaja-c7a5cb.netlify.app/");
        loginPage.validateOnLoginPage();
    }

    @When("I input {string} nip")
    public void iInputNip(String nip) {
        loginPage.inputNip(nip);
    }

    @And("I input {string} password")
    public void iInputPassword(String password) {

        loginPage.inputPassword(password);
    }

    @And("click login button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }
        @Then("I get the {string} result")
        public void iGetThe(String result) {
            if (result.equals("dashboard page")) {
                dashboardPage.headerAppears();
                dashboardPage.headerTextEqual();
                loginPage.openUrl("https://profound-chaja-c7a5cb.netlify.app/dashboard");
            } else if (result.equals("login page")) {
                loginPage.headerAppears();
                loginPage.headerTextEqual();
            }
        }
}
