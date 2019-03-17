package au.com.nab.stackmachine.userenter;

import au.com.nab.stackmachine.storage.Storage;

public interface UserEntry {

	public int DECIMAL_PLACES = 15;

	void execute(Storage storage);
}
