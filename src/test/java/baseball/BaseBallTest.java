package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BaseBallTest {

    @DisplayName("야구공 생성")
    @ParameterizedTest
    @CsvSource(value = {"1,1", "2,9"})
    void test1(int position, int number) {
        BaseBall baseBall = new BaseBall(position, number);

        assertThat(baseBall).isEqualTo(new BaseBall(position, number));
    }

    @DisplayName("다른 위치인지 판단하기")
    @ParameterizedTest
    @CsvSource(value = {"1,1,false", "1,2,true"})
    void isNotEqualPosition(int position, int compare, boolean answer) {
        BaseBall baseBall = new BaseBall(position, 1);
        BaseBall compareBall = new BaseBall(compare, 1);

        assertThat(baseBall.isNotEqualPosition(compareBall)).isEqualTo(answer);
    }

    @DisplayName("같은 번호인지 판단하기")
    @ParameterizedTest
    @CsvSource(value = {"1,1,true", "1,2,false"})
    void isEqualNumber(int number, int compare, boolean answer) {
        BaseBall baseBall = new BaseBall(1, number);
        BaseBall compareBall = new BaseBall(1, compare);

        assertThat(baseBall.isEqualNumber(compareBall)).isEqualTo(answer);
    }
}
