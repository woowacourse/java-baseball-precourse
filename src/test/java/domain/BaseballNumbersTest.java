package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballNumbersTest {

	@Test
	@DisplayName("null체크")
	void testBaseballNumbers() {
		assertThatThrownBy(() -> new BaseballNumbers(null))
        .isInstanceOf(NullPointerException.class);
	}
	
	@Test
	@DisplayName("숫자 체크")
	void testvalidNumberBaseballNumbers() {
		assertThatThrownBy(() -> new BaseballNumbers("123ff"))
        .isInstanceOf(IllegalArgumentException.class);
	}
	
	@Test
	@DisplayName("정수 체크")
	void testvalidIntegerBaseballNumbers() {
		assertThatThrownBy(() -> new BaseballNumbers("123.111"))
        .isInstanceOf(IllegalArgumentException.class);
	}
	
	@Test
	@DisplayName("자리수 체크")
	void testvalidLengthBaseballNumbers() {
		assertThatThrownBy(() -> new BaseballNumbers("1234"))
        .isInstanceOf(IllegalArgumentException.class);
	}

}
