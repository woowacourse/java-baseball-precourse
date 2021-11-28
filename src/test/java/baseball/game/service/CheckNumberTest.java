package baseball.game.service;

import static baseball.game.service.CheckNumber.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CheckNumberTest {

	@Test
	public void 숫자비교_정답테스트() throws Exception {
		assertThat(checkInputNumber(123, 456)).isEqualTo("낫싱");
		assertThat(checkInputNumber(123, 156)).isEqualTo("1스트라이크");
		assertThat(checkInputNumber(123, 416)).isEqualTo("1볼");
		assertThat(checkInputNumber(123, 312)).isEqualTo("3볼");
		assertThat(checkInputNumber(123, 123)).isEqualTo(
			"3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		assertThat(checkInputNumber(123, 321)).isEqualTo("2볼 1스트라이크");
	}
}
