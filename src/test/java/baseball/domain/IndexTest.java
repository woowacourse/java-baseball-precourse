package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class IndexTest {
	@DisplayName("예외발생 테스트")
	@ParameterizedTest
	@ValueSource(ints = {-1, 3})
	void checkValid(int idx) {
		assertThatThrownBy(() -> new Index(idx)).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("통과 테스트")
	@ParameterizedTest
	@ValueSource(ints = {0, 2})
	void passTest(int idx) {
		Index myIdx = new Index(idx);
	}
}
