package baseball.util;

import baseball.view.OutputView;

import java.util.List;

public class OutputUtil {

    private OutputUtil() {};

    public static void printResult(List<Integer> resultNumbers) {
        int strike = resultNumbers.get(0);
        int ball = resultNumbers.get(1);

        if (strike == 3) {
            OutputView.printCorrectAnswer();
        } else if (strike == 0 && ball == 0) {
            OutputView.printNothingCorrect();
        } else if (strike == 0) {
            OutputView.printOnlyBall(ball);
        } else if (ball == 0) {
            OutputView.printOnlyStrike(strike);
        } else {
            OutputView.printStrikeAndBall(strike, ball);
        }
    }
}
