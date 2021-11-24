package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import baseball.utils.ValidationUtils;
import camp.nextstep.edu.missionutils.Randoms;

public class ComputerTest {

	@Test
	void 컴퓨터_수_생성() {
		// given, when
		Computer computer = new Computer();

		// then
		Assertions.assertThat(ValidationUtils.validateRandomDigits(computer.getNumberList())).isTrue();
		Assertions.assertThat(ValidationUtils.validateRandomDigitsLength(computer.getNumberList())).isTrue();
	}
}
