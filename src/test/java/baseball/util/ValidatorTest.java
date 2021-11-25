package baseball.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidatorTest {
	@Test
	public void isNumeric() throws Exception {
		//then
		assertTrue(Validator.isNumeric("300"));
		assertTrue(Validator.isNumeric("2457"));
		assertFalse(Validator.isNumeric("test"));
		assertFalse(Validator.isNumeric(" "));
	}

	@Test
	public void valid() throws Exception {
		// 1. 지정된 수의 크기에서 벗어날 경우
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
			() -> Validator.valid(new int[] {1, 2, 3, 4}));
		assertEquals("지정된 수의 크기에서 벗어났습니다.", ex.getMessage());

		// 2. 각 자리의 수의 범위에서 벗어난 경우 ( == 0이 포함된 경우 )
		ex = assertThrows(IllegalArgumentException.class, () -> Validator.valid(new int[] {0, 2, 3}));
		assertEquals("입력한 수에 0이 포함되어있습니다.", ex.getMessage());

		// 3.각 자리 수가 중복되는지 확인
		ex = assertThrows(IllegalArgumentException.class, () -> Validator.valid(new int[] {1, 3, 3}));
		assertEquals("중복된 수가 존재합니다.", ex.getMessage());
	}
}
