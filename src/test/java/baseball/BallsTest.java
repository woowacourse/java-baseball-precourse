package baseball;

import baseball.model.Ball;
import baseball.model.Balls;
import baseball.model.PlayType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {

    Balls computerBalls;

    @BeforeEach
    void setUp() {
        computerBalls = new Balls(4, 6, 8);
    }

    @Test
    void 스트라이크_1() {
        Ball myBall = new Ball(4, 0);
        PlayType playType = computerBalls.play(myBall);
        assertThat(playType).isEqualTo(PlayType.STRIKE);
    }

    @Test
    void 볼_1() {
        Ball myBall = new Ball(4, 1);
        PlayType playType = computerBalls.play(myBall);
        assertThat(playType).isEqualTo(PlayType.BALL);
    }

    @Test
    void 낫싱() {
        Ball myBall = new Ball(5, 1);
        PlayType playType = computerBalls.play(myBall);
        assertThat(playType).isEqualTo(PlayType.NOTHING);
    }
}
