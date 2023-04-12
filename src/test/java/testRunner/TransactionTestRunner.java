package testRunner;

import controller.Transaction;
import org.apache.commons.configuration.ConfigurationException;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.Setup;

import java.io.IOException;

public class TransactionTestRunner extends Setup {
    Transaction transaction;
    @Test(priority = 1, description = "From SYSTEM to agent deposit can not be make with insufficient amount")
    public void doInvalidDepositeAgent() throws IOException{
        transaction = new Transaction();
        transaction.depositeInsufficientAgent();
        Assert.assertTrue(transaction.getMessage().contains("Minimum deposit amount 10 tk and maximum deposit amount 10000 tk"));
    }
    @Test(priority = 2, description = "From SYSTEM to agent deposit can be make with sufficient amount")
    public void doValidDepositeAgent() throws IOException, ConfigurationException {
        transaction = new Transaction();
        transaction.depositeSufficientAgent();
        Assert.assertTrue(transaction.getMessage().contains("Deposit successful"));
    }
    @Test(priority = 3, description = "From agent to customer deposit can not be make with insufficient amount")
    public void doInvalidDepositeCustomer() throws IOException {
        transaction = new Transaction();
        transaction.depositeInsufficienCustomer();
        Assert.assertTrue(transaction.getMessage().contains("Minimum deposit amount 10 tk and maximum deposit amount 10000 tk"));
    }
    @Test(priority = 4, description = "From agent to customer deposit can be make with sufficient amount")
    public void doValidDepositeCustomer() throws IOException, ConfigurationException {
        transaction = new Transaction();
        transaction.depositeSufficientCustomer();
        Assert.assertTrue(transaction.getMessage().contains("Deposit successful"));
    }
    @Test(priority = 5, description = "Invalid phone number customer's balance can not be checked")
    public void checkInvalidBalance() throws IOException {
        transaction = new Transaction();
        transaction.checkInvalidCustomerBalance();
        Assert.assertTrue(transaction.getMessage().contains("User not found"));
    }
    @Test(priority = 6, description = "Valid phone number customer's balance can be checked")
    public void checkValidBalance() throws IOException {
        transaction = new Transaction();
        transaction.checkValidCustomerBalance();
        Assert.assertTrue(transaction.getMessage().contains("User balance"));
    }
    @Test(priority = 7, description = "If the transaction id is not correct then the transaction results will not show")
    public void checkInvalidTranxId() throws IOException {
        transaction = new Transaction();
        transaction.invalidTranxId();
        Assert.assertTrue(transaction.getMessage().contains("Transaction not found"));
    }
    @Test(priority = 8, description = "If the transaction id is correct then the transaction results will show")
    public void checkValidTranxId() throws IOException {
        transaction = new Transaction();
        transaction.validTranxId();
        Assert.assertTrue(transaction.getMessage().contains("Transaction list"));
    }
    @Test(priority = 9, description = "If the withdraw amount is insufficient then the withdraw will fail")
    public void doInsufficientWithdraw() throws IOException {
        transaction = new Transaction();
        transaction.withdrawInvalid();
        Assert.assertTrue(transaction.getMessage().contains("Minimum withdraw amount 10 tk"));
    }
    @Test(priority = 10, description = "If the withdraw amount is sufficient then the withdraw will succeed")
    public void doSufficientWithdraw() throws IOException {
        transaction = new Transaction();
        transaction.withdrawValid();
        Assert.assertTrue(transaction.getMessage().contains("Withdraw successful"));
    }
    @Test(priority = 11, description = "If the amount is insufficient then the send money will fail")
    public void doInsufficientSendMoney() throws IOException {
        transaction = new Transaction();
        transaction.sendMoneyInvalid();
        Assert.assertTrue(transaction.getMessage().contains("Minimum amount 10 tk"));
    }
    @Test(priority = 12, description = "If the amount is sufficient then the send money will succeed")
    public void doSufficientSendMoney() throws IOException {
        transaction = new Transaction();
        transaction.sendMoneyValid();
        Assert.assertTrue(transaction.getMessage().contains("Send money successful"));
    }
    @Test(priority = 13, description = "Invalid phone number customer's statement will not show in result")
    public void invalidNumberStatement() throws IOException {
        transaction = new Transaction();
        transaction.checkStatementInvalid();
        Assert.assertTrue(transaction.getMessage().contains("User not found"));
    }
    @Test(priority = 14, description = "Valid phone number customer's statement will show in result")
    public void validNumberStatement() throws IOException {
        transaction = new Transaction();
        transaction.checkStatementValid();
        Assert.assertTrue(transaction.getMessage().contains("Transaction list"));
    }

}

