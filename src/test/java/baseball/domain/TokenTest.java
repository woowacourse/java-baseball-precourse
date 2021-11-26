package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TokenTest {
	@DisplayName("예외발생 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"", " ", "0", "123", "-", "11", "22"})
	void exceptionTest(String value) {
		assertThatThrownBy(() -> Token.from(value)).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("패스 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"1", "2"})
	void passTest(String value) {
		Token token = Token.from(value);
	}
}
