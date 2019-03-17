package au.com.nab.stackmachine.userenter.operator;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;

import au.com.nab.stackmachine.constants.Constants.Numerice;
import au.com.nab.stackmachine.history.record.OperationRecord;
import au.com.nab.stackmachine.storage.Storage;
import au.com.nab.stackmachine.userenter.UserEntry;

public abstract class UnaryOperator implements UserEntry {

	protected OperationRecord getOperationRecord(BigDecimal digit) {
		List<BigDecimal> params = Arrays.asList(digit);
		return new OperationRecord(params, this);
	}
	
	protected boolean isValidOperation(Storage storage) {
		if (storage.getDigitsStackSize() < Numerice.ONE) {
			throw new EmptyStackException();
		}
		
		return true;
	}

	@Override
	public void execute(Storage storage) {
		if (isValidOperation(storage)) {
			performDetailOperation(storage);
		}
	}
	
	protected abstract void performDetailOperation(Storage storage);
}
