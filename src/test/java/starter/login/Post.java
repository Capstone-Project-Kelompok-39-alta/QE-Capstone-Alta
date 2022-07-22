package starter.login;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class Post {
    protected static String url = "https://invoinesia.xyz/admin/";

    @Step("Admin set POST api endpoint for login")
    public String setPostApiEndpointsForLogin(){
        return url + "login";
    }

    @Step("Admin send POST HTTP request for login")
    public void sendPostHttpRequestForLogin(){

        JSONObject requestBody = new JSONObject();
        requestBody.put("id_pegawai",23456789);
        requestBody.put("password","admintesting");


        SerenityRest.given().header("Content-Type", "application/json")
                .body(requestBody.toJSONString()).post(setPostApiEndpointsForLogin());

    }

    @Step("Admin receive valid HTTP response code 200 for login")
    public void receiveHttpResponseCode200(){
        restAssuredThat(response -> response.statusCode(200));

    }

    @Step("Admin receive token and message")
    public void receiveTokenAndMessage() {
        Response response = SerenityRest.lastResponse();
        String message = response.getBody().jsonPath().get("message");
        Assert.assertEquals(message, "success login admin");
    }

    //INVALID PASSWORD
    @Step("Admin send POST HTTP request for invalid password")
    public void sendInvalidPassword() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("id_pegawai",23456789);
        requestBody.put("password","admintesting123");


        SerenityRest.given().header("Content-Type", "application/json")
                .body(requestBody.toJSONString()).post(setPostApiEndpointsForLogin());
    }
    @Step("Admin receive invalid HTTP response code 401 for login")
    public void receive401forInvalidPassword(){
        restAssuredThat(response -> response.statusCode(401));
    }

    @Step("Admin receive message")
    public void receiveMessageForInvalidPassword(){
        Response response = SerenityRest.lastResponse();
        String message = response.getBody().jsonPath().get("message");
        Assert.assertEquals(message, "your id_pegawai and password wrong");
    }

    @Step("Admin send POST HTTP request for invalid idpegawai")
    public void sendPostForInvalidIdpegawai(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("id_pegawai",23456);
        requestBody.put("password","admintesting");


        SerenityRest.given().header("Content-Type", "application/json")
                .body(requestBody.toJSONString()).post(setPostApiEndpointsForLogin());
    }

    @Step("Admin send POST HTTP request for null idpegawai and password")
    public void sendPostNulldata(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("id_pegawai","");
        requestBody.put("password","");


        SerenityRest.given().header("Content-Type", "application/json")
                .body(requestBody.toJSONString()).post(setPostApiEndpointsForLogin());

    }
    @Step("Admin receive invalid HTTP response code 400")
    public void receiveStatusCode400(){
        restAssuredThat(response -> response.statusCode(400));
    }

    @Step("Admin receive message bad request")
    public void receiveMessageBadRequest(){
        Response response = SerenityRest.lastResponse();
        String status = response.getBody().jsonPath().get("status");
        Assert.assertEquals(status, "bad request");
    }

    @Step("Admin send POST HTTP request for login with unregistered data")
    public void sendRequestForLoginWithUnregisteredData(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("id_pegawai",366637);
        requestBody.put("password","cobapasw");


        SerenityRest.given().header("Content-Type", "application/json")
                .body(requestBody.toJSONString()).post(setPostApiEndpointsForLogin());
    }

}
