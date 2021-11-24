package baseball;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseballNumberGeneratorTest {
	@Test
	@DisplayName("숫자를 생성할 때 숫자 검증기를 사용해야 한다.")
	void generate_number_using_validator() {
		BaseballNumberValidator validator = mock(BaseballNumberValidator.class);
		when(validator.validate(anyString())).thenReturn(true);
		BaseballNumberGenerator generator = new BaseballNumberGenerator(validator);

		generator.generate();

		then(validator).should().validate(anyString());
	}

	@Test
	@DisplayName("숫자를 생성할 때 숫자 검증기를 통과하지 못하면 숫자를 다시 생성해야 한다.")
	void regenerate_number_when_fail_to_validate() {
		BaseballNumberValidator validator = mock(BaseballNumberValidator.class);
		when(validator.validate(anyString()))
			.thenReturn(false)
			.thenReturn(false)
			.thenReturn(true);
		BaseballNumberGenerator generator = new BaseballNumberGenerator(validator);

		generator.generate();

		then(validator).should(times(3)).validate(anyString());
	}
}
