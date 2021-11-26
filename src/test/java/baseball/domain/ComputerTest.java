package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import baseball.builder.RandomDigitsBuilder;
import baseball.utils.ValidationUtils;

public class ComputerTest {

	@Test
	void 컴퓨터_수_생성() {
		// given, when
		Computer computer = new Computer(RandomDigitsBuilder.getRandomDigitList());

		// then
		Assertions.assertThat(ValidationUtils.validateRandomDigitsDuplicate(computer.getNumberList())).isTrue();
		Assertions.assertThat(ValidationUtils.validateRandomDigitsLength(computer.getNumberList())).isTrue();
	}
}
