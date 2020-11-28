package baseball;

import java.util.Map;

public class OutputView {
    private static final String STRIKE = "strike";
    private static final String BALL = "ball";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼 "; // 뒤에 스트라이크가 나올 것을 고려하여 공백 기입
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String GAME_OVER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private static final int ZERO = 0;
    private static final int THREE_STRIKE = 3;

    private int strikeCount;
    private int ballCount;

    OutputView(Map<String, Integer> strikeAndBall) {
        this.strikeCount = strikeAndBall.get(STRIKE);
        this.ballCount = strikeAndBall.get(BALL);
    }

    public void printHint() {
        if (strikeCount > ZERO && ballCount > ZERO) {
            System.out.println(ballCount + BALL_MESSAGE + strikeCount + STRIKE_MESSAGE);
            return;
        }
        if (strikeCount > ZERO) {
            System.out.println(strikeCount + STRIKE_MESSAGE);
            return;
        }
        if (ballCount > ZERO) {
            System.out.println(ballCount + BALL_MESSAGE);
            return;
        }
        System.out.println(NOTHING_MESSAGE);
    }

    public boolean isGameOver() {
        if (strikeCount == THREE_STRIKE) {
            System.out.println(GAME_OVER_MESSAGE);
            System.out.println(RESTART_MESSAGE);
            return true;
        }
        return false;
    }
}
