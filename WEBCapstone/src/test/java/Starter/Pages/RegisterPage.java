package Starter.Pages;

import Utils.General;
import net.serenitybdd.screenplay.actions.OpenUrl;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import java.io.FileWriter;
import java.io.IOException;

public class RegisterPage extends PageObject {
    General general = new General();
    String namalengkap;
    String nips;
    String emails;
    String passwords;

<<<<<<< HEAD
    private By Message(){
        { return By.xpath("//*[@class = 'text-center text-regist text-regist-success']");}
=======
    private By ErrorMessage(){
        { return By.xpath("//*[@class = 'mt-2 fs-5']");}
>>>>>>> 66261f626544a4923fd30e5fafcd10e6130251fe
    }

    private By namalengkapField() {
        return By.xpath("//*[@id='inputNama']");
    }

    private By nipsField() {
        return By.xpath("//*[@id='inputNip']");
    }

    private By emailsField() {
        return By.xpath("//*[@id='inputEmail']");
    }

    private By passwordField() {
        return By.xpath("//*[@id='inputPassword']");
    }

    private By registerButton() {
        return By.xpath("//*[@id='app']/div/div/div[2]/div/form/div[5]/button[1]");
    }

    @Step
    public static OpenUrl url(String targetUrl) {
        return new OpenUrl("https://profound-chaja-c7a5cb.netlify.app/register");
    }

    @Step
    public boolean validateOnRegisterPage() {
        return $(registerButton()).isDisplayed();
    }

    @Step
    public boolean headerAppears(){
<<<<<<< HEAD
        return $(Message()).isDisplayed();
    }
    @Step
    public boolean headerTextEqual(){
        return $(Message()).getText().equals("frontend-capstone-alta-vue");
=======
        return $(ErrorMessage()).isDisplayed();
    }
    @Step
    public boolean headerTextEqual(){
        return $(ErrorMessage()).getText().equals("frontend-capstone-alta-vue");
>>>>>>> 66261f626544a4923fd30e5fafcd10e6130251fe
    }

    @Step
    public void inputnamalengkap(String namalengkap) {
        if (namalengkap.equals("same")) {
            this.namalengkap = "imamrayhanekadinata";
        } else {
            this.namalengkap = general.randomUsername();
            try (FileWriter file = new FileWriter("src//test//resources//filejson//namalengkap.json")) {
                file.write(this.namalengkap);
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        $(namalengkapField()).type(namalengkap);
    }

    public void inputnips(String nips) {
        if (nips.equals("same")) {
            this.nips = "1233212244";
        } else {
            this.nips = (general.randomNips());
            try (FileWriter file = new FileWriter("src//test//resources//filejson//nips.json")) {
                file.write(this.nips);
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        $(nipsField()).type(nips);
    }

    public void inputemails(String emails) {
        if (emails.equals("same")) {
            this.emails = "imamrayhane@gmail.com";
        } else {
            this.emails = general.randomEmails();
            try (FileWriter file = new FileWriter("src//test//resources//filejson//emails.json")) {
                file.write(this.emails);
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        $(emailsField()).type(emails);
    }


    @Step
    public void inputpasswords(String passwords) {
        if (passwords.equals("same")) {
            this.passwords = "rayhangantenk";
        } else {
            this.passwords = general.randomPasswords();
            try (FileWriter file = new FileWriter("src//test//resources//filejson//passwords.json")) {
                file.write(this.passwords);
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        $(passwordField()).type(passwords);
    }

    @Step
    public void clickRegisterButton() {
        $(registerButton()).click();
    }
}
