package au.com.nab.stackmachine.userenter.enums;

import org.apache.commons.lang3.StringUtils;

import au.com.nab.stackmachine.constants.Constants.Numerice;
import au.com.nab.stackmachine.constants.Constants.Strings;

public enum OperatorsEnum {

	PUSH,
	POP,
	CLEAR,
	ADD,
	MUL,
	NEG,
	INV,
	UNDO,
	PRINT,
	QUIT;
	
	public static OperatorsEnum fromString(final String userEntered) {
		String operator = userEntered;
		if ((StringUtils.isNotBlank(userEntered))
			&& (userEntered.contains(Strings.SPACE))) {
			operator = userEntered.split(Strings.SPACE)[Numerice.ZERO];
		}
		
		for(OperatorsEnum e : OperatorsEnum.values()) {
			if (e.name().equalsIgnoreCase(operator)) {
				return e;
			}
		}
		
		throw new IllegalArgumentException("Unknow String: " + userEntered);
	}
}
