import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestArithmetic {

	@Test
	@DisplayName("[5] Test if evaluate works")
	public void testEvaluate() {
		
		assertEquals(5, Arithmetic.evaluate("( 2 + ( ( 3 * 5 ) / ( 11 - 6 ) ) )"));
	}
	
	@Test
	@DisplayName("[5] Test if operate works")
	public void testOperate() {
		
		assertEquals(7, Arithmetic.operate(3, 4, "+"));
		assertEquals(-1, Arithmetic.operate(3, 4, "-"));
		assertEquals(12, Arithmetic.operate(3, 4, "*"));
		assertEquals(0, Arithmetic.operate(3, 4, "/"));
	}
	
	@Test
	@DisplayName("[5] Test if evaluateStout works")
	public void testEvaluateStout() {
		
		assertEquals(5, Arithmetic.evaluateStout("2 3 5 * 11 6 - / +"));
	}
	
	@Test
	@DisplayName("[5] Test if convertClassicToStout works")
	public void testConvertClassicToStout() {
		
		assertEquals("2 3 5 * 11 6 - / +", Arithmetic.convertClassicToStout("( 2 + ( ( 3 * 5 ) / ( 11 - 6 ) ) )").trim());
	}


}