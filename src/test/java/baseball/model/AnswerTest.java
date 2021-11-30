package baseball.model;


import baseball.vo.ResultBall;
import baseball.vo.UserBall;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class AnswerTest {

    private static final int INDEX_OF_BALL = 0;
    private static final int INDEX_OF_STRIKE = 1;

    static Stream<Arguments> judgeTest() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3), new UserBall(Arrays.asList(4, 5, 6)), Arrays.asList(0, 0)),
                Arguments.of(Arrays.asList(1, 2, 3), new UserBall(Arrays.asList(1, 2, 3)), Arrays.asList(0, 3)),
                Arguments.of(Arrays.asList(1, 2, 3), new UserBall(Arrays.asList(1, 3, 4)), Arrays.asList(1, 1))
        );
    }

    @ParameterizedTest
    @MethodSource(value = "judgeTest")
    @DisplayName("볼, 스트라이크 판정 테스트")
    public void getResultBallByUserBall(List<Integer> answerList, UserBall userBall, List<Integer> expected) {
        Answer answer = new Answer(answerList);
        ResultBall resultBallByUserBall = answer.getResultBallByUserBall(userBall);
        Assertions.assertThat(resultBallByUserBall.getBall()).isEqualTo(expected.get(INDEX_OF_BALL));
        Assertions.assertThat(resultBallByUserBall.getStrike()).isEqualTo(expected.get(INDEX_OF_STRIKE));
    }

}
