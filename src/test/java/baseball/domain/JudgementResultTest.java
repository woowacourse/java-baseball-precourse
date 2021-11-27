package baseball.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import baseball.domain.vo.JudgementResult;

public class JudgementResultTest {

    @ParameterizedTest
    @CsvSource(
        {"0,0,낫싱", "0,3,3스트라이크", "3,0,3볼", "2,1,2볼 1스트라이크"}
    )
    void test(int ballCount, int strikeCount, String expected) {
        // given
        JudgementResult given = new JudgementResult(ballCount, strikeCount);

        // when
        String actual = given.toString();

        // then
        assertEquals(expected, actual);
    }

}
