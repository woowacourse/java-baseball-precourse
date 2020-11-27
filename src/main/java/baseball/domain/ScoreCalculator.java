package baseball.domain;

public class ScoreCalculator {
    private ScoreCalculator() {
    }

    public static Score calculateScore(BaseballNumber answer, BaseballNumber userBaseballNumber) {
        int strike = 0;
        int ball = 0;
        for (int idx = 0; idx < BaseballNumber.COUNT_OF_DIGIT; idx++) {
            if (answer.isStrike(userBaseballNumber, idx)) {
                strike++;
                continue;
            }
            if (answer.isBall(userBaseballNumber, idx)) {
                ball++;
            }
        }
        return new Score(ball, strike);
    }
}
