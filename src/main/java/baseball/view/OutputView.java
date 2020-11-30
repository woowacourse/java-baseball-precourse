package baseball.view;

public class OutputView {
    private static final int ZERO = 0;
    private static final String STRIKE_MESSAGE = "%d스트라이크\n";
    private static final String BALL_MESSAGE = "%d볼\n";
    private static final String STRIKE_BALL_MESSAGE = "%d스트라이크 %d볼\n";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String CORRECT_ANSWER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private OutputView() {
    }

    public static void printScoreResult(int strikeCount, int ballCount) {
        if(strikeCount == ZERO && ballCount == ZERO) {
            System.out.println(NOTHING_MESSAGE);
        }
        if (strikeCount > ZERO && ballCount == ZERO) {
            System.out.printf(STRIKE_MESSAGE, strikeCount);
        }
        if (strikeCount == ZERO && ballCount > ZERO) {
            System.out.printf(BALL_MESSAGE, ballCount);
        }
        if (strikeCount > ZERO && ballCount > ZERO) {
            System.out.printf(STRIKE_BALL_MESSAGE, strikeCount, ballCount);
        }
    }

    public static void printCorrectAnswer() {
        System.out.println(CORRECT_ANSWER_MESSAGE);
    }
}
