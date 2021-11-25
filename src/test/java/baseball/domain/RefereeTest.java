package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RefereeTest {

    private Referee referee;
    private List<Integer> answer;

    @BeforeEach
    void setUp() {
        referee = new Referee();
        answer = Arrays.asList(1, 2, 3);
    }

    @Test
    void judge_result_when_only_strike() {
        //given
        List<Integer> guess = Arrays.asList(1, 2, 4);

        //when
        Result result = referee.judge(answer, guess);

        //then
        assertThat(result.toString()).isEqualTo("2스트라이크");
    }

    @Test
    void judge_result_when_only_ball() {
        //given
        List<Integer> guess = Arrays.asList(2, 1, 4);

        //when
        Result result = referee.judge(answer, guess);

        //then
        assertThat(result.toString()).isEqualTo("2볼");
    }

    @Test
    void judge_ball_and_strike() {
        //given
        List<Integer> guess = Arrays.asList(2, 1, 3);

        //when
        Result result = referee.judge(answer, guess);

        //then
        assertThat(result.toString()).isEqualTo("2볼 1스트라이크");
    }

    @Test
    void judge_result_when_nothing() {
        //given
        List<Integer> guess = Arrays.asList(4, 5, 6);

        //when
        Result result = referee.judge(answer, guess);

        //then
        assertThat(result.toString()).isEqualTo("낫싱");
    }
}
