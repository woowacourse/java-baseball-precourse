package precourse.baseball.number;

import org.junit.jupiter.api.*;
import precourse.baseball.Result;

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
    @DisplayName("test judge with 3 strikes, 0 B")
    void judgeReturnResult3strikes0B() {
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
    @DisplayName("test judge with 2 strikes, 0 B")
    void judgeReturnResult2strikes0B() {
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
    @DisplayName("test judge with 1 strike, 1 B")
    void judgeReturnResult1strike0B() {
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
    @DisplayName("test judge with 1 strike, 1 B")
    void judgeReturnResult1strike1B() {
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
    @DisplayName("test judge with 1 strike, 2 B")
    void judgeReturnResult1strike2B() {
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
    @DisplayName("test judge with 0 strike, 0 B")
    void judgeReturnResult0strike0B() {
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
    @DisplayName("test judge with 0 strike, 1 B")
    void judgeReturnResult0strike1B() {
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
    @DisplayName("test judge with 0 strike, 2 B")
    void judgeReturnResult0strike2B() {
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
    @DisplayName("test judge with 0 strike, 3 B")
    void judgeReturnResult0strike3B() {
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
    @DisplayName("test judge weird balls: null, too long, too short")
    void judgeThrowInvalidParameterExceptionWithWeirdBalls() {
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
    @DisplayName("test announce when both strike and B exist")
    void announcePrintWhenStirkesExistAndBexist() {
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
    @DisplayName("test announce when only strike exists")
    void announcePrintWhenOnlyStrikesExist() {
        //given
        int strikes = 1;
        Result result = new Result(strikes,0);

        //when
        referee.announce(result);

        //then
        assertEquals(String.format("%d 스트라이크\n", strikes), outView.toString());
    }
    @Test
    @DisplayName("test announce when onlt B exists")
    void announcePrintWhenOnlyBexist() {
        //given
        int B = 1;
        Result result = new Result(0,B);

        //when
        referee.announce(result);

        //then
        assertEquals(String.format("%d볼\n", B), outView.toString());
    }
    @Test
    @DisplayName("test announce when nothing")
    void anoountPrintWhenNothing() {
        //given
        Result result = new Result(0,0);

        //when
        referee.announce(result);

        //then
        assertEquals("낫싱\n", outView.toString());

    }
    @Test
    @DisplayName("test announce when StrikeOut")
    void announcePrintWhenStrikeOut() {
        //given
        int strikes = 3;
        Result result = new Result(3, 0);

        //when
        referee.announce(result);

        //then
        assertEquals(String.format("%d 스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료\n", strikes), outView.toString());
    }
}