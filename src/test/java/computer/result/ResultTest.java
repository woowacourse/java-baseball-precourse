package computer.result;

import baseball.BaseBall;
import baseball.BaseBalls;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class ResultTest {

    @DisplayName("결과 찾기")
    @Test
    void getResult() {
        BaseBalls baseBalls = new BaseBalls(Arrays.asList(1, 2, 3));

        BaseBall strike = new BaseBall(1, 1);
        BaseBall ball = new BaseBall(2, 3);
        BaseBall nothing = new BaseBall(3, 4);

        assertAll(
                () -> assertThat(Result.getResult(baseBalls, strike)).isEqualTo(Result.STRIKE),
                () -> assertThat(Result.getResult(baseBalls, ball)).isEqualTo(Result.BALL),
                () -> assertThat(Result.getResult(baseBalls, nothing)).isEqualTo(Result.NOTHING)
        );
    }
}