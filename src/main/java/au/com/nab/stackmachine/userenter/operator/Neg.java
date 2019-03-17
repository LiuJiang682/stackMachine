package au.com.nab.stackmachine.userenter.operator;

import java.math.BigDecimal;

import au.com.nab.stackmachine.history.record.OperationRecord;
import au.com.nab.stackmachine.storage.Storage;

public class Neg extends UnaryOperator {

	@Override
	protected void performDetailOperation(Storage storage) {
		BigDecimal digit = storage.popDigit();
		storage.pushDigit(digit.negate());
		OperationRecord record = getOperationRecord(digit);
		storage.pushOperationRecord(record);
	}

}
