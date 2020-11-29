package baseball;

import java.util.Scanner;
import utils.BaseballUtils;

public class BaseballRunner {

    public static boolean run(final Scanner sc) {
        int[] randomNumbers = BaseballUtils.generateRandomNumbers();

        boolean isGameEnded;
        do {
            int[] playerNumbers = BaseballUtils.getPlayerNumbers(sc);
            isGameEnded = BaseballUtils.compareNumbers(randomNumbers, playerNumbers);
        } while (!isGameEnded);

        return BaseballUtils.askRestart(sc);
    }

}
