package baseball;

/**
 * Comparator.java
 * 숫자를 비교하여 Hint를 생성하는 클래스
 */
public class Comparator {
    private final static int ZERO = 0;
    private final static int ONE = 1;

    public static Hint extractHint(Number computerNumber, Number playerNumber) {
        int ball = countBall(computerNumber, playerNumber);
        int strike = countStrike(computerNumber, playerNumber);

        return new Hint(ball, strike);
    }

    private static int countBall(Number computerNumber, Number playerNumber) {
        int ball = ZERO;

        for (int i = 0; i < Number.NUMBER_LENGTH; i++) {
            for (int j = 0; j < Number.NUMBER_LENGTH; j++) {
                ball += countIfValidBall(computerNumber, playerNumber, i, j);
            }
        }

        return ball;
    }

    private static int countIfValidBall(Number computerNumber, Number playerNumber, int computerNumberDigit, int playerNumberDigit) {
        if (computerNumberDigit == playerNumberDigit) {
            return ZERO;
        }

        return countIfSameNumber(computerNumber, playerNumber, computerNumberDigit, playerNumberDigit);
    }

    private static int countIfSameNumber(Number computerNumber, Number playerNumber, int computerNumberDigit, int playerNumberDigit) {
        if(computerNumber.getNthDigit(computerNumberDigit) == playerNumber.getNthDigit(playerNumberDigit)) {
            return ONE;
        }

        return ZERO;
    }

    private static int countStrike(Number computerNumber, Number playerNumber) {
        int strike = ZERO;

        for (int i = 0; i < Number.NUMBER_LENGTH; i++) {
            if (computerNumber.getNthDigit(i) == playerNumber.getNthDigit(i)) {
                strike++;
            }
        }

        return strike;
    }
}
