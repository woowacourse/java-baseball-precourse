package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

	@Test
	void 게임종료_후_재시작() {
		assertRandomNumberInRangeTest(
			() -> {
				run("246", "135", "1", "597", "589", "2");
				assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
			},
			1, 3, 5, 5, 8, 9
		);
	}

	@Test
	void 예외_테스트() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("1234"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Override
	public void runMain() {
		Application.main(new String[] {});
	}

	@DisplayName("입력한 문자열이 숫자인지 검사")
	@Test
	void stringIsNumber() {
		Application.validateNumbers("123");
		assertThatThrownBy(() -> Application.validateNumbers("a23"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("문자가 숫자인지 검사")
	@Test
	void charIsNumber() {
		Application.validateNumber('1');
		assertThatThrownBy(() -> Application.validateNumber('a'))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("문자열을 숫자 리스트로 변환")
	@Test
	void convertStringToNumberList() {
		assertThat(
			Application.convertStringToNumberList("123")
				.containsAll(Arrays.asList(1, 2, 3))
		).isTrue();
	}
}