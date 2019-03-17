package au.com.nab.stackmachine.userenter.operator;

import java.math.BigDecimal;
import java.util.function.Predicate;

import au.com.nab.stackmachine.history.record.OperationRecord;
import au.com.nab.stackmachine.storage.Storage;
import au.com.nab.stackmachine.userenter.UserEntry;

public class Undo implements UserEntry {

	@Override
	public void execute(Storage storage) {
		OperationRecord record = storage.popOperationRecord();
		
		UserEntry operator = record.getOperator();
		if (isNeedClearUpResult().test(operator) 
				&& (!(operator instanceof Pop))) {
			//Pop out the last digit from stack
			//if the last operator is NOT Clear
			storage.popDigit();
		}
		if ((isUnaryOperator().test(operator)) 
			|| (isBiOperator().test(operator))) {
			//Last operation has a BiOperator,
			//Restore those parameters
			for(BigDecimal digit : record.getParameters()) {
				storage.pushDigit(digit);
			}
		}
	}

	/**
	 * This method return true unless the operator is a
	 * Clear class
	 * 
	 * @return true if the opeartor is NOT a Clear class.
	 */
	static Predicate<UserEntry> isNeedClearUpResult() {
		return e -> ((null == e) || (!(e instanceof Clear)));
	}
	
	static Predicate<UserEntry> isBiOperator() {
		return e -> ((null != e) && (e instanceof BiOperator));
	}
	
	static Predicate<UserEntry> isUnaryOperator() {
		return e -> ((null !=e) && (e instanceof UnaryOperator));
	}
}
