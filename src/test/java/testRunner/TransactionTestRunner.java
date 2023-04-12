package testRunner;

import controller.Transaction;
import org.apache.commons.configuration.ConfigurationException;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.Setup;

import java.io.IOException;

public class TransactionTestRunner extends Setup {
    Transaction transaction;
    @Test(priority = 1)
    public void doInvalidDepositeAgent() throws IOException{
        transaction = new Transaction();
        transaction.depositeInsufficientAgent();
        Assert.assertTrue(transaction.getMessage().contains("Minimum deposit amount 10 tk and maximum deposit amount 10000 tk"));
    }
    @Test(priority = 2)
    public void doValidDepositeAgent() throws IOException, ConfigurationException {
        transaction = new Transaction();
        transaction.depositeSufficientAgent();
        Assert.assertTrue(transaction.getMessage().contains("Deposit successful"));
    }
    @Test(priority = 3)
    public void doInvalidDepositeCustomer() throws IOException {
        transaction = new Transaction();
        transaction.depositeInsufficienCustomer();
        Assert.assertTrue(transaction.getMessage().contains("Minimum deposit amount 10 tk and maximum deposit amount 10000 tk"));
    }
    @Test(priority = 4)
    public void doValidDepositeCustomer() throws IOException, ConfigurationException {
        transaction = new Transaction();
        transaction.depositeSufficientCustomer();
        Assert.assertTrue(transaction.getMessage().contains("Deposit successful"));
    }
    @Test(priority = 5)
    public void checkInvalidBalance() throws IOException {
        transaction = new Transaction();
        transaction.checkInvalidCustomerBalance();
        Assert.assertTrue(transaction.getMessage().contains("User not found"));
    }
    @Test(priority = 6)
    public void checkValidBalance() throws IOException {
        transaction = new Transaction();
        transaction.checkValidCustomerBalance();
        Assert.assertTrue(transaction.getMessage().contains("User balance"));
    }
    @Test(priority = 7)
    public void checkInvalidTranxId() throws IOException {
        transaction = new Transaction();
        transaction.invalidTranxId();
        Assert.assertTrue(transaction.getMessage().contains("Transaction not found"));
    }
    @Test(priority = 8)
    public void checkValidTranxId() throws IOException {
        transaction = new Transaction();
        transaction.validTranxId();
        Assert.assertTrue(transaction.getMessage().contains("Transaction list"));
    }
    @Test(priority = 9)
    public void doInsufficientDeposite() throws IOException {
        transaction = new Transaction();
        transaction.withdrawInvalid();
        Assert.assertTrue(transaction.getMessage().contains("Minimum withdraw amount 10 tk"));
    }
    @Test(priority = 10)
    public void doSufficientDeposite() throws IOException {
        transaction = new Transaction();
        transaction.withdrawValid();
        Assert.assertTrue(transaction.getMessage().contains("Withdraw successful"));
    }
    @Test(priority = 11)
    public void doInsufficientSendMoney() throws IOException {
        transaction = new Transaction();
        transaction.sendMoneyInvalid();
        Assert.assertTrue(transaction.getMessage().contains("Minimum amount 10 tk"));
    }
    @Test(priority = 12)
    public void doSufficientSendMoney() throws IOException {
        transaction = new Transaction();
        transaction.sendMoneyValid();
        Assert.assertTrue(transaction.getMessage().contains("Send money successful"));
    }
    @Test(priority = 13)
    public void invalidNumberStatement() throws IOException {
        transaction = new Transaction();
        transaction.checkStatementInvalid();
        Assert.assertTrue(transaction.getMessage().contains("User not found"));
    }
    @Test(priority = 14)
    public void validNumberStatement() throws IOException {
        transaction = new Transaction();
        transaction.checkStatementValid();
        Assert.assertTrue(transaction.getMessage().contains("Transaction list"));
    }

}

