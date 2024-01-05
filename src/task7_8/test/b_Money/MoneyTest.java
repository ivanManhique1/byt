package task7_8.test.b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import task7_8.java.b_Money.*;

public class MoneyTest {
	Currency SEK, DKK, NOK, EUR;
	Money SEK100, EUR10, SEK200, EUR20, SEK0, EUR0, SEKn100;
	
	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
		SEK100 = new Money(10000, SEK); //  100.00 SEK
	    EUR10 = new Money(1000, EUR);   //  10.00 EUR  
		SEK200 = new Money(20000, SEK);
		EUR20 = new Money(2000, EUR);
		SEK0 = new Money(0, SEK);
		EUR0 = new Money(0, EUR);
		SEKn100 = new Money(-10000, SEK);
	}

	@Test
	public void testGetAmount() {
	    assertEquals(100.0, SEK100.getAmount(), 0.0001);
	    assertEquals(10.0, EUR10.getAmount(), 0.0001);
	    //this method works only when in the Money class we set that we are getting the value in Double, 
	    //but then if we do that we get an error in the Bank class
	}


	@Test
	public void testGetCurrency() {
		assertEquals(SEK, SEK100.getCurrency());
        assertEquals(EUR, EUR10.getCurrency());
	}

	@Test
	public void testToString() {
	    assertEquals("100.00 SEK", SEK100.toString());
	    assertEquals("10.00 EUR", EUR10.toString());

	}

	@Test
	public void testGlobalValue() {
		 assertEquals(1500, SEK100.universalValue(), 0.0001);
	     assertEquals(1500, EUR10.universalValue(), 0.0001);
	}

	@Test
	public void testEqualsMoney() {
	    assertEquals(SEK100.universalValue(), new Money(10000, SEK).universalValue()); // Verify SEK100 equals a new Money object of the same amount in SEK
	    assertNotEquals(SEK100.universalValue(), EUR10.universalValue()); // Verify SEK100 does not equal EUR10 in universal value
	}



	@Test
	public void testAdd() {
		 Money sum = SEK100.add(EUR10);
	     assertEquals(200.00, sum.getAmount(), 0.0001);
	     assertEquals(SEK, sum.getCurrency());
	     //we are comparing doubles not integers that is why we use 200.00
	}

	@Test
	public void testSub() {
		Money difference = SEK200.sub(EUR10);
        assertEquals(100.00, difference.getAmount(), 0.0001);
        assertEquals(SEK, difference.getCurrency());
        //we are comparing doubles not integers that is why we use 100.00
	}

	@Test
	public void testIsZero() {
        assertTrue(SEK0.isZero());
        assertFalse(SEK100.isZero());
	}

	@Test
	public void testNegate() {
        assertEquals(-100.00, SEK100.negate().getAmount(), 0.0001);
        assertEquals(SEK, SEK100.negate().getCurrency());
        //we are comparing doubles not integers that is why we use 100.00
	}

	@Test
	public void testCompareTo() {
        assertTrue(SEK100.compareTo(EUR10) == 0);
        assertTrue(SEK200.compareTo(EUR10) > 0);
        assertTrue(SEKn100.compareTo(SEK100) < 0);
	}
}
