package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballNumbersTest {

	@Test
	void testBaseballNumbers() {
		assertThatThrownBy(() -> new BaseballNumbers(null))
        .isInstanceOf(NullPointerException.class);
	}
	
	@Test
	void testValidDuplicateBaseballNumbers() {
		assertThatThrownBy(() -> new BaseballNumbers("111"))
        .isInstanceOf(IllegalArgumentException.class);
	}
	
	@Test
	void testvalidLengthBaseballNumbers() {
		assertThatThrownBy(() -> new BaseballNumbers("1234"))
        .isInstanceOf(IllegalArgumentException.class);
	}
	
	@Test
	void testIsStrikeBaseballNumbers() {
		BaseballNumbers baseballNumbers = new BaseballNumbers("123");
		assertThat(baseballNumbers.isStrike(0, new BaseballNumber(1))).isEqualTo(true);
		assertThat(baseballNumbers.isStrike(0, new BaseballNumber(2))).isEqualTo(false);
		assertThat(baseballNumbers.isStrike(1, new BaseballNumber(2))).isEqualTo(true);
		assertThat(baseballNumbers.isStrike(2, new BaseballNumber(3))).isEqualTo(true);
	}
	
	@Test
	void testCountStrikeBaseballNumbers() {
		BaseballNumberRepository baseballNumberRepository = new BaseballNumberRepository();
		List<BaseballNumber> randomNumbers = baseballNumberRepository.randomNumbers();
		BaseballNumbers baseballNumbers = new BaseballNumbers("123");
		System.out.println(randomNumbers);
		int countStrike = baseballNumbers.countStrike(randomNumbers);
		System.out.println(countStrike);
	}
	
	@Test
	void testCoountBallBaseballNumbers() {
		BaseballNumberRepository baseballNumberRepository = new BaseballNumberRepository();
		List<BaseballNumber> randomNumbers = baseballNumberRepository.randomNumbers();
		BaseballNumbers baseballNumbers = new BaseballNumbers("123");
		System.out.println(randomNumbers);
		int countBall = baseballNumbers.countBall(randomNumbers);
		System.out.println(countBall + "��");
	}
	
}
