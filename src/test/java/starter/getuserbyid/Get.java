package starter.getuserbyid;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class Get {
    protected static String url = "https://invoinesia.xyz/admin/";
    protected static Integer id_pegawai = 23456789;
    protected static String password="admintesting";
    protected static String token = "";
    protected static Integer id = 23456789;

//   public String adminSuccessCreateNewUser(){
//////        Random rnd = new Random();
//////        id_pegawai = rnd.fgd;
////        SerenityRest.given().header("Content-Type", "application/json").body(setReqBodyRegisterUser().toJSONString()).post(url+"register");
////        Response response = SerenityRest.lastResponse();
////        return response.getBody().jsonPath().get("userID");
//    }


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

    @Step("Admin success auth using new user")
    public void adminSuccesAuthNewUser(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("id_pegawai", id_pegawai);
        requestBody.put("password", password);
        SerenityRest.given().header("Content-Type", "application/json")
                .body(requestBody.toJSONString()).post(adminSetEndpointLogin());
        Response resp = SerenityRest.lastResponse();
        token = resp.getBody().jsonPath().get("data");
    }

    @Step("Admin set GET api endpoint for get user")
    public String setGetApiForGetUser(){
        return url + "user/" + id ;
    }

    @Step("Admin send GET HTTP request for get user")
    public void sendGetHttpForGetUser(){
        //SerenityRest.given().get(setGetApiForGetUser());
        SerenityRest.given().header("Content-Type", "application/json").header("Authorization", "Bearer "+token).get(setGetApiForGetUser());
    }

    @Step("Admin receive valid HTTP response code 200 for get user")
    public void receiveValidDataResponseCode200(){
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("Admin receive detail data for user")
    public void receiveDetailDataForUser(){
        Response response = SerenityRest.lastResponse();
        String message = response.getBody().jsonPath().get("message");
        Assert.assertEquals(message, "success get user admin by id_pegawai");
    }


//    public void getReqBodyGetUser() {
//        JSONObject requestBody = new JSONObject();
//        requestBody.put("id_pegawai", id_pegawai);
//        requestBody.put("password", password);
//        SerenityRest.given().header("Content-Type", "application/json")
//                .body(requestBody.toJSONString()).post(adminSetEndpoint());
//        Response resp = SerenityRest.lastResponse();
//        token = resp.getBody().jsonPath().get("token");
//        //return requestBody;
//    }





}
