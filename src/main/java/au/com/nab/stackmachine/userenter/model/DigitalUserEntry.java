package au.com.nab.stackmachine.userenter.model;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import au.com.nab.stackmachine.history.record.OperationRecord;
import au.com.nab.stackmachine.storage.Storage;
import au.com.nab.stackmachine.userenter.UserEntry;

public class DigitalUserEntry implements UserEntry {

	private BigDecimal digits;
	
	public DigitalUserEntry(final String userEntered) {
		this.digits = new BigDecimal(userEntered);
	}
	
	@Override
	public void execute(Storage storage) {
		storage.pushDigit(digits);
		OperationRecord record = toOperationRecord().apply(digits);
		storage.pushOperationRecord(record);
	}

	static Function<BigDecimal, OperationRecord> toOperationRecord() {
		return d -> {List<BigDecimal> params = Arrays.asList(d);
			return new OperationRecord(params, null);
		};
	}

}
