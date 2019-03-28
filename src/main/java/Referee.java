import java.util.Arrays;
import java.util.stream.IntStream;

public class Referee {

    public int[] judge(int[] ansBallCombi, int[] inpBallCombi) {
        int[] cnt = new int[10];

        for (int ansPnt : ansBallCombi) {
            cnt[ansPnt]++;
        }

        int strikeCnt = 0;
        for (int i = 0; i < inpBallCombi.length; i++) {
            if (inpBallCombi[i] == ansBallCombi[i]) strikeCnt++;
        }

        int ballCnt = Arrays.stream(inpBallCombi)
                .map(pnt -> cnt[pnt])
                .reduce((a, b) -> a + b)
                .getAsInt()
                - strikeCnt;

        int[] judgement = {strikeCnt, ballCnt};

        return judgement;
    }
}
