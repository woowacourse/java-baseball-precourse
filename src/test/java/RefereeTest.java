import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class RefereeTest {

    private Referee referee;

    @Before
    public void setUp() throws Exception {
        referee = new Referee();
    }

    @Test
    public void judge_usualCases() {
        int [] ansBallCombi = {1, 2, 3};
        int [][] inpBallCombis = {
                {1, 2, 3}, // 3s, 0b
                {1, 3, 2}, // 1s, 2b
                {2, 1, 3}, // 1s, 2b
                {2, 3, 1}, // 0s, 3b
                {9, 2, 5}, // 1s, 0b
                {3, 4, 5}, // 0s, 1b
                {4, 5, 6}, // 0s, 0b
                {6, 2, 5}, // 1s, 0b
        };
        int [][] wants = {
                {3, 0},
                {1, 2},
                {1, 2},
                {0, 3},
                {1, 0},
                {0, 1},
                {0, 0},
                {1, 0},
        };

        for (int i = 0; i < wants.length; i++) {
            int [] inpBallCombi = inpBallCombis[i];
            int [] want = wants[i];

            int [] got = referee.judge(ansBallCombi, inpBallCombi);

            Assert.assertArrayEquals(String.format("[%d] want: %s, got: %s", i, Arrays.toString(want), Arrays.toString(got)),
                    want,
                    got
            );
        }
    }
}

