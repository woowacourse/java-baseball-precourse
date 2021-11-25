package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BallsTest {

	@Test
	void 사용자_세자릿수_입력() {
		Balls balls = new Balls("123");
		assertThat(balls.isSame(Arrays.asList(1, 2, 3))).isTrue();
	}

	@ParameterizedTest
	@ValueSource(strings = {"12가", "12", "1234", "122", "102"})
	void 예외처리(String input) {
		assertThatThrownBy(() -> new Balls(input))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
