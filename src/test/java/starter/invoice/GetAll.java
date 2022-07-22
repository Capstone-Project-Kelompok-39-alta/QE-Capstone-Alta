package starter.invoice;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetAll {
    protected static String url = "https://invoinesia.xyz/admin/";
    protected static Integer id_pegawai = 23456789;
    protected static String password="admintesting";
    protected static String token = "";
    protected static Integer id = 23456789;



    public JSONObject setReqBodyRegisterUser(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("name","sautkristianwiratamamanurung");
        requestBody.put("id_pegawai",23456789);
        requestBody.put("email","admin@gmail.com");
        requestBody.put("password","admintesting");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(url+"register");
        return requestBody;
    }

    public String adminSetEndpointLogin(){
        return url + "login";
    }
    @Step("Admin success auth using new user for Get All Invoice")
    public void adminSuccesAuthNewUserForGetAllInvoice(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("id_pegawai", id_pegawai);
        requestBody.put("password", password);
        SerenityRest.given().header("Content-Type", "application/json")
                .body(requestBody.toJSONString()).post(adminSetEndpointLogin());
        Response resp = SerenityRest.lastResponse();
        token = resp.getBody().jsonPath().get("data");
    }

    @Step("Admin set GET api endpoint for Get All Invoice")
    public String adminSetGetApiForGetAll(){
        return url + "invoice";
    }

    @Step("Admin send GET HTTP request for Get All Invoice")
    public void adminSendHttpRequestForGetAllInvoice(){
        SerenityRest.given().header("Content-Type", "application/json").header("Authorization", "Bearer "+token).get(adminSetGetApiForGetAll());
    }

    @Step("Admin receive valid HTTP response code 200 for Get All Invoice")
    public void receiveValidResponseCode200(){
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("Admin receive detail All Invoice")
    public void receiveDetailAllInvoice(){
        Response response = SerenityRest.lastResponse();
        String message = response.getBody().jsonPath().get("message");
        Assert.assertEquals(message, "success to get all invoice");
    }

    @Step("Admin receive invalid HTTP response code 400 for Invoice")
    public void receiveStatusCode400(){
        restAssuredThat(response -> response.statusCode(400));
    }

    @Step("Admin receive message invalid or expired jwt")
    public void receiveMessageExpiredJwt(){
        Response response = SerenityRest.lastResponse();
        String message = response.getBody().jsonPath().get("message");
        Assert.assertEquals(message, "missing or malformed jwt");
    }

    @Step("Admin send GET HTTP request for Get All Invoice without login")
    public void sendGetAllInvoiceWithoutLogin(){
        SerenityRest.given().header("Content-Type", "application/json").get(adminSetGetApiForGetAll());
    }


}
