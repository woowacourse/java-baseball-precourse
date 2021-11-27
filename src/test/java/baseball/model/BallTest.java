package baseball.model;

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
        computerBall = new Ball(4, 1);
    }

    @Test
    void 결과_1스트라이크() {
        Ball myBall = new Ball(4, 1);
        PlayType playType = myBall.compare(computerBall);
        assertThat(myBall.compare(computerBall)).isEqualTo(PlayType.STRIKE);
    }

    @Test
    void 결과_1볼() {
        Ball myBall = new Ball(4, 2);
        PlayType playType = myBall.compare(computerBall);
        assertThat(myBall.compare(computerBall)).isEqualTo(PlayType.BALL);
    }

    @Test
    void 결과_낫싱() {
        Ball myBall = new Ball(5, 3);
        PlayType playType = myBall.compare(computerBall);
        assertThat(myBall.compare(computerBall)).isEqualTo(PlayType.NOTHING);
    }
}
