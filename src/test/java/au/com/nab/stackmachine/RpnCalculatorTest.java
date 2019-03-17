package au.com.nab.stackmachine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;

import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;

import au.com.nab.stackmachine.StackMachine;
import au.com.nab.stackmachine.history.record.OperationRecord;
import au.com.nab.stackmachine.storage.Storage;
import au.com.nab.stackmachine.userenter.UserEnter;
import au.com.nab.stackmachine.userenter.UserEntry;
import au.com.nab.stackmachine.userenter.model.DigitalUserEntry;
import au.com.nab.stackmachine.userenter.operator.Add;
import au.com.nab.stackmachine.userenter.operator.Clear;
import au.com.nab.stackmachine.userenter.operator.Inv;
import au.com.nab.stackmachine.userenter.operator.Mul;
import au.com.nab.stackmachine.userenter.operator.SquareRoot;
import au.com.nab.stackmachine.userenter.operator.Subtraction;
import au.com.nab.stackmachine.userenter.operator.Undo;

public class RpnCalculatorTest {

	private StackMachine testInstance;
	
	@Before
	public void setUp() {
		this.testInstance = new StackMachine();
	}
	
	@After
	public void tearDown() {
		this.testInstance = null;
	}
	
	/**
	 * Given a null input stream
	 * When the real constructor called
	 * An IllegalArgumentException raised
	 */
	@Test
	public void whenNullInputStreamProvidedThenAnIllegalArgumentExceptionRaised() {
		//Given a null input stream
		InputStream in = null;
		//When the real constructor called
		try {
			new StackMachine(in);
		}
		catch (IllegalArgumentException e) {
			String message = e.getMessage();
			assertNotNull(message);
			assertEquals("InputStream cannot be null!", message);
		}
	}
	
	/**
	 * Given an input stream
	 * When the real constructor called
	 * A RpnCalculator object should return
	 * @throws Throwable 
	 */
	@Test
	public void whenAnInputStreamProvidedThenARpnCalculatorObjectShouldReturn() throws Throwable {
		//Given a null input stream
		InputStream in = new FileInputStream("src/test/resources/log4j.properties");
		//When the real constructor called
		StackMachine rpnCalculator = new StackMachine(in);
		//Then a RpnCalculator object should return
		assertNotNull(rpnCalculator);
	}
	
	/**
	 * Given user can access to RpnCalculator class
	 * When the default constructor called
	 * A RpnCalculator object should return
	 * @throws Throwable 
	 */
	@Test
	public void whenNoInputStreamProvidedThenARpnCalculatorObjectShouldReturn() throws Throwable {
		//Given user can access to RpnCalculator
		//When the real constructor called
		StackMachine rpnCalculator = new StackMachine();
		//Then a RpnCalculator object should return
		assertNotNull(rpnCalculator);
	}
	
	/**
	 * Given an Addition class UserEntry object
	 * When the formatErrorMessage method called
	 * Then the "+" should return
	 */
	@Test
	public void whenAdditionUserEntryProvidedThenPlusSignShouldReturn() {
		//Given an Addition class UserEntry object
		Add e = new Add();
		int counter = 1;
		//When the formatErrorMessage method called
		String message = testInstance.formatErrorMessage(e, counter);
		//Then the message should contains "+"
		assertNotNull(message);
		assertEquals("Operator: + (position: 1): insufficient parameters", message);
	}
	
	/**
	 * Given an Subtraction class UserEntry object
	 * When the formatErrorMessage method called
	 * Then the "-" should return
	 */
	@Test
	public void whenSubtractionUserEntryProvidedThenPlusSignShouldReturn() {
		//Given an Subtraction class UserEntry object
		Subtraction e = new Subtraction();
		int counter = 1;
		//When the formatErrorMessage method called
		String message = testInstance.formatErrorMessage(e, counter);
		//Then the message should contains "+"
		assertNotNull(message);
		assertEquals("Operator: - (position: 1): insufficient parameters", message);
	}
	
	/**
	 * Given an Multiplication class UserEntry object
	 * When the formatErrorMessage method called
	 * Then the "*" should return
	 */
	@Test
	public void whenMultiplicationUserEntryProvidedThenPlusSignShouldReturn() {
		//Given an Multiplication class UserEntry object
		Mul e = new Mul();
		int counter = 1;
		//When the formatErrorMessage method called
		String message = testInstance.formatErrorMessage(e, counter);
		//Then the message should contains "+"
		assertNotNull(message);
		assertEquals("Operator: * (position: 1): insufficient parameters", message);
	}
	
	/**
	 * Given an Division class UserEntry object
	 * When the formatErrorMessage method called
	 * Then the "/" should return
	 */
	@Test
	public void whenDivisionUserEntryProvidedThenPlusSignShouldReturn() {
		//Given an Division class UserEntry object
		Inv e = new Inv();
		int counter = 1;
		//When the formatErrorMessage method called
		String message = testInstance.formatErrorMessage(e, counter);
		//Then the message should contains "+"
		assertNotNull(message);
		assertEquals("Operator: / (position: 1): insufficient parameters", message);
	}
	
