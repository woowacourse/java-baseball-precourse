import java.util.Arrays;
import java.util.stream.IntStream;

public class Referee {

    public int[] judge(int[] ansBallCombi, int[] inpBallCombi) {
        int[] cnt = new int[10];

        for (int ansPnt : ansBallCombi) {
            cnt[ansPnt]++;
        }

        int strikeCnt = IntStream.range(0, inpBallCombi.length)
                .map(i -> (ansBallCombi[i] == inpBallCombi[i]) ? 1 : 0)
                .reduce((a, b) -> a + b)
                .getAsInt();

        int ballCnt = Arrays.stream(inpBallCombi)
                .map(pnt -> cnt[pnt])
                .reduce((a, b) -> a + b)
                .getAsInt()
                - strikeCnt;

        int[] judgement = {strikeCnt, ballCnt};

        return judgement;
    }
}
