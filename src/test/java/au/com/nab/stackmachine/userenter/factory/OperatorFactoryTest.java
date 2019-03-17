package au.com.nab.stackmachine.userenter.factory;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;

import au.com.nab.stackmachine.userenter.UserEntry;
import au.com.nab.stackmachine.userenter.operator.Add;
import au.com.nab.stackmachine.userenter.operator.Clear;
import au.com.nab.stackmachine.userenter.operator.Inv;
import au.com.nab.stackmachine.userenter.operator.Mul;
import au.com.nab.stackmachine.userenter.operator.Print;
import au.com.nab.stackmachine.userenter.operator.Quit;
import au.com.nab.stackmachine.userenter.operator.Undo;

public class OperatorFactoryTest {

	/**
	 * Given an add string
	 * When the gerOperator method called
	 * Then the add operator should return
	 */
	@Test
	public void whenAnAdditionStringProvidedThenTheAddOperatorShouldReturn() {
		//Given an add string
		String userEntered = "add";
		//When the getOperator method called
		Optional<UserEntry> userEntry = OperatorFactory.getOperator(userEntered);
		//Then the addition operator return
		assertNotNull(userEntry);
		assertTrue(userEntry.isPresent());
		assertTrue(userEntry.get() instanceof Add);
	}
	
	/**
	 * Given a print string
	 * When the gerOperator method called
	 * Then the print operator should return
	 */
	@Test
	public void whenAPrintStringProvidedThenThePrintOperatorShouldReturn() {
		//Given a print string
		String userEntered = "print";
		//When the getOperator method called
		Optional<UserEntry> userEntry = OperatorFactory.getOperator(userEntered);
		//Then the Subtraction operator return
		assertNotNull(userEntry);
		assertTrue(userEntry.isPresent());
		assertTrue(userEntry.get() instanceof Print);
	}
	
	/**
	 * Given a mul string
	 * When the gerOperator method called
	 * Then the mul operator should return
	 */
	@Test
	public void whenAMultiplicationStringProvidedThenTheMulOperatorShouldReturn() {
		//Given a multiplication string
		String userEntered = "Mul";
		//When the getOperator method called
		Optional<UserEntry> userEntry = OperatorFactory.getOperator(userEntered);
		//Then the Multiplication operator return
		assertNotNull(userEntry);
		assertTrue(userEntry.isPresent());
		assertTrue(userEntry.get() instanceof Mul);
	}
	
	/**
	 * Given a Inv string
	 * When the gerOperator method called
	 * Then the division operator should return
	 */
	@Test
	public void whenAInvStringProvidedThenTheInvperatorShouldReturn() {
		//Given a division string
		String userEntered = "Inv";
		//When the getOperator method called
		Optional<UserEntry> userEntry = OperatorFactory.getOperator(userEntered);
		//Then the division operator return
		assertNotNull(userEntry);
		assertTrue(userEntry.isPresent());
		assertTrue(userEntry.get() instanceof Inv);
	}
	
	/**
	 * Given a quit string
	 * When the gerOperator method called
	 * Then the quit operator should return
	 */
	@Test
	public void whenAQuitStringProvidedThenTheQuitOperatorShouldReturn() {
		//Given a quit string
		String userEntered = "quit";
		//When the getOperator method called
		Optional<UserEntry> userEntry = OperatorFactory.getOperator(userEntered);
		//Then the square root operator return
		assertNotNull(userEntry);
		assertTrue(userEntry.isPresent());
		assertTrue(userEntry.get() instanceof Quit);
	}
	
	/**
	 * Given clear string
	 * When the gerOperator method called
	 * Then the clear operator should return
	 */
	@Test
	public void whenAClearStringProvidedThenTheClearOperatorShouldReturn() {
		//Given a clear string
		String userEntered = "clear";
		//When the getOperator method called
		Optional<UserEntry> userEntry = OperatorFactory.getOperator(userEntered);
		//Then the square root operator return
		assertNotNull(userEntry);
		assertTrue(userEntry.isPresent());
		assertTrue(userEntry.get() instanceof Clear);
	}
	
	/**
	 * Given undo string
	 * When the gerOperator method called
	 * Then the undo operator should return
	 */
	@Test
	public void whenAUndoStringProvidedThenTheUndoOperatorShouldReturn() {
		//Given a clear string
		String userEntered = "undo";
		//When the getOperator method called
		Optional<UserEntry> userEntry = OperatorFactory.getOperator(userEntered);
		//Then the square root operator return
		assertNotNull(userEntry);
		assertTrue(userEntry.isPresent());
		assertTrue(userEntry.get() instanceof Undo);
	}
	
	/**
	 * Given an invalid string
	 * When the gerOperator method called
	 * Then the empty optional object return
	 */
	@Test
	public void whenAnInvalidStringProvidedThenEmptyOptionalShouldReturn() {
		//Given an invalid string
		String userEntered = "abc";
		//When the getOperator method called
		Optional<UserEntry> userEntry = OperatorFactory.getOperator(userEntered);
		//Then the addition operator return
		assertNotNull(userEntry);
		assertFalse(userEntry.isPresent());
	}
	
	/**
	 * Given an empty string
	 * When the gerOperator method called
	 * Then the empty optional object return
	 */
	@Test
	public void whenEmptyStringProvidedThenEmptyOptionalObjectShouldReturn() {
		//Given an empty string
		String userEntered = "";
		//When the getOperator method called
		Optional<UserEntry> userEntry =
			OperatorFactory.getOperator(userEntered);
		//Then the empty optional object should return
		assertNotNull(userEntry);
		assertFalse(userEntry.isPresent());
	}
	
	/**
	 * Given a null string
	 * When the gerOperator method called
	 * Then the empty optional object should return
	 */
	@Test
	public void whenNullStringProvidedThenEmptyOptionalObjectShouldReturn() {
		//Given a null string
		String userEntered = null;
		//When the getOperator method called
		Optional<UserEntry> userEntry = OperatorFactory.getOperator(userEntered);
		//Then the empty optional object should return
		assertNotNull(userEntry);
		assertFalse(userEntry.isPresent());
	}
}
