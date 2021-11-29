package baseball;

import java.util.regex.Pattern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import constants.NumberAttribute;
import utils.NumberGenerator;


public class NumberGeneratorTest {

	@Test
	public void generateRandomNumber() {

		final int n = NumberAttribute.DIGIT_NUMBER.getValue();

		String randomNumber = NumberGenerator.generateRandomNumber();
		Assertions.assertEquals(n, randomNumber.length(),
			String.format("길이가 %d인 숫자가 아님", n));

		String pattern = "^[0-9]*$";
		Assertions.assertTrue(Pattern.matches(pattern, randomNumber),
			"1에서 9사이의 정수에 해당하지 않는 수가 포함됨");
	}
}
