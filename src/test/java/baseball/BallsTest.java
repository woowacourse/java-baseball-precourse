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
        List<Integer> ballNumbers = balls.getBalls();

        //then
        assertEquals(ballNumbers.get(0),balls.getBalls().get(0));
        assertEquals(ballNumbers.get(1),balls.getBalls().get(1));
        assertEquals(ballNumbers.get(2),balls.getBalls().get(2));
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
