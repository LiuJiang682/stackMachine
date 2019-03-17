package au.com.nab.stackmachine.userenter.operator;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;

import au.com.nab.stackmachine.history.record.OperationRecord;
import au.com.nab.stackmachine.storage.Storage;
import au.com.nab.stackmachine.userenter.UserEntry;

public abstract class BiOperator implements UserEntry {

	private static final int TWO = 2;

	protected OperationRecord getOperationRecord(BigDecimal first, BigDecimal second) {
		//Reverse the order of Parameters since
		//those parameters come from reverse order.
		List<BigDecimal> params = Arrays.asList(second, first);
		return new OperationRecord(params, this);
	}

	protected boolean isValidOperation(Storage storage) {
		if (storage.getDigitsStackSize() < TWO) {
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
