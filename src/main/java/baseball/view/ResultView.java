package baseball.view;

import baseball.vo.ResultBall;

public class ResultView {

    private static final String BALL_MESSAGE = "볼";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BETWEEN_MESSAGE = " ";
    private static final String NOTHING_MESSAGE = "낫싱";

    public static void printResultByResultBall(ResultBall resultBall) {
        int strike = resultBall.getStrike();
        int ball = resultBall.getBall();

        StringBuilder resultMessageBuilder = new StringBuilder();
        resultMessageBuilder.append(getBallMessage(ball));
        resultMessageBuilder.append(getBetweenMessage(ball, strike));
        resultMessageBuilder.append(getStrikeMessage(strike));
        resultMessageBuilder.append(getNothingMessage(ball, strike));

        System.out.println(resultMessageBuilder);
    }

    private static String getNothingMessage(int ball, int strike) {
        if ((ball == 0) && (strike == 0)) {
            return NOTHING_MESSAGE;
        }

        return "";
    }

    private static String getBallMessage(int ball) {
        if (ball == 0) {
            return "";
        }

        return ball + BALL_MESSAGE;
    }

    private static String getBetweenMessage(int ball, int strike) {
        if ((ball != 0) && (strike != 0)) {
            return BETWEEN_MESSAGE;
        }

        return "";
    }

    private static String getStrikeMessage(int strike) {
        if (strike == 0) {
            return "";
        }

        return strike + STRIKE_MESSAGE;
    }

}
