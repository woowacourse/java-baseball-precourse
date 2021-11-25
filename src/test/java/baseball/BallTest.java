package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 단일 Ball 테스트
 */
public class BallTest {

    Ball computerBall;

    @BeforeEach
    void setUp() {
        computerBall = new Ball(4, 0);
    }

    @Test
    void 스트라이크_1() {
        Ball myBall = new Ball(4, 0);
        PlayType playType = myBall.play(computerBall);
        assertThat(myBall.play(computerBall)).isEqualTo(PlayType.STRIKE);
    }

    @Test
    void 볼_1() {
        Ball myBall = new Ball(4, 1);
        PlayType playType = myBall.play(computerBall);
        assertThat(myBall.play(computerBall)).isEqualTo(PlayType.BALL);
    }

    @Test
    void 낫싱_1() {
        Ball myBall = new Ball(5, 1);
        PlayType playType = myBall.play(computerBall);
        assertThat(myBall.play(computerBall)).isEqualTo(PlayType.NOTHING);
    }
}
