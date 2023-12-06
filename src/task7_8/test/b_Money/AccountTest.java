package task7_8.test.b_Money;

import org.junit.Assert;
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
		testAccount.deposit(new Money(1000, SEK));

		SweBank.deposit("Alice", new Money(1000, SEK));
	}

	@Test(expected = AccountDoesNotExistException.class)
	public void testAddRemoveTimedPayment() throws AccountDoesNotExistException {
		testAccount.addTimedPayment("bobb",1,2,new Money(10000000, SEK), SweBank, "joe");
	}

	@Test(expected = AccountDoesNotExistException.class)
	public void testTimedPayment() throws AccountDoesNotExistException {
		testAccount.timedPaymentExists("Bob");
	}

	@Test
	public void testAddWithdraw() {
		testAccount.withdraw(new Money(500, SEK));
		Assert.assertEquals("Not withdrawn",Integer.valueOf(500), (testAccount.getBalance().getAmount()) );
	}

	@Test
	public void testGetBalance() {
		Assert.assertEquals("Not the same balance",Integer.valueOf(1000), (testAccount.getBalance().getAmount()) );
	}
}
