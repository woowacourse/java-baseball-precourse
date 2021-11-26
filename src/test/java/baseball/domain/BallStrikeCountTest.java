package baseball.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import baseball.domain.vo.number.Number;

public class BallStrikeCountTest {

    @ParameterizedTest
    @CsvSource(
        {"123,456,낫싱", "123,123,3스트라이크", "123,312,3볼", "123,132,2볼 1스트라이크"}
    )
    void test(String number1, String number2, String expected) {
        // given
        Number given1 = new Number(number1);
        Number given2 = new Number(number2);

        // when
        String actual = given1.compare(given2).toString();

        // then
        assertEquals(expected, actual);
    }

}
