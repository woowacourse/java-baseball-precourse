package baseball.game.service;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class NumberCreationTest {

	@Test
	public void 난수_검증() {
		for (int i = 0; i < 10000; i++) {
			int randomNumber = NumberCreation.createRandomNumber();
			assertThat(String.valueOf(randomNumber)).doesNotContain("0");
			assertThat(Arrays.stream(String.valueOf(randomNumber)
					.split(""))
				.distinct()
				.count())
				.isEqualTo(3);
		}
	}
}
