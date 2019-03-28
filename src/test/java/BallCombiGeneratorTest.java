import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class BallCombiGeneratorTest {

    private BallCombiGenerator generator;

    @Before
    public void setUp() throws Exception {
        generator = new BallCombiGenerator();
    }

    @Test
    public void testGeneratedBallCombiisAllValid() {
        int n = 100;

        for (int i = 0; i < n; i++) {
            int [] ballCombi = generator.genBallCombi();
//            System.out.println(Arrays.toString(ballCombi));
//            System.out.flush();

            boolean got = generator.isValid(ballCombi);

            Assert.assertTrue(String.format("[%d] got: %b\n", i, got), got);
        }
    }

    private int[][] genPossibleBallCombis() {
        int used[] = new int [10];

        ArrayList<int[]> combis = new ArrayList<int[]>();

        for (int p1 = 1; p1 <= 9; p1++) {
            used[p1]++;
            for (int p2 = 1; p2 <= 9; p2++) {
                if (used[p2] != 0) continue;
                used[p2]++;
                for(int p3 = 1; p3 <= 9; p3++) {
                   if (used[p3] != 0) continue;

                   // 생성해서 바로 넣는 방법이 없으려나??..
                   int [] ballCombi = {p1, p2, p3};
                   combis.add(ballCombi);
                }
                used[p2]--;
            }
            used[p1]--;
        }

        return combis.toArray(new int[combis.size()][]);
    }

    @Test
    public void testValidBallCombi() {
        // 입력
        int [][] possibleBallCombis = genPossibleBallCombis();

        for (int [] ballCombi: possibleBallCombis) {
//            System.out.println(Arrays.toString(ballCombi));
//            System.out.flush();
            boolean got = generator.isValid(ballCombi);
            Assert.assertTrue(String.format("ballCombi: %s", Arrays.toString(ballCombi)), got);
        }
    }


    @Test
    public void testInvalidBallCombi() {
        // 입력
        int [][] ballCombis = {
                {1, 1, 1, 1},
                {0, 1, 2},
                {1, 2, 2},
                {9, 9, 9},
        };

        for(int i = 0; i < ballCombis.length; i++) {
            int [] ballCombi = ballCombis[i];

            boolean got = generator.isValid(ballCombi);

            Assert.assertFalse(String.format("[%d] ", i), got);
        }
    }

    @Test
    public void testToBallCombi() {
        //
        String [] strs = {
                "hello",
                "012344",
                "adkfj",
                "023",
                "987",
                "345",
        };

        int [][] wants = {
                {},
                {},
                {},
                {},
                {9, 8, 7},
                {3, 4, 5},
        };

        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            int [] want = wants[i];

            int [] got = generator.toBallCombi(str);

            Assert.assertArrayEquals(
                    String.format("[%d] want: %s, got: %s", i, Arrays.toString(want), Arrays.toString(got)),
                    want,
                    got
            );
        }
    }
}
