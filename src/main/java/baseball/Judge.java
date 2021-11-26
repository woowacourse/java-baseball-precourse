package baseball;

public class Judge {

    private String rightAnswer;
    private int strike;
    private int ball;

    Judge() {
        strike = 0;
        ball = 0;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    private void setRightAnswer(final String threeDigitNum) {
        rightAnswer = threeDigitNum;
    }

    private boolean isBall(final int index, final String target) {
        char cur_char = target.charAt(index);
        if (cur_char == rightAnswer.charAt((index + 1) % 3) || cur_char == rightAnswer.charAt((index + 2) % 3)) {
            return true;
        }
        return false;
    }

    private void makeJudgement(final String target) {
        for (int i = 0; i < 3; i++) {
            char cur_digit = target.charAt(i);
            if (cur_digit == rightAnswer.charAt(i)) {
                strike++;
                continue;
            }
            if (isBall(i, target)) {
                ball++;
            }
        }
    }
}

