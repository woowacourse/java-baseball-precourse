package baseball;

import utils.RandomUtils;

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

            if(isDifferentValue){
                baseballs[baseballIndex] = randomValue;

                baseballIndex += 1;
            }
        }
    }

    public boolean isGameInProgress() {
        return isGameInProgress;
    }

    public void setGameStatus(int statusCode) {
        switch (statusCode) {
            case GameStatusCode.RESUME:
                break;
            case GameStatusCode.RESTART:
                break;
            case GameStatusCode.EXIT:
                isGameInProgress = false;
                break;
            default:
                throw new IllegalArgumentException("재시작하고 싶으시면 1, 종료하고 싶으시면 2를 입력해주세요");
        }
    }
}
