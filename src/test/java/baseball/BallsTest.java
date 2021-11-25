package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class BallsTest {

	@Test
	void 사용자_세자릿수_입력() {
		Balls balls = new Balls("123");
		assertThat(balls.isSame(Arrays.asList(1, 2, 3))).isTrue();
	}

	@Test
	void 예외_문자_입력() {
		assertThatThrownBy(() -> new Balls("12가"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 예외_두자릿수_네자릿수_입력() {
		assertThatThrownBy(() -> new Balls("12"))
			.isInstanceOf(IllegalArgumentException.class);

		assertThatThrownBy(() -> new Balls("1234"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 예외_자릿수가_중복() {
		assertThatThrownBy(() -> new Balls("122"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 예외_자릿수에_0포함() {
		assertThatThrownBy(() -> new Balls("102"))
			.isInstanceOf(IllegalArgumentException.class);
	}

}
