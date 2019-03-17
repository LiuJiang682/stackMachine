package au.com.nab.stackmachine.userenter.model;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import au.com.nab.stackmachine.userenter.enums.OperatorsEnum;

/**
 * In order to perform reverse polish notation calculation
 * As the RPN calculator operator, I like to
 * parse the user entered string into Operator Enum.
 */
public class OperatorsEnumTest {

	/**
	 * Given a null string
	 * when the fromString method called
	 * Then an IllegalArgumentException will raised
	 */
	@Test(expected = IllegalArgumentException.class)
	public void whenNullStringProvidedThenIllegalArgumentExceptionWillRaised() {
		//give a null string
		String userEntered = null;
		//When the fromString method called
		OperatorsEnum.fromString(userEntered);
		fail("Program reached unexpected point");
	}
	
	/**
	 * Given an empty string
	 * when the fromString method called
	 * Then an IllegalArgumentException will raised
	 */
	@Test(expected = IllegalArgumentException.class)
	public void whenAnEmptyStringProvidedThenIllegalArgumentExceptionWillRaised() {
		//give an empty string
		String userEntered = "";
		//When the fromString method called
		OperatorsEnum.fromString(userEntered);
		fail("Program reached unexpected point");
	}
	
	/**
	 * Given an invalid string
	 * when the fromString method called
	 * Then an IllegalArgumentException will raised
	 */
	@Test(expected = IllegalArgumentException.class)
	public void whenAnInvalidStringProvidedThenIllegalArgumentExceptionWillRaised() {
		//give an invalid string
		String userEntered = "abc";
		//When the fromString method called
		OperatorsEnum.fromString(userEntered);
		fail("Program reached unexpected point");
		
	}
	
	/**
	 * Given an add string
	 * when the fromString method called
	 * Then an add operator will return
	 */
	@Test
	public void whenAnAdditionStringProvidedThenAnAdditionOperatorShouldReturn() {
		//give an addition string
		String userEntered = "ADD";
		//When the fromString method called
		OperatorsEnum operator =	OperatorsEnum.fromString(userEntered);
		//Then an addition operator will return
		assertTrue(OperatorsEnum.ADD == operator);
	}
	
	/**
	 * Given a pop string
	 * when the fromString method called
	 * Then a pop operator will return
	 */
	@Test
	public void whenAsPopStringProvidedThenAPopOperatorShouldReturn() {
		//give a subtraction string
		String userEntered = "POP";
		//When the fromString method called
		OperatorsEnum operator =	OperatorsEnum.fromString(userEntered);
		//Then a subtraction operator will return
		assertTrue(OperatorsEnum.POP == operator);
	}
	
	/**
	 * Given a Multiplication string
	 * when the fromString method called
	 * Then a Multiplication operator will return
	 */
	@Test
	public void whenAMultiplicationStringProvidedThenAMultiplicationOperatorShouldReturn() {
		//give a Multiplication string
		String userEntered = "MUL";
		//When the fromString method called
		OperatorsEnum operator =	OperatorsEnum.fromString(userEntered);
		//Then a multiplication operator will return
		assertTrue(OperatorsEnum.MUL == operator);
	}
	
	/**
	 * Given a NEG string
	 * when the fromString method called
	 * Then a NEG operator will return
	 */
	@Test
	public void whenADivisionStringProvidedThenANEGShouldReturn() {
		//give a NEG string
		String userEntered = "NEG";
		//When the fromString method called
		OperatorsEnum operator =	OperatorsEnum.fromString(userEntered);
		//Then a division operator will return
		assertTrue(OperatorsEnum.NEG == operator);
	}
	
	/**
	 * Given an INV string
	 * when the fromString method called
	 * Then a INV operator will return
	 */
	@Test
	public void whenAnINVStringProvidedThenAnINVOperatorShouldReturn() {
		//give an INV string
		String userEntered = "INV";
		//When the fromString method called
		OperatorsEnum operator =	OperatorsEnum.fromString(userEntered);
		//Then a square root operator will return
		assertTrue(OperatorsEnum.INV == operator);
	}
	
	/**
	 * Given a push string
	 * when the fromString method called
	 * Then a push operator will return
	 */
	@Test
	public void whenAPushStringProvidedThenAPushOperatorShouldReturn() {
		//give an INV string
		String userEntered = "PUSH";
		//When the fromString method called
		OperatorsEnum operator =	OperatorsEnum.fromString(userEntered);
		//Then a square root operator will return
		assertTrue(OperatorsEnum.PUSH == operator);
	}
	
	/**
	 * Given an undo string
	 * when the fromString method called
	 * Then an undo operator will return
	 */
	@Test
	public void whenAnUndoStringProvidedThenAnUndoOperatorShouldReturn() {
		//give a undo string
		String userEntered = "UNDO";
		//When the fromString method called
		OperatorsEnum operator =	OperatorsEnum.fromString(userEntered);
		//Then an undo operator will return
		assertTrue(OperatorsEnum.UNDO == operator);
	}
	
	/**
	 * Given a clear string
	 * when the fromString method called
	 * Then an clear operator will return
	 */
	@Test
	public void whenAClearStringProvidedThenAClearOperatorShouldReturn() {
		//give a clear string
		String userEntered = "clear";
		//When the fromString method called
		OperatorsEnum operator =	OperatorsEnum.fromString(userEntered);
		//Then a clear operator will return
		assertTrue(OperatorsEnum.CLEAR == operator);
	}
	
	/**
	 * Given a print string
	 * when the fromString method called
	 * Then an print operator will return
	 */
	@Test
	public void whenAPrintStringProvidedThenAPrintOperatorShouldReturn() {
		//give a print string
		String userEntered = "print";
		//When the fromString method called
		OperatorsEnum operator =	OperatorsEnum.fromString(userEntered);
		//Then a print operator will return
		assertTrue(OperatorsEnum.PRINT == operator);
	}
	
	/**
	 * Given a quit string
	 * when the fromString method called
	 * Then an quit operator will return
	 */
	@Test
	public void whenAQuitStringProvidedThenAQuitOperatorShouldReturn() {
		//give a quit string
		String userEntered = "quit";
		//When the fromString method called
		OperatorsEnum operator =	OperatorsEnum.fromString(userEntered);
		//Then a quit operator will return
		assertTrue(OperatorsEnum.QUIT == operator);
	}
}
