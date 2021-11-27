
package baseball;

public class GameStatus {
    private final int strike_num;
    private final int ball_num;

    public GameStatus(int strike_num, int ball_num) {
        this.strike_num = strike_num;
        this.ball_num = ball_num;
    }

    public String toString() {
        String gameResult = "";

        if (strike_num == 0 && ball_num == 0) gameResult += "낫싱";
        if (ball_num > 0) gameResult = gameResult + ball_num + "볼 ";
        if (strike_num > 0) gameResult = gameResult + strike_num + "스트라이크";

        return gameResult;
    }
}
