package baseball;

public class Judge {

    private String rightAnswer;
    private int strike;
    private int ball;
    private boolean gameSuccess;

    Judge() {
        strike = 0;
        ball = 0;
        gameSuccess = false;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean getGameSuccess() {
        return gameSuccess;
    }

    public void initialize() {
        ball = 0;
        strike = 0;
    }

    public void setRightAnswer(final String threeDigitNum) {
        rightAnswer = threeDigitNum;
    }

    private boolean isBall(final int index, final String target) {
        char cur_char = target.charAt(index);
        if (cur_char == rightAnswer.charAt((index + 1) % 3) || cur_char == rightAnswer.charAt((index + 2) % 3)) {
            return true;
        }
        return false;
    }

    public void makeJudgement(final String target) {
        for (int i = 0; i < 3; i++) {
            char cur_digit = target.charAt(i);
            if (cur_digit == rightAnswer.charAt(i)) {
                strike++;
                continue;
            }
            if (isBall(i, target)) {
                ball++;
            }
            if (strike == 3) {
                gameSuccess = true;
            }
        }
    }
}

