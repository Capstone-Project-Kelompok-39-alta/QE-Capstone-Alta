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
}
