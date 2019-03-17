package au.com.nab.stackmachine.userenter.operator;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import au.com.nab.stackmachine.history.record.OperationRecord;
import au.com.nab.stackmachine.storage.Storage;

public class PushTest {

	@Test
	public void shouldReturnObjectWhenConstructorCalledWithString() {
		//Given
		String userEntered = "push 123";
		//When
		Push push = new Push(userEntered);
		//Then
		assertThat(push, is(notNullValue()));
	}
	
	@Test
	public void shouldAddADataIntoStackWhenStringIsValid() {
		//Given
		String userEntered = "push 123";
		Push push = new Push(userEntered);
		Storage mockStorage = Mockito.mock(Storage.class);
		//When
		push.execute(mockStorage);
		//Then
		ArgumentCaptor<BigDecimal> digitalCaptor = ArgumentCaptor.forClass(BigDecimal.class);
		verify(mockStorage).pushDigit(digitalCaptor.capture());
		List<BigDecimal> digitals = digitalCaptor.getAllValues();
		assertThat(digitals, is(notNullValue()));
		assertThat(digitals.size(), is(equalTo(1)));
		assertThat(digitals.get(0), is(equalTo(new BigDecimal("123"))));
		ArgumentCaptor<OperationRecord> recordCaptor = ArgumentCaptor.forClass(OperationRecord.class);
		verify(mockStorage).pushOperationRecord(recordCaptor.capture());
		List<OperationRecord> records = recordCaptor.getAllValues();
		assertThat(records, is(notNullValue()));
		assertThat(records.size(), is(equalTo(1)));
		assertThat(records.get(0).getOperator(), is(instanceOf(Push.class)));
		assertThat(records.get(0).getParameters().size(), is(equalTo(1)));
		assertThat(records.get(0).getParameters().get(0), is(equalTo(new BigDecimal("123"))));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldRaiseExceptionWhenConstructorCalledWithNullString() {
		//Given
		String userEntered = null;
		//When
		new Push(userEntered);
		fail("Program reached unexpected point!");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldRaiseExceptionWhenStringIsIncorrect() {
		//Given
		String userEntered = "push";
		Push push = new Push(userEntered);
		Storage mockStorage = Mockito.mock(Storage.class);
		//When
		push.execute(mockStorage);
		fail("Program reached unexpected point!");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldRaiseExceptionWhenStringIsIncorrectNumber() {
		//Given
		String userEntered = "push 1gh";
		Push push = new Push(userEntered);
		Storage mockStorage = Mockito.mock(Storage.class);
		//When
		push.execute(mockStorage);
		fail("Program reached unexpected point!");
	}
}
