package controller;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;
import model.UserModel;
import org.apache.commons.configuration.ConfigurationException;
import setup.Setup;
import utils.Utility;
import java.io.IOException;

import static io.restassured.RestAssured.given;
@Getter
@Setter

public class User extends Setup {
    public User() throws IOException {
        readConfigPeropertiesFile();
    }
    private String message;
    public void invalidUserLoginAPI() {
        RestAssured.baseURI = prop.getProperty("base_url");
        UserModel loginModel = new UserModel("salman@roadtocareer.net","12345");
        Response response = given()
                .contentType("application/json")
                .body(loginModel)
                .when()
                .post("/user/login");

        JsonPath jsonResponse = response.jsonPath();
        String message = jsonResponse.get("message");
        setMessage(message);
    }
    public void validUserLoginAPI() throws ConfigurationException {
        RestAssured.baseURI = prop.getProperty("base_url");
        UserModel loginModel = new UserModel("salman@roadtocareer.net","1234");
        Response response = given()
                .contentType("application/json")
                .body(loginModel)
                .when()
                .post("/user/login");

        JsonPath jsonResponse = response.jsonPath();
        String token = jsonResponse.get("token");
        String message = jsonResponse.get("message");

        Utility.setEnvVariable("token", token);
        System.out.println(token);
        System.out.println(message);
        setMessage(message);
    }

    public void createCustomer() throws ConfigurationException {
        Utility utility = new Utility();
        utility.randomUserInfo();
        UserModel registerModel = new UserModel(utility.getName(), utility.getPassword(), utility.getEmail(), utility.getPhone_number(), utility.getNid(), "Customer");
        RestAssured.baseURI = prop.getProperty("base_url");
        Response response = given()
                .contentType("application/json")
                .header("Authorization", prop.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                .body(registerModel)
                .post("/user/create");

        JsonPath jsonResponse = response.jsonPath();
        System.out.println(jsonResponse.get().toString());
        Utility.setEnvVariable("customer_id", jsonResponse.get("user.id").toString());
        Utility.setEnvVariable("customer_name", jsonResponse.get("user.name"));
        Utility.setEnvVariable("customer_email", jsonResponse.get("user.email"));
        Utility.setEnvVariable("customer_phone_number", jsonResponse.get("user.phone_number"));
        System.out.println(message);
        String message = jsonResponse.get("message");
        setMessage(message);
    }
    public void createSameCustomer() {
        Utility utility = new Utility();
        utility.randomUserInfo();
        String phoneNumber = prop.getProperty("customer_phone_number");

        UserModel registerModel = new UserModel(utility.getName(), utility.getPassword(), utility.getEmail(), phoneNumber, utility.getNid(), "Customer");
        RestAssured.baseURI = prop.getProperty("base_url");
        Response response = given()
                .contentType("application/json")
                .header("Authorization", prop.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                .body(registerModel)
                .post("/user/create");

        JsonPath jsonResponse = response.jsonPath();
        System.out.println(jsonResponse.get().toString());
        System.out.println(message);
        String message = jsonResponse.get("message");
        setMessage(message);
    }

    public void createValidAgent() throws ConfigurationException {
        Utility utility = new Utility();
        utility.randomUserInfo();
        UserModel registerModel = new UserModel(utility.getName(), utility.getPassword(), utility.getEmail(), utility.getPhone_number(), utility.getNid(), "Agent");
        RestAssured.baseURI = prop.getProperty("base_url");
        Response response = given()
                .contentType("application/json")
                .header("Authorization", prop.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                .body(registerModel)
                .post("/user/create");

        JsonPath jsonResponse = response.jsonPath();
        System.out.println(jsonResponse.get().toString());
        Utility.setEnvVariable("agent_id", jsonResponse.get("user.id").toString());
        Utility.setEnvVariable("agent_name", jsonResponse.get("user.name"));
        Utility.setEnvVariable("agent_email", jsonResponse.get("user.email"));
        Utility.setEnvVariable("agent_phone_number", jsonResponse.get("user.phone_number"));
        System.out.println(message);
        String message = jsonResponse.get("message");
        setMessage(message);
    }
    public void createSameAgent() {
        Utility utility = new Utility();
        utility.randomUserInfo();
        String phoneNumber = prop.getProperty("agent_phone_number");

        UserModel registerModel = new UserModel(utility.getName(), utility.getPassword(), utility.getEmail(), phoneNumber, utility.getNid(), "Agent");
        RestAssured.baseURI = prop.getProperty("base_url");
        Response response = given()
                .contentType("application/json")
                .header("Authorization", prop.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                .body(registerModel)
                .post("/user/create");

        JsonPath jsonResponse = response.jsonPath();
        System.out.println(jsonResponse.get().toString());
        System.out.println(message);
        String message = jsonResponse.get("message");
        setMessage(message);
    }

    public void searchInvalidPhonenumber(){
        RestAssured.baseURI = prop.getProperty("base_url");
        String phoneNumber = "01711111111";
        Response response = given()
                .contentType("application/json")
                .header("Authorization", prop.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                .when()
                .get("/user/search/phonenumber/" + phoneNumber);
        JsonPath jsonResponse = response.jsonPath();
        System.out.println(jsonResponse.get().toString());
        String message = jsonResponse.get("message");
        setMessage(message);
    }

    public void searchValidPhonenumber(){
        RestAssured.baseURI = prop.getProperty("base_url");
        String phoneNumber = prop.getProperty("customer_phone_number");

        Response response = given()
                .contentType("application/json")
                .header("Authorization", prop.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                .when()
                .get("/user/search/phonenumber/" + phoneNumber);
        JsonPath jsonResponse = response.jsonPath();
        System.out.println(jsonResponse.get().toString());
        String message = jsonResponse.get("message");
        setMessage(message);
    }
    public void createCustomer2() throws ConfigurationException {
        Utility utility = new Utility();
        utility.randomUserInfo();
        UserModel registerModel = new UserModel(utility.getName(), utility.getPassword(), utility.getEmail(), utility.getPhone_number(), utility.getNid(), "Customer");
        RestAssured.baseURI = prop.getProperty("base_url");
        Response response = given()
                .contentType("application/json")
                .header("Authorization", prop.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                .body(registerModel)
                .post("/user/create");

        JsonPath jsonResponse = response.jsonPath();
        System.out.println(jsonResponse.get().toString());
        Utility.setEnvVariable("customer2_id", jsonResponse.get("user.id").toString());
        Utility.setEnvVariable("customer2_name", jsonResponse.get("user.name"));
        Utility.setEnvVariable("customer2_email", jsonResponse.get("user.email"));
        Utility.setEnvVariable("customer2_phone_number", jsonResponse.get("user.phone_number"));
        System.out.println(message);
        String message = jsonResponse.get("message");
        setMessage(message);
    }
}
