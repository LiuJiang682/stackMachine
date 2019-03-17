package au.com.nab.stackmachine.userenter.factory;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import au.com.nab.stackmachine.userenter.UserEnter;
import au.com.nab.stackmachine.userenter.UserEntry;
import au.com.nab.stackmachine.userenter.model.DigitalUserEntry;

public class DefaultUserEnterFactory implements UserEnter {

	private static final Logger LOGGER = Logger.getLogger(DefaultUserEnterFactory.class);
	
	private static final String CTRL_C = "\u0003";

	private Scanner scanner;

	public DefaultUserEnterFactory() {
		this(System.in);
	}

	public DefaultUserEnterFactory(InputStream in) {
		this.scanner = new Scanner(in);
	}

	@Override
	public List<UserEntry> getUserInput() {
		List<UserEntry> userEntries = new ArrayList<>();
		// User interactive mode
		System.out.print("> ");
		String userEntered = scanner.nextLine();
		if (CTRL_C.equalsIgnoreCase(userEntered))
			throw new NoSuchElementException("No line found");
		
		if (StringUtils.isNoneBlank(userEntered)) {
			Optional<UserEntry> userEntryOptional = this.constructUserEntry(userEntered);
				if (userEntryOptional.isPresent()) {
					userEntries.add(userEntryOptional.get());
				}

		}
		return userEntries;
	}

	public Optional<UserEntry> constructUserEntry(String userEntered) {
		Optional<UserEntry> userEntry = Optional.empty();
		
		userEntry = getOperatorUserEntry(userEntered);

		return userEntry;
	}

	protected Optional<UserEntry> getOperatorUserEntry(String userEntered) {
		Optional<UserEntry> userEntry = Optional.empty();
		
		try {
			userEntry = OperatorFactory.getOperator(userEntered);
		}
		catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return userEntry;
	}

	protected Optional<UserEntry> getDigitalUserEntry(final String userEntered) {
		Optional<UserEntry> userEntry = Optional.empty();
		
		try {
			userEntry = Optional.of(new DigitalUserEntry(userEntered));
		}
		catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return userEntry;
	}

	public Scanner getScanner() {
		return scanner;
	}

}
