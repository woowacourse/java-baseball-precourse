package baseball.model;

import baseball.constant.Constant;

import javax.swing.*;

public class Computer {
    private AnswerNumber computerAnswerNumber;

    public Computer() {
        computerAnswerNumber = new AnswerNumber();
    }

    public String getAnswerNumber() {
        return computerAnswerNumber.getAnswerNumber();
    }

    public static int CountingBall(String userNumber, String answerNumber) {
        int ball = Constant.BALL_INITIAL_VALUE;

        for (int i = 0; i < userNumber.length(); i++) {
            if (answerNumber.contains(Character.toString(userNumber.charAt(i)))) {
                ball += 1;
            }
        }
        return ball;
    }

    public static int CountingStrike(String userNumber, String answerNumber) {
        int strike = Constant.STRIKE_INITIAL_VALUE;

        for (char userNum : userNumber.toCharArray()) {
            if (answerNumber.indexOf(userNum) == userNumber.indexOf(userNum)) {
                strike += 1;
            }
        }
        return strike;
    }

    public int[] getHint(String userNumber) {
        int ballCount = CountingBall(userNumber, computerAnswerNumber.getAnswerNumber());
        int strikeCount = CountingStrike(userNumber, computerAnswerNumber.getAnswerNumber());
        return new int[]{ballCount - strikeCount, strikeCount};
    }
}
