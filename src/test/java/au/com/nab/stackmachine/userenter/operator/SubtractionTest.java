package au.com.nab.stackmachine.userenter.operator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;

import au.com.nab.stackmachine.fixture.RpnCalculatorTestFixture;
import au.com.nab.stackmachine.history.record.OperationRecord;
import au.com.nab.stackmachine.storage.Storage;
import au.com.nab.stackmachine.userenter.operator.Subtraction;

public class SubtractionTest {

	private Subtraction testInstance;
	
	@Before
	public void setUp() {
		this.testInstance = new Subtraction();
	}

	@After
	public void tearDown() {
		this.testInstance = null;
	}
	
	/**
	 * Given 2 elements in the storage
	 * When the execute method called
	 * The storage will update the result
	 */
	@Test
	public void when2ElementsProvidedThenStorageUpdateWithOneResult() {
		//Given 2 elements in the storage
		Storage mockStorage = RpnCalculatorTestFixture.givenMockStorage();
		
		//When the execute method called
		testInstance.execute(mockStorage);
		//Then the storage is updated
		verify(mockStorage).pushDigit(Matchers.eq(new BigDecimal(4)));
		verify(mockStorage, times(2)).popDigit();
		verify(mockStorage).pushOperationRecord(Matchers.any(OperationRecord.class));
	}
	
	/**
	 * Given 2 elements
	 * When the getOperationRecord method called
	 * Then an OperationRecord object should return
	 */
	@Test
	public void when2ElementsProvidedThenAnOperationRecordShouldReturn() {
		//Given 2 elements in the storage
		//When the getOperaitonRecord method called
		OperationRecord record = this.testInstance.getOperationRecord(new BigDecimal(2), new BigDecimal(6));
		//Then an OperationRecord object should return
		assertNotNull(record);
		assertTrue(2 ==  record.getParameters().size());
		assertEquals(this.testInstance, record.getOperator());
		assertEquals(new BigDecimal(6), record.getParameters().get(0));
		assertEquals(new BigDecimal(2), record.getParameters().get(1));
	}
	
}
