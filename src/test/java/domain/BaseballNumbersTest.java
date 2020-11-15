package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballNumbersTest {

	@Test
	@DisplayName("null체크")
	void testBaseballNumbers() {
		assertThatThrownBy(() -> new BaseballNumbers(null))
        .isInstanceOf(NullPointerException.class);
	}
	
	@Test
	@DisplayName("숫자 체크")
	void testvalidNumberBaseballNumbers() {
		assertThatThrownBy(() -> new BaseballNumbers("123ff"))
        .isInstanceOf(IllegalArgumentException.class);
	}
	
	@Test
	@DisplayName("정수 체크")
	void testvalidIntegerBaseballNumbers() {
		assertThatThrownBy(() -> new BaseballNumbers("123.111"))
        .isInstanceOf(IllegalArgumentException.class);
	}
	
	@Test
	@DisplayName("자리수 체크")
	void testvalidLengthBaseballNumbers() {
		assertThatThrownBy(() -> new BaseballNumbers("1234"))
        .isInstanceOf(IllegalArgumentException.class);
	}
	
	@Test
	@DisplayName("스트라이크여부 확인")
	void testIsStrikeBaseballNumbers() {
		BaseballNumbers baseballNumbers = new BaseballNumbers("123");
		assertThat(baseballNumbers.isStrike(0, new BaseballNumber(1))).isEqualTo(true);
		assertThat(baseballNumbers.isStrike(0, new BaseballNumber(2))).isEqualTo(false);
		assertThat(baseballNumbers.isStrike(1, new BaseballNumber(2))).isEqualTo(true);
		assertThat(baseballNumbers.isStrike(2, new BaseballNumber(3))).isEqualTo(true);
	}
	
	@Test
	@DisplayName("스트라이크여부 확인")
	void tesCountStrikeBaseballNumbers() {
		BaseballNumberRepository baseballNumberRepository = new BaseballNumberRepository();
		List<BaseballNumber> randomNumbers = baseballNumberRepository.randomNumbers();
		BaseballNumbers baseballNumbers = new BaseballNumbers("123");
		System.out.println(randomNumbers);
		int countStrike = baseballNumbers.countStrike(randomNumbers);
		System.out.println(countStrike);
	}
}
