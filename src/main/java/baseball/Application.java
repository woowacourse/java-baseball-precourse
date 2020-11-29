package baseball;

import java.util.HashSet;
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
        for (int i = 0; i < 3; i++) {
            System.out.println(application.playerNums[i]);
        }
    }

    private void validateInput(int input) {
        String inputString = String.valueOf(input);
        if (inputString.length() != 3) {
            throw new IllegalArgumentException("input only 3 digits");
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < inputString.length(); i++) {
            int num = Integer.valueOf(inputString.substring(i, i + 1));
            if (set.contains(num)) {
                throw new IllegalArgumentException("number duplicate");
            }

            if (num < 1 || num > 9) {
                throw new IllegalArgumentException("number range is 1 ~ 9");
            }
            set.add(num);
        }
    }

    private void inputPlayerNums(Scanner scanner) {
        int input = scanner.nextInt();
        validateInput(input);

        String[] split = String.valueOf(input).split("");
        for (int i = 0; i < playerNums.length; i++) {
            playerNums[i] = Integer.valueOf(split[i]);
        }
    }

    private void initComputerNums() {
        for (int i = 0; i < computerNums.length; i++) {
            computerNums[i] = RandomUtils.nextInt(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE);
        }
    }
}
