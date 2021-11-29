package baseball;

public class BaseballGame {
    private final String targetNumber;
    private final String inputNumber;

    private final int strikeCount;
    private final int ballCount;

    public BaseballGame(String targetNumber, String inputNumber) {
        this.targetNumber = targetNumber;
        this.inputNumber = inputNumber;
        this.strikeCount = countStrike();
        this.ballCount = countBall();
    }

    public void printGameResult() {
        StringBuilder sb = new StringBuilder();

        if (ballCount > 0) {
            sb.append(formatToString(GameConstant.BALL_FORMAT, ballCount));
        }

        if (strikeCount > 0) {
            sb.append(formatToString(GameConstant.STRIKE_FORMAT, strikeCount));
        }

        if (ballCount == 0 && strikeCount == 0) {
            sb.append(GameConstant.NOTHING_STRING);
        }

        System.out.println(sb.toString());
    }

    public boolean isGameOver() {
        return strikeCount == GameConstant.THREE_STRIKE;
    }

    private int countStrike() {
        int count = 0;
        for (int i = 0; i < GameConstant.NUMBER_LENGTH; i++) {
            if (targetNumber.charAt(i) == inputNumber.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    private int countBall() {
        int count = 0;
        for (int i = 0; i < GameConstant.NUMBER_LENGTH; i++) {
            if (targetNumber.contains(inputNumber.substring(i, i + 1))
                    && targetNumber.charAt(i) != inputNumber.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    private <T> String formatToString(String format, T target) {
        return String.format(format, target);
    }
}
