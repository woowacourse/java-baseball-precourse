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

    @Test
    public void calculateBallCountWithTest(){
        Numbers a = Numbers.from("123");
        Numbers b = Numbers.from("124");
        BallCount expected = BallCount.createBallCount(2, 0);
        BallCount result = a.calculateBallCountWith(b);
        System.out.println(result);
        assertThat(expected).isEqualTo(result);
    }
}
