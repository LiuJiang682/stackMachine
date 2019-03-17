package au.com.nab.stackmachine.userenter.operator;

import java.math.BigDecimal;

import au.com.nab.stackmachine.history.record.OperationRecord;
import au.com.nab.stackmachine.storage.Storage;

public class Inv extends UnaryOperator {

	@Override
	protected void performDetailOperation(Storage storage) {
		BigDecimal digit = storage.popDigit();
		BigDecimal result = BigDecimal.ONE.divide(digit);
		storage.pushDigit(result);
		OperationRecord record = getOperationRecord(digit);
		storage.pushOperationRecord(record);
	}

}
