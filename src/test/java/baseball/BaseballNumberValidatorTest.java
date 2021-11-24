package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class BaseballNumberValidatorTest {
	BaseballNumberValidator validator;

	@BeforeEach
	void setUp() throws Exception {
		validator = new BaseballNumberValidator();
	}

	@ParameterizedTest(name = "숫자 : {0}")
	@ValueSource(strings = {"123", "234", "523", "374", "914"})
	@DisplayName("중복 없는 숫자값 테스트")
	void validate_correct_number(String number) {
		assertThat(validator.validate(number)).isTrue();
	}

	@ParameterizedTest(name = "숫자 : {0}")
	@ValueSource(strings = {"112", "141", "144", "999"})
	@DisplayName("중복 있는 숫자값 테스트")
	void validate_duplicate_number(String number) {
		assertThat(validator.validate(number)).isFalse();
	}

	@ParameterizedTest(name = "숫자 : {0}")
	@ValueSource(strings = {"1234", "12"})
	@DisplayName("잘못된 길이의 숫자 테스트")
	void validate_wrong_length_number(String number) {
		assertThat(validator.validate(number)).isFalse();
	}

	@ParameterizedTest(name = "입력값 : {0}")
	@ValueSource(strings = {"012", "number", "!@#"})
	@DisplayName("잘못된 문자의 입력값 테스트")
	void validate_invalid_character_number(String number) {
		assertThat(validator.validate(number)).isFalse();
	}
}
