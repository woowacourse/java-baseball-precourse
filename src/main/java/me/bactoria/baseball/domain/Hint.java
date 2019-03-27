package me.bactoria.baseball.domain;

import me.bactoria.baseball.Constant;
import me.bactoria.baseball.utils.IntegerUtils;

public class Hint {

    private int strikeCount = 0;
    private int ballCount = 0;

    public Hint(int answerNumber, int guessNumber) {
        calculateStrikeAndBallCounts(answerNumber, guessNumber);
    }

    private void calculateStrikeAndBallCounts(int answerNumber, int guessNumber) {
        int[] answerArray = IntegerUtils.to1DigitArray(answerNumber);
        int[] guessArray = IntegerUtils.to1DigitArray(guessNumber);

        for (int i = 1; i <= Constant.NUMBER_OF_DIGITS; i++) {
            for (int j = 1; j <= Constant.NUMBER_OF_DIGITS; j++) {
                calculateStrikeOrBall(answerArray[i - 1], i, guessArray[j - 1], j);
            }
        }
    }

    private void calculateStrikeOrBall(int answerNum, int answerDigit, int guessNum, int guessDigit) {
        if (answerNum == guessNum) {
            if (answerDigit == guessDigit) {
                strikeCount++;
            } else {
                ballCount++;
            }
        }
    }

    public String getHint() {
        StringBuilder result = new StringBuilder();

        if (strikeCount == 0 && ballCount == 0) {
            result.append("낫싱");
            return result.toString();
        }

        if (strikeCount > 0) result.append(strikeCount).append("스트라이크 ");
        if (ballCount > 0) result.append(ballCount).append("볼");

        return result.toString();
    }
}
