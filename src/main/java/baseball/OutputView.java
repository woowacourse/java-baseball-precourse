package baseball;

import java.util.Map;

public class OutputView {
    private static final String STRIKE = "strike";
    private static final String BALL = "ball";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼 "; // 뒤에 스트라이크가 나올 것을 고려하여 공백 기입
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final int ZERO = 0;

    private int strikeCount;
    private int ballCount;

    OutputView(Map<String, Integer> strikeAndBall) {
        this.strikeCount = strikeAndBall.get(STRIKE);
        this.ballCount = strikeAndBall.get(BALL);
        System.out.println(printHint(strikeCount, ballCount));
    }

    public String printHint(int strikeCount, int ballCount) {
        if (strikeCount > ZERO && ballCount > ZERO) {
            return ballCount + BALL_MESSAGE + strikeCount + STRIKE_MESSAGE;
        }
        if (strikeCount > ZERO && ballCount == ZERO) {
            return strikeCount + STRIKE_MESSAGE;
        }
        if (strikeCount == ZERO && ballCount > ZERO) {
            return ballCount + BALL_MESSAGE;
        }
        return NOTHING_MESSAGE;
    }
}
