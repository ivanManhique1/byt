package task7_8.test.b_Money;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
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
		String msg = "Not equal";
        Assert.assertEquals(msg, "SweBank", SweBank.getName());
	}

	@Test
	public void testGetCurrency() {
        String msg = "Not the equivalent currency";
        Assert.assertEquals(msg, SEK, SweBank.getCurrency());
	}

	@Test(expected = AccountExistsException.class )
	public void testOpenAccount() throws AccountExistsException{
		SweBank.openAccount("Bob");
	}

	@Test(expected = AccountDoesNotExistException.class)
	public void testDeposit() throws AccountDoesNotExistException {
		SweBank.deposit("juninho", new Money(1234, SEK));
	}

	@Test(expected = AccountDoesNotExistException.class)
	public void testWithdraw() throws AccountDoesNotExistException {
        SweBank.withdraw("juninho", new Money(1234, SEK));
	}

	@Test(expected = AccountDoesNotExistException.class)
	public void testGetBalance() throws AccountDoesNotExistException {
        SweBank.getBalance("juninho");
	}

	@Test(expected = AccountDoesNotExistException.class)
	public void testTransfer() throws AccountDoesNotExistException {
        SweBank.transfer("juninho","Bob",  new Money(1234, SEK));	}

	@Test(expected = AccountDoesNotExistException.class)
	public void testTimedPayment() throws AccountDoesNotExistException {
        SweBank.addTimedPayment("juninho", "1",1,2,new Money(1234, SEK), SweBank,"Bob");
	}
}
