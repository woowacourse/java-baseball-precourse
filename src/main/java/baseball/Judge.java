package baseball;

public class Judge {

    private String rightAnswer;
    private int strike;
    private int ball;

    Judge() {
        strike = 0;
        ball = 0;
    }

    private void setRightAnswer(final String threeDigitNum) {
        rightAnswer = threeDigitNum;
    }

    private boolean sameEachOther(final String target, final String comparator) {
        if (target.equals(comparator)) {
            return true;
        }
        return false;
    }

}

