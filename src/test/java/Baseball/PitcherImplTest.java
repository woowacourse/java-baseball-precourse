package Baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PitcherImplTest {
    PitcherImpl pitcher;

    @BeforeEach
    void init() {
        pitcher = new PitcherImpl();
    }

    @Test
    void pitch() {
        List<Integer> balls = pitcher.pitch();
        assertEquals(3, balls.size());
    }
}