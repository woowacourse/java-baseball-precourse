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
}
