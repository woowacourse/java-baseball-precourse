package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class BaseballNumberRefereeTest {
	BaseballNumberValidator validator;
	BaseballNumberReferee referee;

	@BeforeEach
	void setUp() throws Exception {
		validator = new BaseballNumberValidator();
		referee = new BaseballNumberReferee(validator);
	}

	@ParameterizedTest(name = "입력값 : {0}")
	@ValueSource(strings = {"012", "invalid", "1234", "112"})
	@DisplayName("잘못된 입력값의 경우 예외 발생")
	void judge_wrong_input(String invalidInput) throws Exception {
		assertThrows(IllegalArgumentException.class, () -> referee.judge(invalidInput, "123"));
	}

	@Test
	@DisplayName("낫싱 판단")
	void judge_nothing() throws Exception {
		JudgeResult result = referee.judge("123", "456");
		assertThat(result).isEqualTo(JudgeResult.nothing());
	}

	@ParameterizedTest(name = "입력값 : {0}, 정답 : {1}, 스트라이크 개수 : {2}")
	@DisplayName("스트라이크 판단")
	@CsvSource({"123, 156, 1", "152, 172, 2", "672, 672, 3"})
	void judge_strike(String input, String answer, int numberOfStrike) throws Exception {
	 	JudgeResult result = referee.judge(input, answer);
	 	assertThat(result.getStrike()).isEqualTo(numberOfStrike);
	}

	@ParameterizedTest(name = "입력값 : {0}, 정답 : {1}, 볼 개수 : {2}")
	@DisplayName("볼 판단")
	@CsvSource({"123, 516, 1", "521, 172, 2", "672, 267, 3"})
	void judge_ball(String input, String answer, int numberOfBall) throws Exception {
		JudgeResult result = referee.judge(input, answer);
		assertThat(result.getBall()).isEqualTo(numberOfBall);
	}
}
