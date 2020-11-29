package baseball.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallCountTest {
    @Test
    public void createBallCountTest(){
        int strike = 1;
        int ball = 1;
        //System.out.println(BallCount.createBallCount(1,1).toString());
        assertThat(BallCount.createBallCount(1,1).toString())
                .isEqualTo(String.format("Strike: %d, Ball: %d", strike, ball));
    }
}
