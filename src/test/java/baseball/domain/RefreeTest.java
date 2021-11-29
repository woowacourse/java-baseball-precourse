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

    @BeforeEach
    void setUp() {
        refree = new Refree();
    }

    @Test
    void 쓰리스트라이크_테스트() {
        List<Integer> computerNumbers = Arrays.asList(1, 2, 3);
        List<Integer> playerNumbers = Arrays.asList(1, 2, 3);

        String result = refree.compare(computerNumbers, playerNumbers);

        assertThat(result).isEqualTo(Constant.RESULT_STRIKE);
    }

    @Test
    void 낫싱_테스트() {
        List<Integer> computerNumbers = Arrays.asList(1, 2, 3);
        List<Integer> playerNumbers = Arrays.asList(4, 5, 7);

        String result = refree.compare(computerNumbers, playerNumbers);

        assertThat(result).isEqualTo(Constant.RESULT_NOTHING);
    }

    @Test
    void 볼2_스트라이크1_테스트() {
        List<Integer> computerNumbers = Arrays.asList(1, 2, 3);
        List<Integer> playerNumbers = Arrays.asList(1, 3, 2);

        String result = refree.compare(computerNumbers, playerNumbers);

        assertThat(result).isEqualTo(RESULT_2BALL_1STRIKE);
    }

    @ParameterizedTest
    @CsvSource({"1,3,4,1볼 1스트라이크,3,2,1,3볼"})
    public void compare_여러테스트(int number1, int number2, int number3, String expected) {
        String actual = refree.compare(Arrays.asList(1, 2, 3), Arrays.asList(number1, number2, number3));
        assertThat(expected).isEqualTo(actual);
    }
}
