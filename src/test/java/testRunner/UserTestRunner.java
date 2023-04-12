package testRunner;

import controller.User;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.configuration.ConfigurationException;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.Setup;

import java.io.IOException;

@Getter
@Setter

public class UserTestRunner extends Setup {
    User user;

    @Test(priority = 1, description = "User can not login with invalid credentials")
    public void userLoginInvalid() throws IOException {
        user = new User();
        user.invalidUserLoginAPI();
        Assert.assertTrue(user.getMessage().contains("Password incorrect"));
    }
    @Test(priority = 2, description = "User can login with valid credentials")
    public void userLoginValid() throws ConfigurationException, IOException {
        user = new User();
        user.validUserLoginAPI();
        Assert.assertTrue(user.getMessage().contains("Login successfully"));
    }
    @Test(priority = 3, description = "A customer id can be created with unique phone number")
    public void createValidCustomer() throws ConfigurationException, IOException {
        user=new User();
        user.createCustomer();
        Assert.assertTrue(user.getMessage().contains("User created"));
    }
    @Test(priority = 4, description = "A customer id can not be created with same phone number")
    public void createDuplicateCustomer() throws IOException {
        user=new User();
        user.createSameCustomer();
        Assert.assertTrue(user.getMessage().contains("User already exists"));
    }
    @Test(priority = 5, description = "An agent id can be created with unique phone number")
    public void createAgent() throws ConfigurationException, IOException {
        user=new User();
        user.createValidAgent();
        Assert.assertTrue(user.getMessage().contains("User created"));
    }
    @Test(priority = 6, description = "An agent id can not be created with same phone number")
    public void createDuplicateAgent() throws IOException {
        user=new User();
        user.createSameAgent();
        Assert.assertTrue(user.getMessage().contains("User already exists"));
    }
    @Test(priority = 7, description = "Customer can not be found with wrong phone number")
    public void searchInvalidCustomer() throws IOException {
        user=new User();
        user.searchInvalidPhonenumber();
        Assert.assertTrue(user.getMessage().contains("User not found"));
    }
    @Test(priority = 8, description = "Customer can be find with correct phone number")
    public void searchValidCustomer() throws IOException {
        user=new User();
        user.searchValidPhonenumber();
        Assert.assertTrue(user.getMessage().contains("User found"));
    }
    @Test(priority = 9)
    public void createValidCustomer2() throws ConfigurationException, IOException {
        user=new User();
        user.createCustomer2();
        Assert.assertTrue(user.getMessage().contains("User created"));
    }
}
