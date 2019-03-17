package au.com.nab.stackmachine.userenter.operator;

import au.com.nab.stackmachine.storage.Storage;
import au.com.nab.stackmachine.userenter.UserEntry;

public class Inv implements UserEntry {

////	@Override
//	protected void performDetailOperation(Storage storage) {
//		BigDecimal first = storage.popDigit();
//		//Handle Divisor is ZERO
//		if (BigDecimal.ZERO.equals(first)) {
//			storage.pushDigit(first);
//			System.err.println("Divisor cannot be ZERO!");
//			return;
//		}
//		BigDecimal second = storage.popDigit();
//		BigDecimal total = second.divide(first, UserEntry.DECIMAL_PLACES, BigDecimal.ROUND_DOWN);
//		storage.pushDigit(total);
//		OperationRecord record = this.getOperationRecord(first, second);
//		storage.pushOperationRecord(record);
//	}

	@Override
	public void execute(Storage storage) {
		// TODO Auto-generated method stub
		
	}

}
