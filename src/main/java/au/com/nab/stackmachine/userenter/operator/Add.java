package au.com.nab.stackmachine.userenter.operator;

import java.math.BigDecimal;

import au.com.nab.stackmachine.history.record.OperationRecord;
import au.com.nab.stackmachine.storage.Storage;

public class Add extends BiOperator {

	@Override
	protected void performDetailOperation(Storage storage) {
		BigDecimal first = storage.popDigit();
		BigDecimal second = storage.popDigit();
		BigDecimal result = second.add(first);
		storage.pushDigit(result);
		OperationRecord record = getOperationRecord(first, second);
		storage.pushOperationRecord(record);
	}
}
