package baseball;

import utils.RandomUtils;

import java.util.Arrays;

public class GameManager {
    public static final int BASEBALL_NUMBER = 3;
    public static final int BASEBALL_NUMBER_RANGE_START = 1;
    public static final int BASEBALL_NUMBER_RANGE_END = 9;

    private final int[] baseballs;
    private boolean isGameInProgress;

    public GameManager() {
        baseballs = new int[BASEBALL_NUMBER];

        createBaseballs();

        isGameInProgress = true;
    }

    public boolean isGameInProgress() {
        return isGameInProgress;
    }

    public void setGameStatus(int statusCode) {
        switch (statusCode) {
            case GameStatusCode.RESTART:
                createBaseballs();
                break;
            case GameStatusCode.EXIT:
                isGameInProgress = false;
                break;
        }
    }

    public void createBaseballs() {
        int baseballIndex = 0;

        while (baseballIndex < BASEBALL_NUMBER) {
            int randomValue = RandomUtils.nextInt(BASEBALL_NUMBER_RANGE_START, BASEBALL_NUMBER_RANGE_END);

            boolean isDifferentValue = true;

            int previouIndex = 0;

            while (previouIndex < baseballIndex) {
                if (baseballs[previouIndex] == randomValue) {
                    isDifferentValue = false;
                    break;
                }
                previouIndex += 1;
            }

            if (isDifferentValue) {
                baseballs[baseballIndex] = randomValue;

                baseballIndex += 1;
            }
        }
    }

    public int[] getBallsAndStrikes(int[] values) {
        int strikeNumber = 0;
        int ballNumber = 0;

        int baseballsIndex = 0;

        while (baseballsIndex < BASEBALL_NUMBER) {
            if (baseballs[baseballsIndex] == values[baseballsIndex]) {
                strikeNumber += 1;
            }

            baseballsIndex += 1;
        }

        for (baseballsIndex = 0; baseballsIndex < BASEBALL_NUMBER; baseballsIndex += 1) {
            for (int valueIndex = 0; valueIndex < BASEBALL_NUMBER; valueIndex += 1) {
                if (baseballsIndex == valueIndex) {
                    continue;
                }

                if (baseballs[baseballsIndex] == values[valueIndex]) {
                    ballNumber += 1;
                }
            }
        }

        return new int[]{ballNumber, strikeNumber};
    }
}
