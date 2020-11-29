package baseball.domain;

import baseball.view.OutputView;

public class NumbersComparator {
    private static final int NUMBERS_LENGTH = 3;
    private static final int THREE = 3;
    private int strikeCount;
    private int ballCount;

    public void compareNumbers(String computerNumbers, String playerNumbers) {
        strikeCount = 0;
        ballCount = 0;
        countStrike(computerNumbers, playerNumbers);
        countBall(computerNumbers, playerNumbers);
        OutputView.printScoreResult(strikeCount, ballCount);
    }

    private void countStrike(String computerNumbers, String playerNumbers) {
        for (int i = 0; i < NUMBERS_LENGTH; i++) {
            if (isStrike(computerNumbers, playerNumbers, i)) {
                strikeCount++;
            }
        }
    }

    private void countBall(String computerNumbers, String playerNumbers) {
        for (int i = 0; i < NUMBERS_LENGTH; i++) {
            if (isBall(computerNumbers, playerNumbers, i)) {
                ballCount++;
            }
        }
    }

    private boolean isStrike(String computerNumbers, String playerNumbers, int index) {
        if (computerNumbers.charAt(index) == playerNumbers.charAt(index)) {
            return true;
        }
        return false;
    }

    private boolean isBall(String computerNumbers, String playerNumbers, int index) {
        if (computerNumbers.contains(String.valueOf(playerNumbers.charAt(index)))
                && computerNumbers.charAt(index) != playerNumbers.charAt(index)) {
            return true;
        }
        return false;
    }

    public boolean isStrikeThree() {
        if (strikeCount == THREE) {
            return true;
        }
        return false;
    }
}
