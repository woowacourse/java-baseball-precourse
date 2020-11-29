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

            boolean isDifferentValue = true;

            int previouIndex = 0;

            while (previouIndex < baseballIndex) {
                if (randomBaseballs[previouIndex] == randomValue) {
                    isDifferentValue = false;
                    break;
                }
                previouIndex += 1;
            }

            if (isDifferentValue) {
                randomBaseballs[baseballIndex] = randomValue;

                baseballIndex += 1;
            }
        }
    }

    public int getBallNumber() {
        int ballNumber = 0;
        int baseballsIndex = 0;

        for (baseballsIndex = 0; baseballsIndex < BASEBALL_NUMBER; baseballsIndex += 1) {
            for (int userBaseballIndex = 0; userBaseballIndex < BASEBALL_NUMBER; userBaseballIndex += 1) {
                if (baseballsIndex == userBaseballIndex) {
                    continue;
                }

                if (randomBaseballs[baseballsIndex] == userBaseballs[userBaseballIndex]) {
                    ballNumber += 1;
                }
            }
        }

        return ballNumber;
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
