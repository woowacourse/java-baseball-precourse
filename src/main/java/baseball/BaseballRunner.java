package baseball;

import utils.BaseballUtils;

public class BaseballRunner {
    public static boolean run() {
        int[] randomNumbers = BaseballUtils.generateRandomNumbers();

        boolean isGameEnded;
        do {
            int[] playerNumbers = BaseballUtils.getPlayerNumbers();
            isGameEnded = BaseballUtils.compareNumbers(randomNumbers,playerNumbers);
        }while (!isGameEnded);

        return BaseballUtils.checkRestart();
    }
}
