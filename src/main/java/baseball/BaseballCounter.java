package baseball;

public class BaseballCounter {
    private static final int DEFAULT_MIN_COUNT = 0;
    private static final int DEFAULT_MAX_COUNT = 3;

    private int ballCounter = 0;
    private int strikeCounter = 0;

    public void ballIncreaseCounter() {
        this.ballCounter++;
    }

    public void strikeIncreaseCounter() {
        this.strikeCounter++;
    }

    public int getBallCounter() {
        return ballCounter;
    }

    public int getStrikeCounter() {
        return strikeCounter;
    }

    public boolean isNothing() {
        return ballCounter == DEFAULT_MIN_COUNT && strikeCounter == DEFAULT_MIN_COUNT;
    }

    public boolean ballCounter() {
        return ballCounter > DEFAULT_MIN_COUNT;
    }

    public boolean strikeCounter() {
        return strikeCounter > DEFAULT_MIN_COUNT && strikeCounter != DEFAULT_MAX_COUNT;
    }

    public boolean threeStrikeCounter() {
        return strikeCounter == DEFAULT_MAX_COUNT;
    }
}
