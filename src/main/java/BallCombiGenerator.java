import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import static java.lang.Integer.max;

public class BallCombiGenerator {

    public int[] genBallCombi() {
        Random rand = new Random();

        int [] ballPnts = IntStream.range(1, 10).toArray();

        // shuffle ballPnts
        for (int from = 0; from < ballPnts.length; from++) {
            int to = rand.nextInt(ballPnts.length);

            int tmp = ballPnts[from];
            ballPnts[from] = ballPnts[to];
            ballPnts[to] = tmp;
        }

        return Arrays.copyOfRange(ballPnts, 0, 3);
    }

    public boolean isValid(int[] ballCombi) {
        if (ballCombi.length != 3) return false;

        for (int i = 0; i < ballCombi.length; i++) {
            int pnt = ballCombi[i];
            if (pnt <= 0 || 10 <= pnt) return false;
        }

        // check duplicated number
        int [] pntCnt = new int[10];
        Arrays.stream(ballCombi).forEach((pnt) -> pntCnt[pnt]++);

        int maxPntCnt =  Arrays.stream(ballCombi)
                .map(pnt -> pntCnt[pnt])
                .reduce((a, b) -> max(a, b))
                .getAsInt();

        return maxPntCnt <= 1;
    }

    public int[] toBallCombi(String ballCombiStr) {
        if (ballCombiStr.length() != 3) return new int[0];

        int [] ballCombi = new int[3];
        for (int i = 0; i < ballCombiStr.length(); i++) {
            char c = ballCombiStr.charAt(i);
            if (c <= '0' || '9' < c) return new int[0];

            ballCombi[i] = c - '0';
        }

        return ballCombi;
    }
}
