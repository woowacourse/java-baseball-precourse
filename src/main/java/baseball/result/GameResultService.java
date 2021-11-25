package baseball.result;

import baseball.number.BaseballNumber;

public class GameResultService {

    GameResult gameResult;

    public GameResultService(GameResult gameResult) {
        this.gameResult = gameResult;
    }

    //스트라이크 개수 세기
    public void countStrike(BaseballNumber computerNumber, BaseballNumber userNumber) {
        int[] a = computerNumber.getNumber();
        int[] b = userNumber.getNumber();
        int strikes = 0;
        for (int i = 0; i < 3; i++) {
            strikes += isStrike(a[i], b[i]);
        }
        gameResult.setStrikeCount(strikes);
    }

    private int isStrike(int a, int b) {
        if (a == b) {
            return 1;
        }
        return 0;
    }

    //볼 개수 세기
    public void countBall(BaseballNumber computerNumber, BaseballNumber userNumber) {
        int[] a = computerNumber.getNumber();
        int[] b = userNumber.getNumber();
        int balls = 0;
        for (int i : a) {
            balls += isBall(i, b);
        }

        balls -= gameResult.getStrikeCount(); //Strike의 개수도 포함되어있음
        gameResult.setBallCount(balls);
    }

    private int isBall(int a, int[] b) {
        if (a == b[0]
                || a == b[1]
                || a == b[2]) {
            return 1;
        }

        return 0;
    }

    public void createResultMessage() {
        int ballCount = gameResult.getBallCount();
        int strikeCount = gameResult.getStrikeCount();
        String resultMessage = "";

        if (ballCount == 0 && strikeCount == 0) {
            resultMessage = "낫싱";
        } else if (ballCount > 0) {
            resultMessage += ballCount + "볼 ";
        }

        if (strikeCount > 0) {
            resultMessage += strikeCount + "스트라이크 ";
        }

        gameResult.setResultMessage(resultMessage);
    }
}
