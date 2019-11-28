package baseball.generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class ManualBallGeneratorTest {

    @DisplayName("수동 공 번호 생성기")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void getNumber(int number) {
        BallGenerator ballGenerator = new ManualBallGenerator();

        assertThat(ballGenerator.getNumber(number)).isEqualTo(number);
    }

}