	/**
	 * Given an SquareRoot class UserEntry object
	 * When the formatErrorMessage method called
	 * Then the "sqrt" should return
	 */
	@Test
	public void whenSquareRootUserEntryProvidedThenPlusSignShouldReturn() {
		//Given an SquareRoot class UserEntry object
		SquareRoot e = new SquareRoot();
		int counter = 1;
		//When the formatErrorMessage method called
		String message = testInstance.formatErrorMessage(e, counter);
		//Then the message should contains "+"
		assertNotNull(message);
		assertEquals("Operator: sqrt (position: 1): insufficient parameters", message);
	}
	
	/**
	 * Given an Clear class UserEntry object
	 * When the formatErrorMessage method called
	 * Then the "clear" should return
	 */
	@Test
	public void whenClearUserEntryProvidedThenPlusSignShouldReturn() {
		//Given an Clear class UserEntry object
		Clear e = new Clear();
		int counter = 1;
		//When the formatErrorMessage method called
		String message = testInstance.formatErrorMessage(e, counter);
		//Then the message should contains "+"
		assertNotNull(message);
		assertEquals("Operator: clear (position: 1): insufficient parameters", message);
	}
	
	/**
	 * Given an Undo class UserEntry object
	 * When the formatErrorMessage method called
	 * Then the "clear" should return
	 */
	@Test
	public void whenUndoUserEntryProvidedThenPlusSignShouldReturn() {
		//Given an Undo class UserEntry object
		Undo e = new Undo();
		int counter = 1;
		//When the formatErrorMessage method called
		String message = testInstance.formatErrorMessage(e, counter);
		//Then the message should contains "+"
		assertNotNull(message);
		assertEquals("Operator: undo (position: 1): insufficient parameters", message);
	}
	
	/**
	 * Given an UserEntry class UserEntry object
	 * When the formatErrorMessage method called
	 * Then the "object" should return
	 */
	@Test
	public void whenUserEntryUserEntryProvidedThenPlusSignShouldReturn() {
		//Given an Object class UserEntry object
		UserEntry e = PowerMockito.mock(UserEntry.class);
		int counter = 1;
		//When the formatErrorMessage method called
		String message = testInstance.formatErrorMessage(e, counter);
		//Then the message should contains "+"
		assertNotNull(message);
	}
	
	/**
	 * Given the mock storage and user input
	 * When the run method called
	 * Then the mock storage should be updated
	 * @throws Throwable 
	 */
	@Test
	public void whenMockStorageAndInputProvidedThenStorageShouldBeUpdated() throws Throwable {
		//Given the mock storage and user input
		StackMachine partialMockCalculator = PowerMockito.mock(StackMachine.class);
		UserEnter mockUserEnter = PowerMockito.mock(UserEnter.class);
		List<UserEntry> entries = new ArrayList<>();
		entries.add(new DigitalUserEntry("6"));
		PowerMockito.when(mockUserEnter.getUserInput()).thenReturn(entries, null);
		Whitebox.setInternalState(partialMockCalculator, "userEnter", mockUserEnter);
		Storage mockStorage = PowerMockito.mock(Storage.class);
		Whitebox.setInternalState(partialMockCalculator, "storage", mockStorage);
		PowerMockito.doCallRealMethod().when(partialMockCalculator, "run");
		
		//When the run method called
		partialMockCalculator.run();
		//Then the storage updated
		verify(mockStorage).pushDigit(Matchers.eq(new BigDecimal(6)));
		verify(mockStorage).pushOperationRecord(Matchers.any(OperationRecord.class));
	}
	
	/**
	 * Given the mock storage and user input
	 * When the run method called
	 * Then the mock storage should be updated
	 * @throws Throwable 
	 */
	@Test
	public void whenMockStorageAndInputProvidedWithExceptionThenWarningDisplay() throws Throwable {
		//Given the mock storage and user input
		StackMachine partialMockCalculator = PowerMockito.mock(StackMachine.class);
		Storage mockStorage = PowerMockito.mock(Storage.class);
		Whitebox.setInternalState(partialMockCalculator, "storage", mockStorage);
		UserEnter mockUserEnter = PowerMockito.mock(UserEnter.class);
		List<UserEntry> entries = new ArrayList<>();
		UserEntry mockEntry = PowerMockito.mock(UserEntry.class);
		PowerMockito.doThrow(new EmptyStackException()).when(mockEntry, "execute", mockStorage);
		entries.add(mockEntry);
		PowerMockito.when(mockUserEnter.getUserInput()).thenReturn(entries, null);
		Whitebox.setInternalState(partialMockCalculator, "userEnter", mockUserEnter);
		
		PowerMockito.doCallRealMethod().when(partialMockCalculator, "run");
		
		//When the run method called
		partialMockCalculator.run();
		//Then the warning display
		verify(mockStorage).printStack();
	}
	
	/**
	 * Given the RpnCalculator object
	 * When the getStorage method called
	 * Then an empty storage should return
	 */
	@Test
	public void whenRpnCalculatorObjectProvidedThenAnEmptyStorageShouldReturn() {
		//Given the RpnCalculator object
		//When the getStorage method called
		Storage storage = testInstance.getStorage();
		//Then an empty storage should return
		assertNotNull(storage);
	}

}
