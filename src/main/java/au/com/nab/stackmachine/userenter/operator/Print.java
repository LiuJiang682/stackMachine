package au.com.nab.stackmachine.userenter.operator;

import au.com.nab.stackmachine.storage.Storage;
import au.com.nab.stackmachine.userenter.UserEntry;

public class Print implements UserEntry {

	@Override
	public void execute(Storage storage) {
		storage.printStack();
	}

}
