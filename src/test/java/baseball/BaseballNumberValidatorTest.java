package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BaseballNumberValidatorTest {
	@ParameterizedTest(name = "숫자 : {0}")
	@ValueSource(strings = {"123", "234", "523", "374", "914"})
	@DisplayName("중복 없는 숫자값 테스트")
	void validate_correct_number(String number) {
		BaseballNumberValidator validator = new BaseballNumberValidator();
		assertThat(validator.validate(number)).isTrue();
	}

	@ParameterizedTest(name = "숫자 : {0}")
	@ValueSource(strings = {"112", "141", "144", "999"})
	@DisplayName("중복 있는 숫자값 테스트")
	void validate_duplicate_number(String number) {
		BaseballNumberValidator validator = new BaseballNumberValidator();
		assertThat(validator.validate(number)).isFalse();
	}
}
