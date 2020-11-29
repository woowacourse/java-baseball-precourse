package baseball;

import utils.RandomUtils;

public class BaseballManager {
    public static final int BASEBALL_NUMBER = 3;
    private static final int BASEBALL_NUMBER_RANGE_START = 1;
    private static final int BASEBALL_NUMBER_RANGE_END = 9;

    private final int[] randomBaseballs;

    private int[] userBaseballs;

    public BaseballManager() {
        randomBaseballs = new int[BASEBALL_NUMBER];

        createRanmdomBaseballs();
    }

    public void setUserBaseballs(int[] userBaseballs) {
        this.userBaseballs = userBaseballs;
    }

    public void createRanmdomBaseballs() {
        int baseballIndex = 0;

        while (baseballIndex < BASEBALL_NUMBER) {
            int randomValue = RandomUtils.nextInt(BASEBALL_NUMBER_RANGE_START, BASEBALL_NUMBER_RANGE_END);

            if (isContainedValue(randomValue)) {
                continue;
            }

            randomBaseballs[baseballIndex] = randomValue;

            baseballIndex += 1;
        }
    }

    private boolean isContainedValue(int randomValue) {
        for (int baseballIndex = 0; baseballIndex < BASEBALL_NUMBER; baseballIndex++) {
            if (randomBaseballs[baseballIndex] == randomValue) {
                return true;
            }
        }

        return false;
    }

    public int getBallNumber() {
        int ballNumber = 0;

        for (int userBaseballIndex = 0; userBaseballIndex < BASEBALL_NUMBER; userBaseballIndex += 1) {
            int userBaseball = userBaseballs[userBaseballIndex];

            if (isBall(userBaseballIndex, userBaseball)) {
                ballNumber += 1;
            }
        }

        return ballNumber;
    }

    private boolean isBall(int jumpedIndex, int userBaseball) {
        for (int baseBallIndex = 0; baseBallIndex < BASEBALL_NUMBER; baseBallIndex += 1) {
            if (baseBallIndex == jumpedIndex) {
                continue;
            }

            if (randomBaseballs[baseBallIndex] == userBaseball) {
                return true;
            }
        }

        return false;
    }

    public int getStrikeNumber() {
        int strikeNumber = 0;
        int baseballsIndex = 0;

        while (baseballsIndex < BASEBALL_NUMBER) {
            if (randomBaseballs[baseballsIndex] == userBaseballs[baseballsIndex]) {
                strikeNumber += 1;
            }

            baseballsIndex += 1;
        }

        return strikeNumber;
    }
}
