/*
 * 야구게임의 점수를 담는 클래스.
 */

public class Scores {
    private int strike;
    private int ball;

    Scores(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    /**
     * 스트라이크값을 반환
     */
    int getStrike() {
        return strike;
    }

    /**
     * 문자열로 변환된 점수를 반환.
     *
     * @return 점수에 단위를 붙인 문자열을 반환.
     */
    String getScore() {
        StringBuilder sb = new StringBuilder();

        if (strike != 0) {
            sb.append(strike + " 스트라이크 ");
        }
        if (ball != 0) {
            sb.append(ball + "볼");
        }
        if (strike == 0 && ball == 0) {
            sb.append("낫싱");
        }

        return sb.toString();
    }
}
