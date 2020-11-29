package baseball.view;

import baseball.model.BallCount;

public class OutputView {

    public static void showErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void showBallCount(BallCount ballCount) {
        StringBuffer stringBuffer = new StringBuffer();
        int ball = ballCount.getBall();
        int strike = ballCount.getStrike();

        if (ball != 0) {
            stringBuffer.append(String.format("%d볼 ", ball));
        }
        if (strike != 0) {
            stringBuffer.append(String.format("%d스트라이크 ", strike));
        }
        if (ball == 0 && strike == 0){
            System.out.println("낫싱");
            return;
        }
        System.out.println(stringBuffer);
    }


}
