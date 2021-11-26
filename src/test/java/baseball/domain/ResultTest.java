package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ResultTest {
	Balls myBalls;
	Balls comBalls;
	Result result;

	@BeforeEach
	void setUp() {
		myBalls = Balls.from("123");
	}

	@DisplayName("결과를 문자열로 반환 테스트")
	@ParameterizedTest
	@CsvSource(value = {"123:3스트라이크", "124:2스트라이크", "145:1스트라이크", "312:3볼", "319:2볼", "378:1볼",
		"132:2볼 1스트라이크", "139:1볼 1스트라이크", "456:낫싱"}, delimiter = ':')
	void report(String comValue, String expected) {
		comBalls = Balls.from(comValue);
		result = myBalls.compare(comBalls);
		assertThat(result.report()).isEqualTo(expected);
	}
}
