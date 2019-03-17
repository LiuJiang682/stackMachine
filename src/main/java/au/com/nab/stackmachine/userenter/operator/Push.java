package au.com.nab.stackmachine.userenter.operator;

import au.com.nab.stackmachine.storage.Storage;
import au.com.nab.stackmachine.userenter.UserEntry;

public class Push implements UserEntry {

	private final String userEntered;
	
	public Push(final String userEntered) {
		this.userEntered = userEntered;
	}
	
	@Override
	public void execute(Storage storage) {
		

	}

}
