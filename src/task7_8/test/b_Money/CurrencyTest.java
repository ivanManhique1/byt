package task7_8.test.b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import task7_8.java.b_Money.Currency;

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
		assertEquals("SEK", SEK.getName());
        assertEquals("DKK", DKK.getName());
        assertEquals("EUR", EUR.getName());
	}
	
	@Test
	public void testGetRate() {
		assertEquals(0.15, SEK.getRate(), 0.001);
        assertEquals(0.20, DKK.getRate(), 0.001);
        assertEquals(1.5, EUR.getRate(), 0.001);
	}
	
	@Test
	public void testSetRate() {
		SEK.setRate(0.2);
        assertEquals(0.2, SEK.getRate(), 0.001);
	}
	
	@Test
	public void testGlobalValue() {
		assertEquals(1500.0, EUR.universalValue(1000), 0.001);

	}
	
	@Test
	public void testValueInThisCurrency() {
		assertEquals((Integer) 1000, EUR.valueInThisCurrency(10000, SEK));

	}

}
