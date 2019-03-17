package au.com.nab.stackmachine.userenter.operator;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import au.com.nab.stackmachine.constants.Constants.Numerice;
import au.com.nab.stackmachine.constants.Constants.Strings;
import au.com.nab.stackmachine.history.record.OperationRecord;
import au.com.nab.stackmachine.storage.Storage;
import au.com.nab.stackmachine.userenter.UserEntry;

public class Push implements UserEntry {

	private final String userEntered;
	
	public Push(final String userEntered) {
		if (StringUtils.isBlank(userEntered)) {
			throw new IllegalArgumentException("Parameter userEntered cannot be null or empty for Push!");
		}
		this.userEntered = userEntered;
	}

	@Override
	public void execute(Storage storage) {
		String[] userEnteredArray = userEntered.split(Strings.SPACE);
		if (Numerice.TWO == userEnteredArray.length) {
			String number = userEnteredArray[Numerice.ONE];
			if (NumberUtils.isParsable(number)) {
				BigDecimal digits = new BigDecimal(number);
				storage.pushDigit(digits);
				OperationRecord record = this.getOperationRecord(digits);
				storage.pushOperationRecord(record);
			} 
			else {
				throw new IllegalArgumentException("Invalid user enter: " + userEntered);
			}
		} 
		else {
			throw new IllegalArgumentException("Invalid user enter: " + userEntered);
		}
	}
	
	protected OperationRecord getOperationRecord(BigDecimal digit) {
		List<BigDecimal> params = Arrays.asList(digit);
		return new OperationRecord(params, this);
	}
}
