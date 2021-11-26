package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import constant.Rules;

class RandomNumberGeneratorTest {

	@RepeatedTest(10)
	@Test
	void makeRandomNumber() {
		RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
		randomNumberGenerator.makeRandomNumber();
		Assertions.assertThat(Arrays.stream(randomNumberGenerator.getAnswer()).distinct().count()).isEqualTo(Rules.NUMBER_LENGTH);
	}
}