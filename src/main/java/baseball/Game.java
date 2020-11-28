package baseball;

import utils.ThreeDigitsUtils;

public class Game {
    private final String NOTHING = "낫싱";
    private final String BALL = "볼";
    private final String STRIKE = "스트라이크";
    private int targetNumber;

    public Game(int targetNumber) {
        this.targetNumber = targetNumber;
    }

    private int countStrike(int inputNumber) {
        int[] targetArray = ThreeDigitsUtils.toIntArrayOfDigits(targetNumber);
        int[] inputArray = ThreeDigitsUtils.toIntArrayOfDigits(inputNumber);

        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (targetArray[i] == inputArray[i]) {
                count += 1;
            }
        }
        return count;
    }

    private int countOverlap(int inputNumber) {
        int[] targetArray = ThreeDigitsUtils.toIntArrayOfDigits(targetNumber);
        int[] inputArray = ThreeDigitsUtils.toIntArrayOfDigits(inputNumber);

        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (containInt(targetArray[i], inputArray)) {
                count += 1;
            }
        }
        return count;
    }

    private boolean containInt(int number, int[] Array) {
        for ( int a : Array) {
            if ( a == number) {
                return true;
            }
        }
        return false;
    }

    private String stringifyHint(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount == 0){
            return NOTHING;
        }
        String message = "";
        if (ballCount > 0) {
            message = Integer.toString(ballCount) + BALL;
        }
        if (strikeCount > 0) {
            message = message + Integer.toString(strikeCount) + STRIKE;
        }
        return message;
    }

    public String getHint(int inputNumber) {
        int strikeCount = countStrike(inputNumber);
        int ballCount = countOverlap(inputNumber) - strikeCount;
        return stringifyHint(strikeCount, ballCount);
    }

    public int getTargetNumber() {
        return targetNumber;
    }

    public boolean isCorrect(int guess) {
        return guess == targetNumber;
    }
}
