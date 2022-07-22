package starter.invoice;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;
import org.junit.Assert;

import java.io.File;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class Post {
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

    @Step("Admin success auth using new user for Invoice")
    public void adminSuccesAuthNewUserForInvoice(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("id_pegawai", id_pegawai);
        requestBody.put("password", password);
        SerenityRest.given().header("Content-Type", "application/json")
                .body(requestBody.toJSONString()).post(adminSetEndpointLogin());
        Response resp = SerenityRest.lastResponse();
        token = resp.getBody().jsonPath().get("data");
    }

    @Step("Admin set POST api endpoint for Invoice")
    public String adminSetPostApiForInvoice(){
        return url + "upload_csv";
    }

    @Step("Admin send POST HTTP request for Invoice")
    public void adminSendPostHttpForInvoice(){
//        JSONObject requestBody = new JSONObject();
//        requestBody.put("id_pegawai",23456789);
//        requestBody.put("password","admintesting");


//        SerenityRest.given().header("Content-Type", "application/json")
//                .body(requestBody.toJSONString()).post(adminSetPostApiForInvoice());
        SerenityRest.given()
                .header("Content-Type", "multipart/form-data")
                .header("Authorization", "Bearer "+token)
                .multiPart("csv_file",new File("src/test/resources/file/Book1.csv"))
                .post(adminSetPostApiForInvoice());


    }
    @Step("Admin receive valid HTTP response code 201 for Invoice")
    public void receiveValidCode201ForInvoice(){
        restAssuredThat(response -> response.statusCode(201));
    }
    @Step("Admin receive detail Invoice")
    public void receiveDetailInvoice(){
        Response response = SerenityRest.lastResponse();
        String message = response.getBody().jsonPath().get("message");
        Assert.assertEquals(message, "success to upload file");
    }

    @Step("Admin receive invalid HTTP response code 500 for Invoice")
    public void receiveStatusCode500ForInvoice(){
        restAssuredThat(response -> response.statusCode(500));
    }

    @Step("Admin receive message Internal Server Error")
    public void receiveMessageServerError(){
        Response response = SerenityRest.lastResponse();
        String message = response.getBody().jsonPath().get("message");
        Assert.assertEquals(message, "Internal Server Error");
    }

    @Step("Admin send POST HTTP request for Invoice with different extensions")
    public void sendHttpForDifferent(){
        SerenityRest.given()
                .header("Content-Type", "multipart/form-data")
                .header("Authorization", "Bearer "+token)
                .multiPart("csv_file",new File("src/test/resources/file/gambar.png"))
                .post(adminSetPostApiForInvoice());
    }

    @Step("Admin receive valid HTTP response code 400 for Invoice with different extensions")
    public void receiveHttp400ForDifferent(){
        restAssuredThat(response -> response.statusCode(400));
    }

    @Step("Admin receive message invalid extension file")
    public void receiveMsgInvalidExtension(){
        Response response = SerenityRest.lastResponse();
        String message = response.getBody().jsonPath().get("message");
        Assert.assertEquals(message, "invalid extension file");
    }

    @Step("Admin send GET HTTP request for Get All Invoice without send file csv")
    public void sendWithoutSendFileCsv(){
        SerenityRest.given()
                .header("Content-Type", "multipart/form-data")
                .header("Authorization", "Bearer "+token)
                .multiPart("csv_file",new File(""))
                .post(adminSetPostApiForInvoice());
    }

    @Step("Admin send POST HTTP request for Invoice without login")
    public void sendPostForInvoiceWithoutLogin(){
        SerenityRest.given().header("Content-Type", "application/json").get(adminSetPostApiForInvoice());
    }

}
