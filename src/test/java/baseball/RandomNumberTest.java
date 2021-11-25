package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberTest {
	@Test
	@DisplayName("RandomNumber 인스턴스에 3자리 난수가 스트링을 생성됬는지 확인")
	void getThreeDigitsNumberAsString() {
		final RandomNumber randomNumber = new RandomNumber();

		Assertions.assertFalse(randomNumber.getRandomNumber().isEmpty());
		Assertions.assertEquals(randomNumber.getRandomNumber().length(), 3);
	}

}
