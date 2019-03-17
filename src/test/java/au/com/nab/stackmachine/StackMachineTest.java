package au.com.nab.stackmachine;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;

import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;

import au.com.nab.stackmachine.history.record.OperationRecord;
import au.com.nab.stackmachine.storage.Storage;
import au.com.nab.stackmachine.userenter.UserEnter;
import au.com.nab.stackmachine.userenter.UserEntry;
import au.com.nab.stackmachine.userenter.model.DigitalUserEntry;
import au.com.nab.stackmachine.userenter.operator.Add;
import au.com.nab.stackmachine.userenter.operator.Clear;
import au.com.nab.stackmachine.userenter.operator.Inv;
import au.com.nab.stackmachine.userenter.operator.Mul;
import au.com.nab.stackmachine.userenter.operator.Push;
import au.com.nab.stackmachine.userenter.operator.Undo;

public class StackMachineTest {

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
	 * Given an Add class UserEntry object
	 * When the formatErrorMessage method called
	 * Then the "Add" should return
	 */
	@Test
	public void whenAddUserEntryProvidedThenPlusSignShouldReturn() {
		//Given an Add class UserEntry object
		Add e = new Add();
		int counter = 1;
		//When the formatErrorMessage method called
		String message = testInstance.formatErrorMessage(e, counter);
		//Then the message should contains "+"
		assertNotNull(message);
		assertEquals("Operator: Add (position: 1): insufficient parameters", message);
	}
	
	/**
	 * Given an Mul class UserEntry object
	 * When the formatErrorMessage method called
	 * Then the "Mul" should return
	 */
	@Test
	public void whenMulUserEntryProvidedThenPlusSignShouldReturn() {
		//Given an Mul class UserEntry object
		Mul e = new Mul();
		int counter = 1;
		//When the formatErrorMessage method called
		String message = testInstance.formatErrorMessage(e, counter);
		//Then the message should contains "+"
		assertNotNull(message);
		assertEquals("Operator: Mul (position: 1): insufficient parameters", message);
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
		assertThat(message, is(equalTo("Operator: Clear (position: 1): insufficient parameters")));
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
		assertThat(message, is(equalTo("Operator: Undo (position: 1): insufficient parameters")));
	}
	
	/**
	 * Given an Inv class UserEntry object
	 * When the formatErrorMessage method called
	 * Then the "Inv" should return
	 */
	@Test
	public void whenInvUserEntryProvidedThenPlusSignShouldReturn() {
		//Given an Inv class UserEntry object
		Inv e = new Inv();
		int counter = 1;
		//When the formatErrorMessage method called
		String message = testInstance.formatErrorMessage(e, counter);
		//Then the message should contains "+"
		assertNotNull(message);
		assertThat(message, is(equalTo("Operator: Inv (position: 1): insufficient parameters")));
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
		StackMachine partialMockStackMachine = PowerMockito.mock(StackMachine.class);
		UserEnter mockUserEnter = PowerMockito.mock(UserEnter.class);
		List<UserEntry> entries = new ArrayList<>();
		entries.add(new Push("Push 6"));
		PowerMockito.when(mockUserEnter.getUserInput()).thenReturn(entries, null);
		Whitebox.setInternalState(partialMockStackMachine, "userEnter", mockUserEnter);
		Storage mockStorage = PowerMockito.mock(Storage.class);
		Whitebox.setInternalState(partialMockStackMachine, "storage", mockStorage);
		PowerMockito.doCallRealMethod().when(partialMockStackMachine, "run");
		
		//When the run method called
		partialMockStackMachine.run();
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
		StackMachine partialMockStackMachine = PowerMockito.mock(StackMachine.class);
		Storage mockStorage = PowerMockito.mock(Storage.class);
		Whitebox.setInternalState(partialMockStackMachine, "storage", mockStorage);
		UserEnter mockUserEnter = PowerMockito.mock(UserEnter.class);
		List<UserEntry> entries = new ArrayList<>();
		UserEntry mockEntry = PowerMockito.mock(UserEntry.class);
		PowerMockito.doThrow(new EmptyStackException()).when(mockEntry, "execute", mockStorage);
		entries.add(mockEntry);
		PowerMockito.when(mockUserEnter.getUserInput()).thenReturn(entries, null);
		Whitebox.setInternalState(partialMockStackMachine, "userEnter", mockUserEnter);
		PowerMockito.doCallRealMethod().when(partialMockStackMachine, "run");
		PowerMockito.doReturn("Operator: Pop (position: 1): insufficient parameters").when(partialMockStackMachine, "formatErrorMessage", Matchers.any(UserEntry.class), Matchers.anyInt());
		Logger mockLogger = Mockito.mock(Logger.class);
		Whitebox.setInternalState(StackMachine.class, "LOGGER", mockLogger);
		//When the run method called
		partialMockStackMachine.run();
		//Then the warning display
		ArgumentCaptor<String> errorMessageCaptor = ArgumentCaptor.forClass(String.class);
		verify(mockLogger).error(errorMessageCaptor.capture());
		List<String> messages = errorMessageCaptor.getAllValues();
		assertThat(messages, is(notNullValue()));
		assertThat(messages.size(), is(equalTo(1)));
		assertThat(messages.get(0), is(equalTo("Operator: Pop (position: 1): insufficient parameters")));
	}
	
	/**
	 * Given the StackMachine object
	 * When the getStorage method called
	 * Then an empty storage should return
	 */
	@Test
	public void whenStackMachineObjectProvidedThenAnEmptyStorageShouldReturn() {
		//Given the StackMachine object
		//When the getStorage method called
		Storage storage = testInstance.getStorage();
		//Then an empty storage should return
		assertNotNull(storage);
	}

}
