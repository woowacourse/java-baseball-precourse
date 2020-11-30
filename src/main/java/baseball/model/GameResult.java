package baseball.model;

/**
 * 게임 결과를 기록하는 DTO
 */
public class GameResult {

    private int strike = 0;
    private int ball = 0;

    public void countStrike() {
        this.strike += 1;
    }

    public void countBall() {
        this.ball += 1;
    }

    public String getResult() {
        if (strike == 0 && ball == 0) {
            return "낫싱";
        } else if (strike == 0) {
            return ball + "볼";
        } else if (ball == 0) {
            return strike + "스트라이크";
        } else {
            return ball + "볼 " + strike + "스트라이크";
        }
    }
}
