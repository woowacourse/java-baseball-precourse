import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class BallCombiGenerator {

    public int[] genBallCombi() {
        Random rand = new Random();

        int [] ballPnts = IntStream.range(1, 10).toArray();

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

        int [] pntCnt = new int[10];

        for (int ballPnt: ballCombi) {
            pntCnt[ballPnt]++;
        }

        for (int ballPnt: ballCombi) {
            if (1 < pntCnt[ballPnt]) return false;
        }

        return true;
    }

    public int[] toBallCombi(String ballCombiStr) {
        if (ballCombiStr.length() != 3) return new int[0];

        int [] ballCombi = new int[3];
        for (int i = 0; i < ballCombiStr.length(); i++) {
            char ch = ballCombiStr.charAt(i);
            if (ch <= '0' || '9' < ch) return new int[0];

            ballCombi[i] = ch - '0';
        }

        return ballCombi;
    }
}
