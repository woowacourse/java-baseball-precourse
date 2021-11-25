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



}
