package baseball;

public class HintMaker {
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String ANSWER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final int SIZE_RANGE = 3;
    private static final int ZERO = 0;
    private int strikeCount;
    private int ballCount;

    public HintMaker(int strikeCount, int ballCount) {
        clear();
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public boolean isAnswer() {
        if (strikeCount == SIZE_RANGE) {
            System.out.println(ANSWER_MESSAGE);
            return true;
        }
        return false;
    }

    public void makePrintMessage() {
        StringBuilder sb = new StringBuilder();
        if (ballCount > ZERO) {
            sb.append(ballCount + BALL_MESSAGE + " ");
        }
        if (strikeCount > ZERO) {
            sb.append(strikeCount + STRIKE_MESSAGE);
        }
        if ((ballCount == ZERO) && (strikeCount == ZERO)) {
            sb.append(NOTHING_MESSAGE);
        }
        System.out.println(sb);
    }

    public void clear() {
        strikeCount = 0;
        ballCount = 0;
    }
}
