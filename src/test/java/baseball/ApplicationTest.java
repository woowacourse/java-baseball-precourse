package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;

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
	void 게임종료_후_재시작2() {
		assertRandomNumberInRangeTest(
			() -> {
				run("456", "516", "512", "312", "135", "213", "156", "126", "123", "1", "567", "2");
				assertThat(output()).contains(
					"낫싱", "1볼", "2볼", "3볼", "1볼 1스트라이크", "2볼 1스트라이크",
					"1스트라이크", "2스트라이크", "3스트라이크", "게임 종료");
			},
			1, 2, 3, 5, 6, 7
		);
	}

	@Test
	void 예외_테스트() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("1234"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 예외_테스트2_0입력불가() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("012"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Override
	public void runMain() {
		Application.main(new String[] {});
	}
}
