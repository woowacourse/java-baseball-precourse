package baseball.domain;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import baseball.utils.ConversionUtils;

class PlayerTest {

	@Test
	void 사용자_수_입력() {
		// given, when
		Player player = new Player();
		String userInputNumber = "123";
		List<Integer> userInputNumberList = ConversionUtils.userInputStringToIntegerList(userInputNumber);
		player.setNumberList(userInputNumberList);

		// then
		Assertions.assertThat(player.getNumberList()).isEqualTo(Arrays.asList(1, 2, 3));
	}

}