package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NoTest {
	@DisplayName("예외발생 테스트")
	@ParameterizedTest
	@ValueSource(ints = {0, 10})
	void checkValid(int no) {
		assertThatThrownBy(() -> new No(no)).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("통과 테스트")
	@ParameterizedTest
	@ValueSource(ints = {1, 9})
	void passTest(int no) {
		No myNo = new No(no);
	}
}
