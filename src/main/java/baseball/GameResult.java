package baseball;

/**
 * 게임의 결과에 대한 정보를 가진 객체: 결과를 계산, 출력
 */
public class GameResult {

    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";

    private final Integer strike;
    private final Integer ball;

    public GameResult(Integer strike, Integer ball) {
        validateRange(strike);
        validateRange(ball);
        this.strike = strike;
        this.ball = ball;
    }

    private void validateRange(Integer i) {
        if (i < 0 || Balls.COUNT_OF_BALLS < i) {
            String msg = String.format("strike나 ball은 0~%d 사이의 수여야 합니다: %d", Balls.COUNT_OF_BALLS, i);
            throw new IllegalArgumentException(msg);
        }
    }

    public String getResult() {
        if (isNothing()) {
            return NOTHING;                                             // 낫싱
        }

        if (thereIsNoBall()) {
            return String.format("%d%s", strike, STRIKE);               // N스트라이크
        } else if (thereIsNoStrike()) {
            return String.format("%d%s", ball, BALL);                   // N볼
        }

        return String.format("%d%s %d%s", strike, STRIKE, ball, BALL);  // N스트라이크 N볼
    }

    private boolean thereIsNoStrike() {
        return strike == 0;
    }

    private boolean isNothing() {
        return strike == 0 && ball == 0;
    }

    private boolean thereIsNoBall() {
        return ball == 0;
    }

    public boolean isThreeStrikes() {
        return strike == Balls.COUNT_OF_BALLS;
    }
}