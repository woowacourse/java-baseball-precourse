package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;

class ApplicationTest extends NsTest {

    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
            () -> {
                run("246", "135", "1", "597", "589", "2");
                assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
            },
            1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 게임종료_검증() {
        assertRandomNumberInRangeTest(
            () -> {
                run("274", "2");
                assertThat(output()).contains("3스트라이크", "게임 종료");
            },
            2, 7, 4
        );
    }

    @Test
    void 게임종료_에러_검증() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> assertRandomNumberInRangeTest(
                () -> {
                    run("274", "3");
                },
                2, 7, 4
            )).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 정답확인_로직_검증() {
        assertRandomNumberInRangeTest(
            () -> {
                Computer computer = new Computer();
                computer.pickUniqueThreeNumbersInRange();
                AnswerChecker answerChecker = new AnswerChecker(computer.convertToList());
                answerChecker.calculateBallOrStrike(new ArrayList<>(Arrays.asList(1, 5, 3)));
                assertThat(answerChecker.getBallCount() == 2);
                assertThat(answerChecker.getStrikeCount() == 1);
            },
            1, 3, 5
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("1234"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_0이_포함된_경우() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("305"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_중복된_값이_포함된_경우() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("466"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[] {});
    }
}
