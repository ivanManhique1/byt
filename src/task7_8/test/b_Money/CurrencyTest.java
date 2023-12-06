package task7_8.test.b_Money;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import task7_8.java.b_Money.Currency;

import javax.swing.*;
import java.util.Optional;

public class CurrencyTest {
	Currency SEK, DKK, NOK, EUR;

	@Before
	public void setUp() throws Exception {
		/* Setup currencies with exchange rates */
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
	}

	@Test
	public void testGetName() {
        String msg = "Not the same";
        Assert.assertEquals(msg, "SEK", SEK.getName());
        Assert.assertEquals(msg, "DKK", DKK.getName());
        Assert.assertEquals(msg, "EUR", EUR.getName());
	}

	@Test
	public void testGetRate() {
        String msg = "Not the same";
        Assert.assertEquals(msg, 0.15, SEK.getRate(), 0.001);
        Assert.assertEquals(msg, 0.20, DKK.getRate(), 0.001);
        Assert.assertEquals(msg, 1.5, EUR.getRate(), 0.001);
    }

	@Test
	public void testSetRate() {
        String msg = "Not the same";
        SEK.setRate(0.0004);
        Assert.assertEquals(msg,0.0004, SEK.getRate(), 0.001);
	}

	@Test
	public void testGlobalValue() {
        Assert.assertEquals(Integer.valueOf(15), SEK.universalValue(100));
	}

	@Test
	public void testValueInThisCurrency() {
        Assert.assertEquals(Integer.valueOf(133), SEK.valueInThisCurrency(100, DKK));
	}

}
