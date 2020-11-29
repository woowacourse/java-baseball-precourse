package baseball;

import java.util.Scanner;
import utils.RandomUtils;

public class Application {
    private static final int MIN_NUMBER_RANGE = 1;
    private static final int MAX_NUMBER_RANGE = 9;

    private int[] computerNums = new int[3];
    private int[] playerNums = new int[3];

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        Application application = new Application();
        application.initComputerNums();
        application.inputPlayerNums(scanner);
    }

    private void inputPlayerNums(Scanner scanner) {
        for (int i = 0; i < playerNums.length; i++) {
            playerNums[i] = scanner.nextInt();
        }
    }

    private void initComputerNums() {
        for (int i = 0; i < computerNums.length; i++) {
            computerNums[i] = RandomUtils.nextInt(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE);
        }
    }
}
