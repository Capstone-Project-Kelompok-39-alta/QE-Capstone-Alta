package Starter.StepDefinitions;

import Starter.Pages.DashboardPage;
import Starter.Pages.LoginPage;
import Starter.Pages.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
<<<<<<< HEAD
=======
import net.thucydides.core.annotations.Step;
>>>>>>> 66261f626544a4923fd30e5fafcd10e6130251fe
import net.thucydides.core.annotations.Steps;

public class RegisterStep {
    @Steps
    RegisterPage registerPage;

    @Steps
    LoginPage loginPage;

    @Steps
    DashboardPage dashboardPage;

    @Given("I am on the register page")
    public void iAmOnTheRegisterPage() {
        registerPage.openUrl("https://profound-chaja-c7a5cb.netlify.app/register");
        registerPage.validateOnRegisterPage();
    }
    @When("I input {string} namalengkap")
    public void iInputnamalengkap(String namalengkap) {
        registerPage.inputnamalengkap(namalengkap);
    }

    @And("I input {string} emails")
    public void iInputEmails(String emails) {
        registerPage.inputemails(emails);
    }

    @When("I input {string} nips")
    public void iInputNips(String nips) {
        registerPage.inputnips(nips);
    }

    @And("I input {string} passwords")
    public void iInputPassword(String passwords) {
        registerPage.inputpasswords(passwords);
    }

    @And("click register button")
    public void clickRegisterButton() {
        registerPage.clickRegisterButton();
    }
    @Then("I get the {string} results")
    public void iGetThe(String result) {
        if (result.equals("login page")){
<<<<<<< HEAD
            registerPage.headerAppears();
            registerPage.headerTextEqual();
            loginPage.openUrl("https://profound-chaja-c7a5cb.netlify.app/");
=======
            loginPage.openUrl("https://profound-chaja-c7a5cb.netlify.app/");
        }else {
            registerPage.headerAppears();
            registerPage.headerTextEqual();
>>>>>>> 66261f626544a4923fd30e5fafcd10e6130251fe
        }
    }
}
