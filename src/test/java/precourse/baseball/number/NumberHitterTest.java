package precourse.baseball.number;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberHitterTest {
    private NumberHitter hitter;

    @BeforeEach
    void init() {
        hitter = new NumberHitter();
    }

    /** hit()에 임의의 요소가 있기 때문에 현재 10,000번 테스트하고 있습니다. */
    @Test
    void hit_return_balls() {
        for (int i = 0; i < 10000; i++) {
            //when
            List<Integer> balls = hitter.hit();

            //then
            Assertions.assertEquals(NumberBaseballConfig.ROUND, balls.size());
            for (Integer ball : balls) {
                assertTrue(NumberBaseballConfig.MIN_BALL <= ball && ball <= NumberBaseballConfig.MAX_BALL);
                assertEquals(1, Collections.frequency(balls, ball));
            }
        }
    }
}