package au.com.nab.stackmachine.userenter.operator;

import java.math.BigDecimal;

import au.com.nab.stackmachine.history.record.OperationRecord;
import au.com.nab.stackmachine.storage.Storage;

public class Pop extends UnaryOperator {

	@Override
	protected void performDetailOperation(Storage storage) {
		BigDecimal digits = storage.popDigit();
		OperationRecord record = this.getOperationRecord(digits);
		storage.pushOperationRecord(record);
	}

}
