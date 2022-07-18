//package Starter.StepDefinitions;
//
//import Starter.Pages.DashboardPage;
//import Starter.Pages.LoginPage;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import net.serenitybdd.screenplay.actions.OpenUrl;
//import net.thucydides.core.annotations.Steps;
//
//public class InvoiceStep {
//
//    @Steps
//    LoginPage loginPage;
//
//    @Steps
//    DashboardPage dashboardPage;
//
//    @Given("I am on the login pagex")
//    public void iAmOnTheLoginPagex() {
//        loginPage.openUrl("https://profound-chaja-c7a5cb.netlify.app/");
//        loginPage.validateOnLoginPage();
//    }
//
//    @When("I input {string} nipx")
//    public void iInputNipx(String nipx) {
//        loginPage.inputNip(nipx);
//    }
//
//    @And("I input {string} passwordx")
//    public void iInputPassword(String passwordx) {
//
//        loginPage.inputPassword(passwordx);
//    }
//
//    @And("click logins button")
//    public void clickLoginsButton() {
//        loginPage.clickLoginButton();
//    }
//
//    @And("I get to dashboard pages")
//    public void iGetToDashboardPages() {
//        dashboardPage.headerTextEqual();
//        loginPage.openUrl("https://profound-chaja-c7a5cb.netlify.app/dashboard");
//    }
//
//    @And("click invoice button")
//    public void clickUploadButton() {
//        dashboardPage.clickUploadButton();
//
//    }
//    @Then("i validate invoice already upload")
//    public OpenUrl iValidateInvoiceAlreadyUpload() {
//        return new OpenUrl("https://profound-chaja-c7a5cb.netlify.app/invoice");
//    }
//}
