package task7_8.test.b_Money;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import task7_8.java.b_Money.*;
public class BankTest {
    Currency SEK, DKK;
    Bank SweBank, Nordea, DanskeBank;

    @Before
    public void setUp() throws Exception {
        DKK = new Currency("DKK", 0.20);
        SEK = new Currency("SEK", 0.15);
        SweBank = new Bank("SweBank", SEK);
        Nordea = new Bank("Nordea", SEK);
        DanskeBank = new Bank("DanskeBank", DKK);
        SweBank.openAccount("Ulrika");
        SweBank.openAccount("Bob");
        Nordea.openAccount("Bob");
        DanskeBank.openAccount("Gertrud");
    }

    @Test
    public void testGetName() {
        assertEquals("Bank name should be SweBank", "SweBank", SweBank.getName());
        assertEquals("Bank name should be Nordea", "Nordea", Nordea.getName());
    }

    @Test
    public void testGetCurrency() {
        assertEquals("Currency should be SEK", SEK, SweBank.getCurrency());
        assertEquals("Currency should be DKK", DKK, DanskeBank.getCurrency());
    }

    @Test
    public void testOpenAccount() throws AccountExistsException, AccountDoesNotExistException {
        String newAccount = "Alice";
        SweBank.openAccount(newAccount);
        assertTrue("Account should exist", SweBank.getBalance(newAccount) >= 0);
    }

    @Test(expected = AccountExistsException.class)
    public void testOpenExistingAccount() throws AccountExistsException {
        SweBank.openAccount("Ulrika");
    }

    @Test
    public void testDeposit() throws AccountDoesNotExistException {
        Money amount = new Money(500000, SEK); // 5,000.00 SEK
        SweBank.deposit("Ulrika", amount);
        assertEquals("Balance should increase by 5,000.00 SEK", 500000, SweBank.getBalance("Ulrika").intValue());
    }

    @Test
    public void testWithdraw() throws AccountDoesNotExistException {
        Money amount = new Money(200000, SEK); // 2,000.00 SEK
        SweBank.deposit("Ulrika", amount);
        SweBank.withdraw("Ulrika", amount);
        assertEquals("Balance should decrease by 2,000.00 SEK", 0, SweBank.getBalance("Ulrika").intValue());
    }

    @Test
    public void testGetBalance() throws AccountDoesNotExistException {
        assertEquals("Balance should be 0 SEK", 0, SweBank.getBalance("Ulrika").intValue());
    }

    @Test
    public void testTransfer() throws AccountDoesNotExistException {
        Money amount = new Money(300000, SEK); // 3,000.00 SEK
        SweBank.deposit("Ulrika", amount);
        SweBank.transfer("Ulrika", "Bob", amount);
        assertEquals("Bob's balance should be 3,000.00 SEK", 300000, SweBank.getBalance("Bob").intValue());
    }

    @Test
    public void testTimedPayment() throws AccountDoesNotExistException {
        fail("Write test case here");
        //I am having troubles implementing this method
    }
}
