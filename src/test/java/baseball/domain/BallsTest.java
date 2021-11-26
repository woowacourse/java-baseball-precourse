package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class BallsTest {
	@DisplayName("유효성검사 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"", "12", "1234", "999", "113"})
	void checkValid(String value) {
		assertThatThrownBy(() -> Balls.of(value)).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("3스트라이크")
	@ParameterizedTest
	@ValueSource(strings = {"123", "789", "321", "987"})
	void threeStrike(String value) {
		Balls myBalls = Balls.of(value);
		Balls comBalls = Balls.of(value);
		Result result = myBalls.compare(comBalls);
		assertThat(result.getStrikeCount()).isEqualTo(3);
	}

	@DisplayName("2스트라이크")
	@ParameterizedTest
	@CsvSource(value = {"123:124", "789:781"}, delimiter = ':')
	void twoStrike(String myValue, String comValue) {
		Balls myBalls = Balls.of(myValue);
		Balls comBalls = Balls.of(comValue);
		Result result = myBalls.compare(comBalls);
		assertThat(result.getStrikeCount()).isEqualTo(2);
	}

	@DisplayName("1스트라이크")
	@ParameterizedTest
	@CsvSource(value = {"123:145", "789:712"}, delimiter = ':')
	void oneStrike(String myValue, String comValue) {
		Balls myBalls = Balls.of(myValue);
		Balls comBalls = Balls.of(comValue);
		Result result = myBalls.compare(comBalls);
		assertThat(result.getStrikeCount()).isEqualTo(1);
	}

	@DisplayName("3볼")
	@ParameterizedTest
	@CsvSource(value = {"123:231", "789:978", "456:645"}, delimiter = ':')
	void threeBall(String myValue, String comValue) {
		Balls myBalls = Balls.of(myValue);
		Balls comBalls = Balls.of(comValue);
		Result result = myBalls.compare(comBalls);
		assertThat(result.getBallCount()).isEqualTo(3);
	}

	@DisplayName("2볼")
	@ParameterizedTest
	@CsvSource(value = {"123:319", "789:971"}, delimiter = ':')
	void twoBall(String myValue, String comValue) {
		Balls myBalls = Balls.of(myValue);
		Balls comBalls = Balls.of(comValue);
		Result result = myBalls.compare(comBalls);
		assertThat(result.getBallCount()).isEqualTo(2);
	}

	@DisplayName("1볼")
	@ParameterizedTest
	@CsvSource(value = {"123:981", "789:912"}, delimiter = ':')
	void oneBall(String myValue, String comValue) {
		Balls myBalls = Balls.of(myValue);
		Balls comBalls = Balls.of(comValue);
		Result result = myBalls.compare(comBalls);
		assertThat(result.getBallCount()).isEqualTo(1);
	}

	@DisplayName("낫싱")
	@ParameterizedTest
	@CsvSource(value = {"123:456", "789:345"}, delimiter = ':')
	void nothing(String myValue, String comValue) {
		Balls myBalls = Balls.of(myValue);
		Balls comBalls = Balls.of(comValue);
		Result result = myBalls.compare(comBalls);
		assertThat(result.getStrikeCount()).isEqualTo(0);
		assertThat(result.getBallCount()).isEqualTo(0);
	}

	@DisplayName("1스트라이크 1볼")
	@ParameterizedTest
	@CsvSource(value = {"123:136", "789:791"}, delimiter = ':')
	void oneStrikeOneBall(String myValue, String comValue) {
		Balls myBalls = Balls.of(myValue);
		Balls comBalls = Balls.of(comValue);
		Result result = myBalls.compare(comBalls);
		assertThat(result.getStrikeCount()).isEqualTo(1);
		assertThat(result.getBallCount()).isEqualTo(1);
	}

	@DisplayName("1스트라이크 2볼")
	@ParameterizedTest
	@CsvSource(value = {"123:132", "789:798"}, delimiter = ':')
	void oneStrikeTwoBall(String myValue, String comValue) {
		Balls myBalls = Balls.of(myValue);
		Balls comBalls = Balls.of(comValue);
		Result result = myBalls.compare(comBalls);
		assertThat(result.getStrikeCount()).isEqualTo(1);
		assertThat(result.getBallCount()).isEqualTo(2);
	}
}
