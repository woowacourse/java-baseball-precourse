package Baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberHitterTest {
    private NumberHitter hitter;

    @BeforeEach
    void init() {
        hitter = new NumberHitter();
    }

    @Test
    void pitch() {
        List<Integer> balls = hitter.hit();
        assertEquals(NumberBaseballConfig.Round, balls.size());
    }
}