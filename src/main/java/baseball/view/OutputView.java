package baseball.view;

import baseball.model.BallCount;

public class OutputView {
    private static final String WINNING_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String BALL_MESSAGE_FORMAT = "%d볼 ";
    private static final String STRIKE_MESSAGE_FORMAT = "%d스트라이크 ";

    public static void showErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void showBallCount(BallCount ballCount) {
        StringBuffer stringBuffer = new StringBuffer();
        int ball = ballCount.getBall();
        int strike = ballCount.getStrike();

        if (ball != 0) {
            stringBuffer.append(String.format(BALL_MESSAGE_FORMAT, ball));
        }
        if (strike != 0) {
            stringBuffer.append(String.format(STRIKE_MESSAGE_FORMAT, strike));
        }
        if (ball == 0 && strike == 0){
            System.out.println("낫싱");
            return;
        }
        System.out.println(stringBuffer);
    }

    public static void showWinningMessage(){
        System.out.println(WINNING_MESSAGE);
    }
}
