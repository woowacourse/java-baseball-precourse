package baseball;

public class BaseballGame {

    private static final String BALL_FORMAT = "%d볼 ";
    private static final String STRIKE_FORMAT = "%d스트라이크";
    private static final String NOTHING_STRING = "낫싱";

    private static final int THREE_STRIKE = 3;

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
            sb.append(formatToString(BALL_FORMAT, ballCount));
        }

        if (strikeCount > 0) {
            sb.append(formatToString(STRIKE_FORMAT, strikeCount));
        }

        if (ballCount == 0 && strikeCount == 0) {
            sb.append(NOTHING_STRING);
        }

        System.out.println(sb.toString());
    }

    public boolean isGameOver() {
        return strikeCount == THREE_STRIKE;
    }

    private int countStrike() {
        int count = 0;
        for (int i = 0; i < Computer.NUMBER_LENGTH; i++) {
            if (targetNumber.charAt(i) == inputNumber.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    private int countBall() {
        int count = 0;
        for (int i = 0; i < Computer.NUMBER_LENGTH; i++) {
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
