package Starter.Pages;

import net.serenitybdd.screenplay.actions.OpenUrl;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class DashboardPage extends PageObject {

    private By homeHeader(){
        { return By.xpath("//*[@id='app']/div/div/div[2]/div[1]/div");}
    }
    private By ProfileButton() { return By.xpath("//*[@class = 'img-fluid mt-5 me-5']");}

    private By LogoutButton(){
        return By.xpath("//*[@class = 'btn btn-secondary mx-auto text-dark fw-bold text-start']");}
    @Step
    public boolean headerAppears(){
        return $(homeHeader()).isDisplayed();
    }
    @Step
    public boolean headerTextEqual(){
        return $(homeHeader()).getText().equals("frontend-capstone-alta-vue");
    }
    @Step
    public static OpenUrl url (String targetUrl){
        return new OpenUrl("https://profound-chaja-c7a5cb.netlify.app/");
    }
    @Step
    public void clickProfileButton(){
        $(ProfileButton()).click();
    }
    @Step
    public void clickLogoutButton(){

        $(LogoutButton()).click();
    }
}
