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
	void 예외_테스트() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("1234"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 예외_테스트_범위바깥() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("000"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 타겟넘버_생성_테스트() {
		Target target = new Target();
		Target compare = new Target();
		target.generateTargetNumber();

		for (int i = 0; i < 10; i++) {
			compare.generateTargetNumber();
			assertThat(target.isEqual(compare));
		}
	}

	@Test
	void 타켓넘버_종합_테스트(){
		Target target = new Target();

		for (int i = 0; i < 10; i++){
			target.printTargetNumber();
			targetNumber_generation_test(target);
			targetNumber_compare_test(target);
			target.generateTargetNumber();
		}
	}

	void targetNumber_generation_test(Target target) {
		boolean[] visited = new boolean[target.getRangeEnd() - target.getRangeBegin() + 1];

		int count = 0;
		for (int i = 0; i < visited.length; i++) {
			if (visited[i] = true) {
				continue;
			}
			if (target.isContained((char)(i + target.getRangeBegin() + '0')) > -1) {
				visited[i + target.getRangeBegin()] = true;
				count++;
			}
		}
		assertThat(count == target.getLength());
	}

	void targetNumber_compare_test(Target target) {
		int countBallAndStrike = 0;

		for (int i = target.getRangeBegin(); i < target.getRangeEnd(); i++) {
			String compare = "";
			for (int j = 0; j < target.getLength(); j++) {
				compare += (char)(1 + '0');
			}

			int[] ballsAndStrikes = target.compareWith(compare);
			if (ballsAndStrikes[0] != 0 || ballsAndStrikes[1] != 0) {
				countBallAndStrike++;
			}
		}
		assertThat(countBallAndStrike == target.getLength());
	}

	@Override
	public void runMain() {
		Application.main(new String[] {});
	}
}
