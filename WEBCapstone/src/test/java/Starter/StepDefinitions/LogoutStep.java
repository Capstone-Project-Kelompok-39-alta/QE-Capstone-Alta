package Starter.StepDefinitions;

import Starter.Pages.DashboardPage;
import Starter.Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class LogoutStep {

    @Steps
    DashboardPage dashboardPage;

    @Steps
    LoginPage loginPage;

    @Given("I am on the login pages")
    public void iAmOnTheLoginsPages() {
        loginPage.openUrl("https://profound-chaja-c7a5cb.netlify.app/");
        loginPage.validateOnLoginPage();
    }
    @When("I inputs {string} nip")
    public void iInputsNip(String nip) {
        loginPage.inputNip(nip);
    }

    @And("I inputs {string} password")
    public void iInputsPassword(String password) {

        loginPage.inputPassword(password);
    }

    @And("clicks login button")
    public void clicksLoginButton() {
        loginPage.clickLoginButton();
    }
    @And("I get to dashboard page")
    public void iGetToDashboardPage(){
        dashboardPage.headerTextEqual();
        loginPage.openUrl("https://profound-chaja-c7a5cb.netlify.app/dashboard");
    }

    @And("click profile button")
    public void iClickProfileButton() {dashboardPage.clickProfileButton();}

    @And("click logout button")
    public void iClickLogoutButton() {dashboardPage.clickLogoutButton();}

    @Then("I validate back to login page")
    public void iValidateBackToLoginPage(){
        loginPage.validateOnLoginPage();}
}
