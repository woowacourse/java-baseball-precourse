package baseball.service;

import baseball.constant.Constants;
import baseball.model.Record;
import baseball.view.OutputView;

public class OutputMachine {

    private OutputMachine() {
    }

    public static void print(Record record) {

        if (CountValidator.isAllStrike(record.getStrike())) {
            OutputView.showResult(Constants.ALL_STRIKE);
            return;
        }

        if (CountValidator.isNothing(record.getBall(), record.getStrike())) {
            OutputView.showResult(Constants.NOTHING);
            return;
        }

        OutputView.showResult(generateOutput(record.getBall(), record.getStrike()));
    }

    public static String generateOutput(int ballCount, int strikeCount) {
        StringBuilder stringBuilder = new StringBuilder();

        if (ballCount != Constants.VALUE_ZERO) {
            stringBuilder.append(ballCount + "볼 ");
        }

        if (strikeCount != Constants.VALUE_ZERO) {
            stringBuilder.append(strikeCount + "스트라이크");
        }

        return stringBuilder.toString();
    }
}
