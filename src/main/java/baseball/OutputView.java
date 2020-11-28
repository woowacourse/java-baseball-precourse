package baseball;

import java.util.Map;

public class OutputView {
    private static final String STRIKE = "strike";
    private static final String BALL = "ball";

    private int strikeCount;
    private int ballCount;

    OutputView(Map<String, Integer> strikeAndBall) {
        this.strikeCount = strikeAndBall.get(STRIKE);
        this.ballCount = strikeAndBall.get(BALL);
        System.out.println(printHint(strikeCount, ballCount));
    }

    public String printHint(int strikeCount, int ballCount) {
        if (strikeCount > 0 && ballCount > 0) {
            return ballCount + "볼 " + strikeCount + "스트라이크";
        }

        if (strikeCount > 0 && ballCount == 0) {
            return strikeCount + "스트라이크";
        }

        if (strikeCount == 0 && ballCount > 0) {
            return ballCount + "볼";
        }

        return "낫싱";
    }
}
