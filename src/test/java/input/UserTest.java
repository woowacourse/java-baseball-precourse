package input;

import org.junit.jupiter.api.Test;

//TDD
class UserTest {

	@Test
	void 사용자_입력_테스트() {
		// given
		User user = new User();
		// when
		String userInput = "111";
		// then
		user.checkException(userInput);
	}

	@Test
	void 사용자_입력_테스트_크기() {
		// given
		User user = new User();
		// when
		String userInput = "11234";
		// then
		user.checkException(userInput);
	}

	@Test
	void 사용자_입력_테스트_범위() {
		// given
		User user = new User();
		// when
		String userInput = "1a0";
		// then
		user.checkException(userInput);
	}
}