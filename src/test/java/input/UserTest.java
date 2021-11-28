package input;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;

//TDD
class UserTest extends NsTest {

	@Test
	void 사용자_입력_테스트() {
		// given
		User user = new User();
		// when
		String userInput = "111";
		// then
		user.checkException(userInput);
	}

	@Override
	protected void runMain() {
		Application.main(new String[] {});
	}

	@Test
	void 예외_테스트_입력크기() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("12"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 예외_테스트_잘못된값() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("1a0"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

}