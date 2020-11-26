package baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class BallsTest {

    @Test
    public void insertBalls() throws Exception {
        //given
        List<BallNumber> ballList = new ArrayList<BallNumber>(
            Arrays.asList(new BallNumber(1), new BallNumber(2), new BallNumber(3)));
        Balls balls = new Balls(ballList);

        //when
        List<BallNumber> ballNumbers = balls.getBalls();

        //then
        assertEquals(ballNumbers.indexOf(ballNumbers.get(0)), balls.containAt(new BallNumber(1)));
        assertEquals(ballNumbers.indexOf(ballNumbers.get(1)), balls.containAt(new BallNumber(2)));
        assertEquals(ballNumbers.indexOf(ballNumbers.get(2)), balls.containAt(new BallNumber(3)));
    }

    @Test
    public void insertBallsThrowsIllegalArgumentException() throws Exception {
        //given
        boolean thrown = false;

        //when
        try {
            List<BallNumber> ballList = new ArrayList<BallNumber>(
                Arrays.asList(new BallNumber(1), new BallNumber(1), new BallNumber(3)));
            Balls balls = new Balls(ballList);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }

        //then
        assertEquals(true, thrown);
    }
}
