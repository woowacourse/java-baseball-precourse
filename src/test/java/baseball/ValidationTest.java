package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationTest {

	@Test
	void checkShortLength() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
			() -> Validation.checkInput("12"));
		String message = exception.getMessage();
		assertEquals(Message.ERROR_INPUT_LENGTH, message);
	}

	@Test
	void checkLongLength() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
			() -> Validation.checkInput("1234"));
		String message = exception.getMessage();
		assertEquals(Message.ERROR_INPUT_LENGTH, message);
	}

	@Test
	void checkInteger() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
			() -> Validation.checkInput("12a"));
		String message = exception.getMessage();
		assertEquals(Message.ERROR_INPUT_TYPE, message);
	}

	@Test
	void checkDuplicate() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
			() -> Validation.checkInput("111"));
		String message = exception.getMessage();
		assertEquals(Message.ERROR_INPUT_DUPLICATE, message);
	}

}