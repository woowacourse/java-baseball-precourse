package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BaseballNumberRefereeTest {
	@ParameterizedTest(name = "입력값 : {0}")
	@ValueSource(strings = {"012", "invalid", "1234", "112"})
	@DisplayName("잘못된 입력값의 경우 예외 발생")
	void judge_wrong_input(String invalidInput) throws Exception {
		BaseballNumberReferee referee = new BaseballNumberReferee(new BaseballNumberValidator());
		assertThrows(IllegalArgumentException.class, () -> referee.judge(invalidInput, "123"));
	}

	@Test
	@DisplayName("낫싱 판단")
	void judge_nothing() throws Exception {
		BaseballNumberReferee referee = new BaseballNumberReferee(new BaseballNumberValidator());
		JudgeResult result = referee.judge("123", "456");
		assertThat(result.getStrike()).isEqualTo(0);
		assertThat(result.getBall()).isEqualTo(0);
	}
}
