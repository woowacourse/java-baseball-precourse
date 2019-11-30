package Baseball;

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

    @Test
    void hit_return_balls() {
        for (int i = 0; i < 10000; i++) {
            //when
            List<Integer> balls = hitter.hit();

            //then
            assertEquals(NumberBaseballConfig.Round, balls.size());
            for (Integer ball : balls) {
                assertTrue(NumberBaseballConfig.MIN_BALL <= ball && ball <= NumberBaseballConfig.MAX_BALL);
                assertEquals(1, Collections.frequency(balls, ball));
            }
        }
    }
}