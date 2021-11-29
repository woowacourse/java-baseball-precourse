package baseball.game;

import baseball.NumbersConstraints;

public class BaseballGameTurn {

    final private String STRIKE = "스트라이크";
    final private String BALL = "볼";
    final private String NOTHING = "낫싱";

    final private Integer strikes;
    final private Integer balls;

    public BaseballGameTurn(UserExpectation userExpectation, TargetNumber targetNumber) {
        this.strikes = countStrikes(userExpectation, targetNumber);
        this.balls = countBalls(userExpectation, targetNumber);
    }

    public String getResultMessage() {
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

        for (int i = 0; i < NumbersConstraints.NUMBER_LENGTH.value(); i++) {
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

        for (int i = 0; i < NumbersConstraints.NUMBER_LENGTH.value(); i++) {
            number = userExpectation.getNumberInPosition(i);
            if (targetNumber.isBall(i, number)) {
                balls++;
            }
        }
        return balls;
    }

    public boolean isNumberEqual() {
        return this.strikes == NumbersConstraints.NUMBER_LENGTH.value();
    }
}
