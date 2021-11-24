package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BallTest {
	@DisplayName("스트라이크 테스트")
	@ParameterizedTest
	@CsvSource(value = {"0:1", "2:9"}, delimiter = ':')
	void testStrike(int index, int no) {
		Ball myBall = Ball.of(index, no);
		Ball comBall = Ball.of(index, no);
		assertThat(myBall.compare(comBall).isStrike()).isTrue();
	}

	@DisplayName("볼 테스트")
	@ParameterizedTest
	@CsvSource(value = {"0:1:1:1", "2:9:0:9"}, delimiter = ':')
	void testBall(int myIdx, int myNo, int comIdx, int comNo) {
		Ball myBall = Ball.of(myIdx, myNo);
		Ball comBall = Ball.of(comIdx, comNo);
		assertThat(myBall.compare(comBall).isBall()).isTrue();
	}

	@DisplayName("낫싱 테스트")
	@ParameterizedTest
	@CsvSource(value = {"0:1:0:2", "2:9:2:1", "1:2:2:3"}, delimiter = ':')
	void testNothing(int myIdx, int myNo, int comIdx, int comNo) {
		Ball myBall = Ball.of(myIdx, myNo);
		Ball comBall = Ball.of(comIdx, comNo);
		assertThat(myBall.compare(comBall)).isEqualTo(Score.NOTHING);
	}
}
