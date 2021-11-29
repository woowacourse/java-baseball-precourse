package baseball.domain;

import baseball.constants.NumberListConstraints;

public class BaseballGameTurn {

    final private String STRIKE = "스트라이크";
    final private String BALL = "볼";
    final private String NOTHING = "낫싱";

    private final String resultMessage;
    private final Boolean isGameEnded;

    public BaseballGameTurn(UserExpectation userExpectation, TargetNumber targetNumber) {
        int strikes = countStrikes(userExpectation, targetNumber);
        int balls = countBalls(userExpectation, targetNumber);
        this.resultMessage = generateResultMessage(strikes, balls);
        this.isGameEnded = strikes == NumberListConstraints.LIST_LENGTH.value();
    }

    public String getResultMessage() {
        return this.resultMessage;
    }

    private String generateResultMessage(int strikes, int balls) {
        StringBuilder msg = new StringBuilder();
        if (strikes == 0 && balls == 0) {
            return NOTHING;
        }
        if (balls != 0) {
            msg.append(balls).append(BALL);
        }
        if (strikes != 0 && balls != 0) {
            msg.append(" ");
        }
        if (strikes != 0) {
            msg.append(strikes).append(STRIKE);
        }
        return msg.toString();
    }

    private int countStrikes(UserExpectation userExpectation, TargetNumber targetNumber) {
        int strikes = 0;
        int number;

        for (int i = 0; i < NumberListConstraints.LIST_LENGTH.value(); i++) {
            number = userExpectation.getNumberInPosition(i);
            if (targetNumber.isStrike(i, number)) {
                strikes++;
            }
        }
        return strikes;
    }

    private int countBalls(UserExpectation userExpectation, TargetNumber targetNumber) {
        int balls = 0;
        int number;

        for (int i = 0; i < NumberListConstraints.LIST_LENGTH.value(); i++) {
            number = userExpectation.getNumberInPosition(i);
            if (targetNumber.isBall(i, number)) {
                balls++;
            }
        }
        return balls;
    }

    public boolean isGameEnded() {
        return this.isGameEnded;
    }
}
