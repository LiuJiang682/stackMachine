package au.com.nab.stackmachine.userenter.operator;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.EmptyStackException;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import au.com.nab.stackmachine.history.record.OperationRecord;
import au.com.nab.stackmachine.storage.Storage;

public class NegTest {

	@Test
	public void shouldPerformNegateWhenStackHasOneElement() {
		//Given
		Storage mockStorage = Mockito.mock(Storage.class);
		when(mockStorage.getDigitsStackSize()).thenReturn(1);
		when(mockStorage.popDigit()).thenReturn(new BigDecimal("5"));
		Neg neg = new Neg();
		//When
		neg.execute(mockStorage);
		//Then
		ArgumentCaptor<BigDecimal> resultCaptor = ArgumentCaptor.forClass(BigDecimal.class);
		verify(mockStorage).pushDigit(resultCaptor.capture());
		List<BigDecimal> results = resultCaptor.getAllValues();
		assertThat(results, is(notNullValue()));
		assertThat(results.size(), is(equalTo(1)));
		assertThat(results.get(0), is(equalTo(new BigDecimal("-5"))));
		ArgumentCaptor<OperationRecord> recordCaptor = ArgumentCaptor.forClass(OperationRecord.class);
		verify(mockStorage).pushOperationRecord(recordCaptor.capture());
		List<OperationRecord> records = recordCaptor.getAllValues();
		assertThat(records, is(notNullValue()));
		assertThat(records.size(), is(equalTo(1)));
		assertThat(records.get(0).getOperator(), is(instanceOf(Neg.class)));
		assertThat(records.get(0).getParameters().size(), is(equalTo(1)));
		assertThat(records.get(0).getParameters().get(0), is(equalTo(new BigDecimal("5"))));
	}
	
	@Test(expected = EmptyStackException.class)
	public void shouldRaiseExceptionWhenStackHasNotElement() {
		//Given
		Storage mockStorage = Mockito.mock(Storage.class);
		Neg neg = new Neg();
		//When
		neg.execute(mockStorage);
		fail("Program reached unexpected point!");
	}
}
