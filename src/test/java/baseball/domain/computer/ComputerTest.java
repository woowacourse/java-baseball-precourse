package baseball.domain.computer;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class ComputerTest {

    @RepeatedTest(10)
    @DisplayName("3개의 answer numbers를 가진 Computer를 생성할 수 있다.")
    void createWithAnswerNumbersByRandomGenerater() {
        // when
        Computer result = Computer.createWithAnswerNumbersByRandomGenerator();

        // then
        assertThat(result).isInstanceOf(Computer.class);
    }
}