package task7_8.test.b_Money;

import org.junit.Before;
import org.junit.Test;
import task7_8.java.b_Money.*;

import static org.junit.Assert.*;

public class AccountTest {
	Currency SEK, DKK;
	Bank Nordea;
	Bank DanskeBank;
	Bank SweBank;
	Account testAccount;
	
	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		SweBank.openAccount("Alice");
		testAccount = new Account("Hans", SEK);
		testAccount.deposit(new Money(10000000, SEK));

		SweBank.deposit("Alice", new Money(1000000, SEK));
	}
	
    @Test
    public void testAddRemoveTimedPayment() throws AccountExistsException {
        String paymentId = "monthly";
        Money amount = new Money(10000, SEK); // 100.00 SEK
        Bank dummyBank = new Bank("DummyBank", SEK);
        dummyBank.openAccount("dummy");

        testAccount.addTimedPayment(paymentId, 30, 30, amount, dummyBank, "dummy");
        assertTrue("Timed payment should be added", testAccount.timedPaymentExists(paymentId));

        testAccount.removeTimedPayment(paymentId);
        assertFalse("Timed payment should be removed", testAccount.timedPaymentExists(paymentId));
    }
	
	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		fail("Write test case here");
		//I am having troubles implementing this method
	}

	@Test
	public void testAddWithdraw() {
	    Money amount = new Money(500000, SEK); // 5,000.00 SEK
	    testAccount.withdraw(amount);

	    // we are checking if both values are the same 
	    int expectedBalanceAfterWithdrawal = 9500000; // 95,000.00 SEK
	    int actualBalanceAfterWithdrawal = testAccount.getBalance().getAmount();
	    assertEquals("Balance should decrease by 5,000.00 SEK", expectedBalanceAfterWithdrawal, actualBalanceAfterWithdrawal);
	}

	@Test
	public void testGetBalance() {
		// we are checking if both values are the same 
	    int expectedBalance = 10000000; // 100,000.00 SEK
	    int actualBalance = testAccount.getBalance().getAmount();
	    assertEquals("Balance should be 100,000.00 SEK", expectedBalance, actualBalance);
	}
}
