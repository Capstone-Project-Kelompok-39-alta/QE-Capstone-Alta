package Starter.Pages;

import net.serenitybdd.screenplay.actions.OpenUrl;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {

    private By ErrorMessageLogin(){
        { return By.xpath("//*[@class = 'mt-2 fs-5']");}
    }

    private By nipField() {
        return By.xpath("//*[@id='inputNip']");
    }

    private By passwordField() {
        return By.xpath("//*[@id='inputPassword']");

    }

    private By loginButton() {
        return By.xpath("//*[@class='btn btn-primary btn-lg']");
    }

    @Step
    public static OpenUrl url(String targetUrl) {
        return new OpenUrl("https://profound-chaja-c7a5cb.netlify.app/");
    }

    @Step
    public boolean validateOnLoginPage() {
        return $(loginButton()).isDisplayed();
    }

    @Step
    public void inputNip(String nip) {
        $(nipField()).type(nip);
    }

    @Step
    public void inputPassword(String password) {
        $(passwordField()).type(password);
    }

    @Step
    public void clickLoginButton() {
        $(loginButton()).click();
    }
    public boolean headerAppears(){
        return $(ErrorMessageLogin()).isDisplayed();
    }
    @Step
    public boolean headerTextEqual(){
        return $(ErrorMessageLogin()).getText().equals("frontend-capstone-alta-vue");
    }

}
