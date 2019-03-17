package au.com.nab.stackmachine.userenter.operator;

import au.com.nab.stackmachine.constants.Constants.Numerice;
import au.com.nab.stackmachine.storage.Storage;
import au.com.nab.stackmachine.userenter.UserEntry;

public class Quit implements UserEntry {

	@Override
	public void execute(Storage storage) {
		System.exit(Numerice.ZERO);
	}

}
