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
}
