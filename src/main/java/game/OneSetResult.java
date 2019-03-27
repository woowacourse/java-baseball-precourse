package game;

/**
 * 한 세트의 결과를 저장하는 객체. 본 게임의 규칙에 따라 임의의 정수값 strike와 ball이 저장되어 있다.
 *
 * @see Baseball
 * @author delf
 */
public class OneSetResult {
    private final static String STRIKE_MESSAGE = " 스트라이크";
    private final static String BALL_MESSAGE = " 볼";
    private final static String NO_STRIKE_NO_BALL_MESSAGE = "낫싱";

    private int strike;
    private int ball;

    public OneSetResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    /**
     * @return 정답을 모두 맞췄는지 아닌지에 대한 여부. 즉 strike의 수가 요구조건에 충족했는지에 대한
     * 여부.
     */
    public boolean isHit() {
        return this.strike == Baseball.BASIC_NUMBER_COUNT;
    }

    /**
     * @return 결과를 표현한 적잘한 형식의 문자열. 맞춘 숫자가 없으면 "낫싱", 하나 이상이면 "n 스트라이크
     * n 볼"의 형식으로 반환한다.
     */
    @Override
    public String toString() {
        if (strike == 0 && ball == 0) {
            return NO_STRIKE_NO_BALL_MESSAGE;
        }

        StringBuilder sb = new StringBuilder();
        if (strike != 0) {
            sb.append(strike).append(STRIKE_MESSAGE);
        }
        if (ball != 0) {
            sb.append(ball).append(BALL_MESSAGE);
        }

        return sb.toString();
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
