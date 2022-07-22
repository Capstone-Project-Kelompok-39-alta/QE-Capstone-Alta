package starter.invoice;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetById {
    protected static String url = "https://invoinesia.xyz/admin/";
    protected static Integer id_pegawai = 23456789;
    protected static String password="admintesting";
    protected static String token = "";
    protected static Integer id = 4;



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
    @Step("Admin success auth using new user for Get Invoice by Id")
    public void adminSuccesAuthNewUserForGetInvoiceById(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("id_pegawai", id_pegawai);
        requestBody.put("password", password);
        SerenityRest.given().header("Content-Type", "application/json")
                .body(requestBody.toJSONString()).post(adminSetEndpointLogin());
        Response resp = SerenityRest.lastResponse();
        token = resp.getBody().jsonPath().get("data");
    }

    @Step("Admin set GET api endpoint for Get Invoice by Id")
    public String adminSetGetApiForGetById(){
        return url + "invoice/" + id ;
    }

    @Step("Admin send GET HTTP request for Get Invoice by Id")
    public void adminSendHttpRequestForGetInvoiceById(){
        SerenityRest.given().header("Content-Type", "application/json").header("Authorization", "Bearer "+token).get(adminSetGetApiForGetById());
    }

    @Step("Admin receive valid HTTP response code 200 for Get Invoice by Id")
    public void receiveValidResponseCode200GetInvoiceById(){
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("Admin receive detail Invoice by Id")
    public void receiveDetailInvoiceById(){
        Response response = SerenityRest.lastResponse();
        String message = response.getBody().jsonPath().get("message");
        Assert.assertEquals(message, "success get invoice by id");
    }
}
