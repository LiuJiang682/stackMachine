package au.com.nab.stackmachine.userenter.operator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Stack;

import org.junit.Test;
import org.mockito.internal.util.reflection.Whitebox;

import au.com.nab.stackmachine.fixture.StackMachineTestFixture;
import au.com.nab.stackmachine.history.record.OperationRecord;
import au.com.nab.stackmachine.storage.DefaultStorage;
import au.com.nab.stackmachine.storage.Storage;

public class UndoTest {

	/**
	 * Given an element in history and stack
	 * When the execute method called
	 * The last digit operation should reverse
	 */
	@Test
	public void whenAnElmentProvidedIntoStorageThenUndoShouldSuccess() {
		Storage storage = new DefaultStorage();
		BigDecimal userEntry = new BigDecimal(6);
		storage.pushDigit(userEntry);
		OperationRecord record = new OperationRecord(StackMachineTestFixture.getOperationParameters(), null);
		storage.pushOperationRecord(record);
		//Given the undo user entry
		Undo testInstance = new Undo();
		//When the execute method called
		testInstance.execute(storage);
		//Then storage should be empty
		@SuppressWarnings("unchecked")
		Stack<BigDecimal> stack = (Stack<BigDecimal>) Whitebox.getInternalState(storage, "digitStack");
		assertNotNull(stack);
		assertTrue(stack.isEmpty());
	}
	
	/**
	 * Given an element in history and stack
	 * When the execute method called
	 * The last digit operation should reverse
	 */
	@Test
	public void whenAnOperatorElmentProvidedIntoStorageThenUndoShouldSuccess() {
		Storage storage = new DefaultStorage();
		BigDecimal userEntry = new BigDecimal(8);
		storage.pushDigit(userEntry);
		OperationRecord record = new OperationRecord(StackMachineTestFixture.get2OperationParameters(), new Add());
		storage.pushOperationRecord(record);
		//Given the undo user entry
		Undo testInstance = new Undo();
		//When the execute method called
		testInstance.execute(storage);
		//Then storage should be empty
		@SuppressWarnings("unchecked")
		Stack<BigDecimal> stack = (Stack<BigDecimal>) Whitebox.getInternalState(storage, "digitStack");
		assertNotNull(stack);
		assertTrue(2 == stack.size());
		assertEquals(new BigDecimal(6), stack.get(0));
		assertEquals(new BigDecimal(2), stack.get(1));
	}
	
	/**
	 * Given an operator
	 * When the isNeedClearUpResult method called
	 * Then the flag should return
	 */
	@Test
	public void whenAnOperatorProvidedThenFlagShouldReturn() {
		assertTrue(Undo.isNeedClearUpResult().test(null));
		assertTrue(Undo.isNeedClearUpResult().test(new Add()));
		assertTrue(Undo.isNeedClearUpResult().test(new Print()));
		assertTrue(Undo.isNeedClearUpResult().test(new Mul()));
		assertTrue(Undo.isNeedClearUpResult().test(new Inv()));
		assertTrue(Undo.isNeedClearUpResult().test(new Quit()));
		assertTrue(Undo.isNeedClearUpResult().test(new Undo()));
		assertFalse(Undo.isNeedClearUpResult().test(new Clear()));
	}
}
