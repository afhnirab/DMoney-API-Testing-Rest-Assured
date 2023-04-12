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

    @Test(priority = 1)
    public void userLoginInvalid() throws IOException {
        user = new User();
        user.invalidUserLoginAPI();
        Assert.assertTrue(user.getMessage().contains("Password incorrect"));
    }
    @Test(priority = 2)
    public void userLoginValid() throws ConfigurationException, IOException {
        user = new User();
        user.validUserLoginAPI();
        Assert.assertTrue(user.getMessage().contains("Login successfully"));
    }
    @Test(priority = 3)
    public void createValidCustomer() throws ConfigurationException, IOException {
        user=new User();
        user.createCustomer();
        Assert.assertTrue(user.getMessage().contains("User created"));
    }
    @Test(priority = 4)
    public void createDuplicateCustomer() throws IOException {
        user=new User();
        user.createSameCustomer();
        Assert.assertTrue(user.getMessage().contains("User already exists"));
    }
    @Test(priority = 5)
    public void createAgent() throws ConfigurationException, IOException {
        user=new User();
        user.createValidAgent();
        Assert.assertTrue(user.getMessage().contains("User created"));
    }
    @Test(priority = 6)
    public void createDuplicateAgent() throws IOException {
        user=new User();
        user.createSameAgent();
        Assert.assertTrue(user.getMessage().contains("User already exists"));
    }
    @Test(priority = 7)
    public void searchInvalidCustomer() throws IOException {
        user=new User();
        user.searchInvalidPhonenumber();
        Assert.assertTrue(user.getMessage().contains("User not found"));
    }
    @Test(priority = 8)
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
