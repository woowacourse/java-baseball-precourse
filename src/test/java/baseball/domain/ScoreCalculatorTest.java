package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ScoreCalculatorTest {
    @Test
    public void 쓰리_스트라이크_확인() {
        //given
        List<Integer> answerNumber = Arrays.asList(1, 2, 3);
        List<Integer> userNumber = Arrays.asList(1, 2, 3);

        BaseballNumber answerBaseballNumber = BaseballNumberCreator.createBaseballNumber(answerNumber);
        BaseballNumber userBaseballNumber = BaseballNumberCreator.createBaseballNumber(userNumber);

        //when
        Score score = ScoreCalculator.calculateScore(answerBaseballNumber, userBaseballNumber);

        //then
        assertThat(score.getStrike()).isEqualTo(3);
    }

    @Test
    public void 원볼_원스트라이크_확인() {
        //given
        List<Integer> answerNumber = Arrays.asList(1, 2, 3);
        List<Integer> userNumber = Arrays.asList(1, 3, 4);

        BaseballNumber answerBaseballNumber = BaseballNumberCreator.createBaseballNumber(answerNumber);
        BaseballNumber userBaseballNumber = BaseballNumberCreator.createBaseballNumber(userNumber);

        //when
        Score score = ScoreCalculator.calculateScore(answerBaseballNumber, userBaseballNumber);

        //then
        assertThat(score.getStrike()).isEqualTo(1);
        assertThat(score.getBall()).isEqualTo(1);
    }

    @Test
    public void 낫싱_확인() {
        //given
        List<Integer> answerNumber = Arrays.asList(1, 2, 3);
        List<Integer> userNumber = Arrays.asList(4, 5, 6);

        BaseballNumber answerBaseballNumber = BaseballNumberCreator.createBaseballNumber(answerNumber);
        BaseballNumber userBaseballNumber = BaseballNumberCreator.createBaseballNumber(userNumber);

        //when
        Score score = ScoreCalculator.calculateScore(answerBaseballNumber, userBaseballNumber);

        //then
        assertThat(score.isNothing()).isTrue();
    }
}