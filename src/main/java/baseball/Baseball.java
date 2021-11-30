package baseball;

public class Baseball {
    private final String targetNumber;
    private final String inputNumber;

    public final int strikeCount;
    public final int ballCount;

    public Baseball(String targetNumber, String inputNumber) {
        this.targetNumber = targetNumber;
        this.inputNumber = inputNumber;
        this.strikeCount = countStrike();
        this.ballCount = countBall();
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
}
