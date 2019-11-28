package Baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberRefereeTest {

    private NumberReferee referee;
    private List<Integer> ballsPitched;
    private List<Integer> ballsHit;
    private Result result;

    @BeforeEach
    void init() {
        referee = new NumberReferee();
    }

    @Test
    void judge_return_result_3strikes_0B() {
        //given
        ballsPitched = new ArrayList<>(
                Arrays.asList(1,2,3)
        );
        ballsHit = new ArrayList<>(
                Arrays.asList(1,2,3)
        );
        result = new Result(3,0);

        //when & then
        assertEquals(result, referee.judge(ballsPitched, ballsHit));
    }
    @Test
    void judge_return_result_2strikes_0B() {
        //given
        ballsPitched = new ArrayList<>(
                Arrays.asList(1,2,3)
        );
        ballsHit = new ArrayList<>(
                Arrays.asList(1,2,4)
        );
        result = new Result(2,0);

        //when & then
        assertEquals(result, referee.judge(ballsPitched, ballsHit));
    }
    @Test
    void judge_return_result_1strike_0B() {
        //given
        ballsPitched = new ArrayList<>(
                Arrays.asList(1,2,3)
        );
        ballsHit = new ArrayList<>(
                Arrays.asList(1,4,5)
        );
        result = new Result(1,0);

        //when & then
        assertEquals(result, referee.judge(ballsPitched, ballsHit));
    }
    @Test
    void judge_return_result_1strike_1B() {
        //given
        ballsPitched = new ArrayList<>(
                Arrays.asList(1,2,3)
        );
        ballsHit = new ArrayList<>(
                Arrays.asList(1,4,2)
        );
        result = new Result(1,1);

        //when & then
        assertEquals(result, referee.judge(ballsPitched, ballsHit));
    }
    @Test
    void judge_return_result_1strike_2B() {
        //given
        ballsPitched = new ArrayList<>(
                Arrays.asList(1,2,3)
        );
        ballsHit = new ArrayList<>(
                Arrays.asList(1,3,2)
        );
        result = new Result(1,2);

        //when & then
        assertEquals(result, referee.judge(ballsPitched, ballsHit));
    }
    @Test
    void judge_return_result_0strike_0B() {
        //given
        ballsPitched = new ArrayList<>(
                Arrays.asList(1,2,3)
        );
        ballsHit = new ArrayList<>(
                Arrays.asList(4,5,6)
        );
        result = new Result(0,0);

        //when & then
        assertEquals(result, referee.judge(ballsPitched, ballsHit));
    }
    @Test
    void judge_return_result_0strike_1B() {
        //given
        ballsPitched = new ArrayList<>(
                Arrays.asList(1,2,3)
        );
        ballsHit = new ArrayList<>(
                Arrays.asList(4,1,5)
        );
        result = new Result(0,1);

        //when & then
        assertEquals(result, referee.judge(ballsPitched, ballsHit));
    }
    @Test
    void judge_return_result_0strike_2B() {
        //given
        ballsPitched = new ArrayList<>(
                Arrays.asList(1,2,3)
        );
        ballsHit = new ArrayList<>(
                Arrays.asList(4,1,2)
        );
        result = new Result(0,2);

        //when & then
        assertEquals(result, referee.judge(ballsPitched, ballsHit));
    }
    @Test
    void judge_return_result_0strike_3B() {
        //given
        ballsPitched = new ArrayList<>(
                Arrays.asList(1,2,3)
        );
        ballsHit = new ArrayList<>(
                Arrays.asList(2,3,1)
        );
        result = new Result(0,3);

        //when & then
        assertEquals(result, referee.judge(ballsPitched, ballsHit));
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
}