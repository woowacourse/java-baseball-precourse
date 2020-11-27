package baseball;

public class BaseballStep {

    static final int NUMBER_COUNT = 3;
    static final int MAX_NUMBER = 9;

    private int[] randomNumbers;
    private int[] playerNumbers;
    private int strikeCount;
    private int ballCount;
    private boolean isGameEnded;

    public BaseballStep(int[] randomNumbers, int[] playerNumbers) {
        this.randomNumbers = randomNumbers;
        this.playerNumbers = playerNumbers;
        this.strikeCount = 0;
        this.ballCount = 0;
        this.isGameEnded = false;
    }

    public void compare() {
        compareStrike();
        compareBall();

        if (strikeCount == NUMBER_COUNT) {
            this.isGameEnded = true;
        }
    }

    public void compareStrike() {
        int strike = 0;
        for (int i = 0; i < NUMBER_COUNT; i++) {
            if (randomNumbers[i] == playerNumbers[i]) {
                strike++;
            }
        }

        this.strikeCount = strike;
    }

    public void compareBall() {
        boolean[] checkNumber = new boolean[MAX_NUMBER + 1];

        int ball = 0;
        for (int i = 0; i < NUMBER_COUNT; i++) {
            checkNumber[randomNumbers[i]] = true;
        }

        for (int i = 0; i < NUMBER_COUNT; i++) {
            if (randomNumbers[i] != playerNumbers[i] && checkNumber[playerNumbers[i]]) {
                ball++;
            }
        }

        this.ballCount = ball;
    }

    public boolean isGameEnded() {
        return isGameEnded;
    }

    @Override
    public String toString() {
        String gameResult = "";

        if (ballCount > 0) {
            gameResult += ballCount;
            gameResult += "볼";

            if(strikeCount > 0) {
                gameResult += " ";
            }
        }

        if (strikeCount > 0) {
            gameResult += strikeCount;
            gameResult += "스트라이크";
        }

        if (ballCount == 0 && strikeCount == 0) {
            gameResult = "낫싱";
        }

        return gameResult;
    }
}
