package au.com.nab.stackmachine.userenter.factory;

import java.util.Optional;

import org.apache.log4j.Logger;

import au.com.nab.stackmachine.userenter.UserEntry;
import au.com.nab.stackmachine.userenter.enums.OperatorsEnum;
import au.com.nab.stackmachine.userenter.operator.Add;
import au.com.nab.stackmachine.userenter.operator.Clear;
import au.com.nab.stackmachine.userenter.operator.Inv;
import au.com.nab.stackmachine.userenter.operator.Mul;
import au.com.nab.stackmachine.userenter.operator.Neg;
import au.com.nab.stackmachine.userenter.operator.Pop;
import au.com.nab.stackmachine.userenter.operator.Print;
import au.com.nab.stackmachine.userenter.operator.Push;
import au.com.nab.stackmachine.userenter.operator.Quit;
import au.com.nab.stackmachine.userenter.operator.Undo;

public class OperatorFactory {
	
	private static final Logger LOGGER = Logger.getLogger(OperatorFactory.class);

	public static Optional<UserEntry> getOperator(final String userEntered) {
		Optional<UserEntry> userEntry = Optional.empty();
		
		try {
			OperatorsEnum operator = OperatorsEnum.fromString(userEntered);
			switch (operator) {
				case PUSH:
					userEntry = Optional.of(new Push(userEntered));
					break;
				case POP:
					userEntry = Optional.of(new Pop());
					break;
				case CLEAR:
					userEntry = Optional.of(new Clear());
					break;
				case ADD:
					userEntry = Optional.of(new Add());
					break;
				case MUL:
					userEntry = Optional.of(new Mul());
					break;
				case NEG:
					userEntry = Optional.of(new Neg());
					break;
				case INV:
					userEntry = Optional.of(new Inv());
					break;
				case UNDO:
					userEntry = Optional.of(new Undo());
					break;
				case PRINT:
					userEntry = Optional.of(new Print());
					break;
				case QUIT:
					userEntry = Optional.of(new Quit());
			}
		} catch (IllegalArgumentException e) {
			LOGGER.error(e.getMessage(), e);
		}
		
		return userEntry;
	}
	
}
