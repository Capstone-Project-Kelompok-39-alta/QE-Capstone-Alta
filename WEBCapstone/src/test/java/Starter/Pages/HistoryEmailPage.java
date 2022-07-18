package Starter.Pages;

import net.serenitybdd.screenplay.actions.OpenUrl;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class HistoryEmailPage extends PageObject {

    private By DeleteButton() {
        return By.xpath("//*[@class = 'btn btn-danger ms-5']");
    }


    private By homeHeader() {
        {
            return By.xpath("//*[@id='app']/div/div/div[2]");
        }
    }

    @Step
    public boolean headerAppears() {
        return $(homeHeader()).isDisplayed();
    }

    @Step
    public boolean headerTextEqual() {
        return $(homeHeader()).getText().equals("frontend-capstone-alta-vue");
    }


    @Step
    public static OpenUrl url(String targetUrl) {
        return new OpenUrl("https://profound-chaja-c7a5cb.netlify.app/history");
    }

    @Step
    public void clickDeleteButton() {

        $(DeleteButton()).click();
    }
}

