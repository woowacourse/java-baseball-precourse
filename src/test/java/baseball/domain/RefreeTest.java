package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import baseball.utils.Constant;

class RefreeTest {
	public static final String RESULT_2BALL_1STRIKE = "2볼 1스트라이크";
	Refree refree;
	List<Integer> computerNumbers = Arrays.asList(1, 2, 3);

	@BeforeEach
	void setUp() {
		refree = new Refree();
	}

	@Test
	void compare_쓰리스트라이크_테스트() {
		List<Integer> playerNumbers = Arrays.asList(1, 2, 3);

		String result = refree.compare(computerNumbers, playerNumbers);

		assertThat(result).isEqualTo(Constant.RESULT_STRIKE);
	}

	@Test
	void compare_낫싱_테스트() {
		List<Integer> playerNumbers = Arrays.asList(4, 5, 7);

		String result = refree.compare(computerNumbers, playerNumbers);

		assertThat(result).isEqualTo(Constant.RESULT_NOTHING);
	}

	@Test
	void compare_볼2_스트라이크1_테스트() {
		List<Integer> playerNumbers = Arrays.asList(1, 3, 2);

		String result = refree.compare(computerNumbers, playerNumbers);

		assertThat(result).isEqualTo(RESULT_2BALL_1STRIKE);
	}

	@ParameterizedTest
	@CsvSource({"1,3,4,1볼 1스트라이크", "3,2,1,2볼", "4,5,6,낫싱"})
	public void compare_여러테스트(int number1, int number2, int number3, String expected) {
		String actual = refree.compare(computerNumbers, Arrays.asList(number1, number2, number3));

		assertThat(actual).isEqualTo(expected);
	}
}
