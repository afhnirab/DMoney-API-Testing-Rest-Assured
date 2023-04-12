package controller;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;
import model.TransactionModel;
import org.apache.commons.configuration.ConfigurationException;
import setup.Setup;
import io.restassured.path.json.JsonPath;
import utils.Utility;

import java.io.IOException;

import static io.restassured.RestAssured.given;

@Getter
@Setter
public class Transaction extends Setup {
    private  String message;

    public Transaction() throws IOException {
        readConfigPeropertiesFile();
    }

    public void depositeInsufficientAgent() {
        RestAssured.baseURI = prop.getProperty("base_url");
        String agentPhoneNumber = prop.getProperty("agent_phone_number");
        TransactionModel transactionModel = new TransactionModel("SYSTEM", agentPhoneNumber, 9);

        Response response = given()
                .contentType("application/json")
                .header("Authorization", prop.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                .body(transactionModel)
                .when()
                .post("/transaction/deposit");

        JsonPath jsonResponse = response.jsonPath();
        System.out.println(jsonResponse.get().toString());
        String message = jsonResponse.get("message");
        setMessage(message);
    }
    public void depositeSufficientAgent() throws ConfigurationException {
        RestAssured.baseURI = prop.getProperty("base_url");
        String agentPhoneNumber = prop.getProperty("agent_phone_number");
        TransactionModel transactionModel = new TransactionModel("SYSTEM", agentPhoneNumber, 5000);

        Response response = given()
                .contentType("application/json")
                .header("Authorization", prop.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                .body(transactionModel)
                .when()
                .post("/transaction/deposit");

        JsonPath jsonResponse = response.jsonPath();
        System.out.println(jsonResponse.get().toString());
        Utility.setEnvVariable("Agent_TrnxId", jsonResponse.get("trnxId").toString());
        String message = jsonResponse.get("message");
        setMessage(message);
    }
    public void depositeInsufficienCustomer() {
        RestAssured.baseURI = prop.getProperty("base_url");
        String agentPhoneNumber = prop.getProperty("agent_phone_number");
        String customerPhoneNumber = prop.getProperty("customer_phone_number");
        TransactionModel transactionModel = new TransactionModel(agentPhoneNumber, customerPhoneNumber, 9);

        Response response = given()
                .contentType("application/json")
                .header("Authorization", prop.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                .body(transactionModel)
                .when()
                .post("/transaction/deposit");

        JsonPath jsonResponse = response.jsonPath();
        System.out.println(jsonResponse.get().toString());
        String message = jsonResponse.get("message");
        setMessage(message);
    }
    public void depositeSufficientCustomer() throws ConfigurationException {
        RestAssured.baseURI = prop.getProperty("base_url");
        String agentPhoneNumber = prop.getProperty("agent_phone_number");
        String customerPhoneNumber = prop.getProperty("customer_phone_number");
        TransactionModel transactionModel = new TransactionModel(agentPhoneNumber, customerPhoneNumber, 2000);

        Response response = given()
                .contentType("application/json")
                .header("Authorization", prop.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                .body(transactionModel)
                .when()
                .post("/transaction/deposit");

        JsonPath jsonResponse = response.jsonPath();
        System.out.println(jsonResponse.get().toString());
        Utility.setEnvVariable("Customer_TrnxId", jsonResponse.get("trnxId").toString());
        String message = jsonResponse.get("message");
        setMessage(message);
    }
    public void checkInvalidCustomerBalance(){
        RestAssured.baseURI = prop.getProperty("base_url");
        String phoneNumber = "0171111111";
        Response response =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .when()
                        .get("/transaction/balance/" + phoneNumber);
        JsonPath jsonResponse = response.jsonPath();
        System.out.println(jsonResponse.get().toString());
        String message = jsonResponse.get("message");
        setMessage(message);
    }
    public void checkValidCustomerBalance(){
        RestAssured.baseURI = prop.getProperty("base_url");
        String phoneNumber = prop.getProperty("customer_phone_number");
        Response response =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .when()
                        .get("/transaction/balance/" + phoneNumber);
        JsonPath jsonResponse = response.jsonPath();
        System.out.println(jsonResponse.get().toString());
        String message = jsonResponse.get("message");
        setMessage(message);
    }
    public void invalidTranxId(){
        RestAssured.baseURI = prop.getProperty("base_url");
        String trnxId = "TXNA42862";
        Response response =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .when()
                        .get("/transaction/search/" + trnxId);
        JsonPath jsonResponse = response.jsonPath();
        System.out.println(jsonResponse.get().toString());
        String message = jsonResponse.get("message");
        setMessage(message);
    }
    public void validTranxId(){
        RestAssured.baseURI = prop.getProperty("base_url");
        String trnxId = prop.getProperty("Customer_TrnxId");
        Response response =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .when()
                        .get("/transaction/search/" + trnxId);
        JsonPath jsonResponse = response.jsonPath();
        System.out.println(jsonResponse.get().toString());
        String message = jsonResponse.get("message");
        setMessage(message);
    }
    public void withdrawInvalid(){
        RestAssured.baseURI = prop.getProperty("base_url");
        String customerPhoneNumber = prop.getProperty("customer_phone_number");
        String agentPhoneNumber = prop.getProperty("agent_phone_number");
        TransactionModel transactionModel = new TransactionModel(customerPhoneNumber, agentPhoneNumber, 9);
        Response response =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .body(transactionModel)
                        .when()
                        .post("/transaction/withdraw");
        JsonPath jsonResponse = response.jsonPath();
        System.out.println(jsonResponse.get().toString());
        String message = jsonResponse.get("message");
        setMessage(message);
    }

    public void withdrawValid(){
        RestAssured.baseURI = prop.getProperty("base_url");
        String customerPhoneNumber = prop.getProperty("customer_phone_number");
        String agentPhoneNumber = prop.getProperty("agent_phone_number");
        TransactionModel transactionModel = new TransactionModel(customerPhoneNumber, agentPhoneNumber, 1000);
        Response response =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .body(transactionModel)
                        .when()
                        .post("/transaction/withdraw");
        JsonPath jsonResponse = response.jsonPath();
        System.out.println(jsonResponse.get().toString());
        String message = jsonResponse.get("message");
        setMessage(message);
    }

    public void sendMoneyInvalid(){
        RestAssured.baseURI = prop.getProperty("base_url");
        String customerPhoneNumber = prop.getProperty("customer_phone_number");
        String customer2PhoneNumber = prop.getProperty("customer2_phone_number");
        TransactionModel transactionModel = new TransactionModel(customerPhoneNumber, customer2PhoneNumber, 9);
        Response response =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .body(transactionModel)
                        .when()
                        .post("/transaction/sendmoney");
        JsonPath jsonResponse = response.jsonPath();
        System.out.println(jsonResponse.get().toString());
        String message = jsonResponse.get("message");
        setMessage(message);
    }

    public void sendMoneyValid(){
        RestAssured.baseURI = prop.getProperty("base_url");
        String customerPhoneNumber = prop.getProperty("customer_phone_number");
        String customer2PhoneNumber = prop.getProperty("customer2_phone_number");
        TransactionModel transactionModel = new TransactionModel(customerPhoneNumber, customer2PhoneNumber, 500);
        Response response =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .body(transactionModel)
                        .when()
                        .post("/transaction/sendmoney");
        JsonPath jsonResponse = response.jsonPath();
        System.out.println(jsonResponse.get().toString());
        String message = jsonResponse.get("message");
        setMessage(message);
    }

    public void checkStatementInvalid() {
        RestAssured.baseURI = prop.getProperty("base_url");
        String phoneNumber = "01711111111";
        Response response =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .when()
                        .get("/transaction/statement/" + phoneNumber);

        JsonPath jsonResponse = response.jsonPath();
        System.out.println(jsonResponse.get().toString());
        String message = jsonResponse.get("message");
        setMessage(message);

    }
    public void checkStatementValid() {
        RestAssured.baseURI = prop.getProperty("base_url");
        String phoneNumber = prop.getProperty("customer2_phone_number");
        Response response =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .when()
                        .get("/transaction/statement/" + phoneNumber);

        JsonPath jsonResponse = response.jsonPath();
        System.out.println(jsonResponse.get().toString());
        String message = jsonResponse.get("message");
        setMessage(message);

    }

}
