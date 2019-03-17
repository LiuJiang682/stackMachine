package au.com.nab.stackmachine.userenter.operator;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import au.com.nab.stackmachine.storage.Storage;

public class PrintTest {

	private Print print;
	
	@Before
	public void setUp() {
		print = new Print();
	}
	
	@Test
	public void shouldCalledThePrintStackMethod() {
		//Given
		Storage mockStorage = Mockito.mock(Storage.class);
		//When
		print.execute(mockStorage);
		//Then
		verify(mockStorage).printStack();
	}
}
