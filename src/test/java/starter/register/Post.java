package starter.register;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class Post {


        protected static String url = "https://invoinesia.xyz/admin/";

        @Step("Admin set POST api endpoint for register")
        public String setPostApiEndpoints(){
            return url + "register";
        }

        @Step("Admin send POST HTTP request for register")
        public void sendPostHttpRequest(){

            JSONObject requestBody = new JSONObject();
            requestBody.put("name","sautkristianwiratamamanurung");
            requestBody.put("id_pegawai",23456789);
            requestBody.put("email","admin@gmail.com");
            requestBody.put("password","admintesting");


            SerenityRest.given().header("Content-Type", "application/json")
                    .body(requestBody.toJSONString()).post(setPostApiEndpoints());

        }

        @Step("Admin receive valid HTTP response code 201")
        public void receiveHttpResponseCode201(){
            restAssuredThat(response -> response.statusCode(201));

        }

        @Step("Admin receive valid data for new user")
        public void receiveDataNewUser() {

            Response response = SerenityRest.lastResponse();
            int id = response.getBody().jsonPath().get("data.ID");
            String name = response.getBody().jsonPath().get("data.name");
            int id_pegawai = response.getBody().jsonPath().get("data.id_pegawai");
            String email = response.getBody().jsonPath().get("data.email");
            String password = response.getBody().jsonPath().get("data.password");
            Assert.assertEquals(id,0);
            Assert.assertEquals(name, "sautkristianwiratamamanurung");
            Assert.assertEquals(id_pegawai,23456789);
            Assert.assertEquals(email, "admin@gmail.com");
            Assert.assertEquals(password,"admintesting");


        }

        @Step("Admin receive valid HTTP response code 406")
        public void adminReceveiveCode406(){
            restAssuredThat(response -> response.statusCode(406));
        }

        @Step("Admin receive message User exists")
        public void receiveMessageUserExists(){
            Response response = SerenityRest.lastResponse();
            String message = response.getBody().jsonPath().get("message");
            Assert.assertEquals(message, "User exists");
        }

        @Step("Admin send POST HTTP request for register with null data")
        public void sendPostforRegisterWithNullData(){
            JSONObject requestBody = new JSONObject();
            requestBody.put("name","");
            requestBody.put("id_pegawai","");
            requestBody.put("email","");
            requestBody.put("password","");


            SerenityRest.given().header("Content-Type", "application/json")
                    .body(requestBody.toJSONString()).post(setPostApiEndpoints());

        }

        @Step("Admin receive invalid HTTP response code 500 for register")
        public void receiveCode500ForRegister(){
            restAssuredThat(response -> response.statusCode(500));
        }

        @Step("Admin receive message Internal Server Error for register")
    public void receiveMessageInternalServerError(){
            Response response = SerenityRest.lastResponse();
            String message = response.getBody().jsonPath().get("message");
            Assert.assertEquals(message, "Internal Server Error");
        }


}
