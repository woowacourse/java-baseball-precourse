package precourse.baseball.number;

import precourse.baseball.Result;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberRefereeTest {

    private NumberReferee referee;
    private List<Integer> ballsHit;
    private List<Integer> ballsPitched;
    private Result result;

    private final ByteArrayOutputStream outView = new ByteArrayOutputStream();

    @BeforeEach
    void init() {
        referee = new NumberReferee();
        System.setOut(new PrintStream(outView));
    }
    @AfterEach
    void cleanUp() {
        System.setOut(null);
    }

    @Test
    void judge_return_result_3strikes_0B() {
        //given
        ballsHit = new ArrayList<>(
                Arrays.asList(1,2,3)
        );
        ballsPitched = new ArrayList<>(
                Arrays.asList(1,2,3)
        );
        result = new Result(3,0);

        //when & then
        Assertions.assertEquals(result, referee.judge(ballsHit, ballsPitched));
    }
    @Test
    void judge_return_result_2strikes_0B() {
        //given
        ballsHit = new ArrayList<>(
                Arrays.asList(1,2,3)
        );
        ballsPitched = new ArrayList<>(
                Arrays.asList(1,2,4)
        );
        result = new Result(2,0);

        //when & then
        Assertions.assertEquals(result, referee.judge(ballsHit, ballsPitched));
    }
    @Test
    void judge_return_result_1strike_0B() {
        //given
        ballsHit = new ArrayList<>(
                Arrays.asList(1,2,3)
        );
        ballsPitched = new ArrayList<>(
                Arrays.asList(1,4,5)
        );
        result = new Result(1,0);

        //when & then
        Assertions.assertEquals(result, referee.judge(ballsHit, ballsPitched));
    }
    @Test
    void judge_return_result_1strike_1B() {
        //given
        ballsHit = new ArrayList<>(
                Arrays.asList(1,2,3)
        );
        ballsPitched = new ArrayList<>(
                Arrays.asList(1,4,2)
        );
        result = new Result(1,1);

        //when & then
        Assertions.assertEquals(result, referee.judge(ballsHit, ballsPitched));
    }
    @Test
    void judge_return_result_1strike_2B() {
        //given
        ballsHit = new ArrayList<>(
                Arrays.asList(1,2,3)
        );
        ballsPitched = new ArrayList<>(
                Arrays.asList(1,3,2)
        );
        result = new Result(1,2);

        //when & then
        Assertions.assertEquals(result, referee.judge(ballsHit, ballsPitched));
    }
    @Test
    void judge_return_result_0strike_0B() {
        //given
        ballsHit = new ArrayList<>(
                Arrays.asList(1,2,3)
        );
        ballsPitched = new ArrayList<>(
                Arrays.asList(4,5,6)
        );
        result = new Result(0,0);

        //when & then
        Assertions.assertEquals(result, referee.judge(ballsHit, ballsPitched));
    }
    @Test
    void judge_return_result_0strike_1B() {
        //given
        ballsHit = new ArrayList<>(
                Arrays.asList(1,2,3)
        );
        ballsPitched = new ArrayList<>(
                Arrays.asList(4,1,5)
        );
        result = new Result(0,1);

        //when & then
        Assertions.assertEquals(result, referee.judge(ballsHit, ballsPitched));
    }
    @Test
    void judge_return_result_0strike_2B() {
        //given
        ballsHit = new ArrayList<>(
                Arrays.asList(1,2,3)
        );
        ballsPitched = new ArrayList<>(
                Arrays.asList(4,1,2)
        );
        result = new Result(0,2);

        //when & then
        Assertions.assertEquals(result, referee.judge(ballsHit, ballsPitched));
    }
    @Test
    void judge_return_result_0strike_3B() {
        //given
        ballsHit = new ArrayList<>(
                Arrays.asList(1,2,3)
        );
        ballsPitched = new ArrayList<>(
                Arrays.asList(2,3,1)
        );
        result = new Result(0,3);

        //when & then
        Assertions.assertEquals(result, referee.judge(ballsHit, ballsPitched));
    }

    @Test
    void judge_throw_InvalidParameterException_with_weird_balls() {
        //given
        List<Integer> nullBalls = null;

        //when & then
        assertThrows(InvalidParameterException.class, () -> referee.judge(nullBalls, nullBalls));

        //given
        List<Integer> tooManyBalls = new ArrayList<>(
                Arrays.asList(1,2,3,4)
        );
        List<Integer> tooShortBalls = new ArrayList<>(
                Arrays.asList(1,2)
        );

        assertThrows(InvalidParameterException.class, () -> referee.judge(tooManyBalls, tooShortBalls));
    }

    @Test
    void announce_print_when_stirkes_exist_B_exist() {
        //given
        int strikes = 1;
        int B = 2;
        Result result = new Result(strikes,B);

        //when
        referee.announce(result);

        //then
        assertEquals(String.format("%d 스트라이크 %d볼\n", strikes, B), outView.toString());
    }
    @Test
    void announce_print_when_only_strikes_exist() {
        //given
        int strikes = 1;
        Result result = new Result(strikes,0);

        //when
        referee.announce(result);

        //then
        assertEquals(String.format("%d 스트라이크\n", strikes), outView.toString());
    }
    @Test
    void announce_print_when_only_B_exist() {
        //given
        int B = 1;
        Result result = new Result(0,B);

        //when
        referee.announce(result);

        //then
        assertEquals(String.format("%d볼\n", B), outView.toString());
    }
    @Test
    void anoount_print_when_nothing() {
        //given
        Result result = new Result(0,0);

        //when
        referee.announce(result);

        //then
        assertEquals("낫싱\n", outView.toString());

    }
    @Test
    void announce_print_when_StrikeOut() {
        //given
        int strikes = 3;
        Result result = new Result(3, 0);

        //when
        referee.announce(result);

        //then
        assertEquals(String.format("%d 스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료\n", strikes), outView.toString());
    }
}