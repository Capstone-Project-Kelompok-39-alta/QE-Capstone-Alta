package Starter.Pages;


import net.serenitybdd.screenplay.actions.OpenUrl;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;


public class DashboardPage extends PageObject  {




    private By homeHeader(){
        { return By.xpath("//*[@class = 'text-center text-login']");}
    }

    private By ProfileButton() { return By.xpath("//*[@class = 'img-fluid mt-5 me-5']");}

    private By LogoutButton(){
        return By.xpath("//*[@class = 'btn btn-secondary mx-auto text-dark fw-bold text-start']");}

    private By InvoicePage(){
         return By.xpath("//*[@id='app']/div/div/div[1]/div/ul/li[2]/a");}

    private By TransactionPage(){
        return By.xpath("//*[@id='app']/div/div/div[1]/div/ul/li[3]/a");}

    private By HistoryPage(){
        return By.xpath("//*[@id='app']/div/div/div[1]/div/ul/li[4]/a");}


    private By UploadButton(){
        return By.xpath("//*[@class = 'ms-5 btn btn-primary btn-lg mt-2']");
    }
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
        return new OpenUrl("https://profound-chaja-c7a5cb.netlify.app/dashboard");
    }
    @Step
    public void clickProfileButton(){

        $(ProfileButton()).click();
    }

    @Step
    public void clickInvoicePage(){

        $(InvoicePage()).click();
    }

    @Step
    public void clickHistoryPage(){

        $(HistoryPage()).click();
    }

    @Step
    public void clickTransactionPage(){

        $(TransactionPage()).click();
    }
    @Step
    public void clickUploadButton(){
        $(UploadButton()).click();

    }

    @Step
    public void clickLogoutButton(){

        $(LogoutButton()).click();
    }
}


