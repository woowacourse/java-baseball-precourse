package baseball;

import java.util.Arrays;
import java.util.Scanner;
import utils.RandomUtils;

public class BaseballGame {

    private Scanner scanner;
    private final int THREE_DIGIT = 3;
    private int[] computerNumbers;


    public BaseballGame(Scanner scanner) {
        this.scanner = scanner;
        this.computerNumbers = RandomUtils.getComputerNumbers();
        getUserNumbers();
    }

    public void getUserNumbers() {
        int[] userNumbers = new int[THREE_DIGIT];
        System.out.print("숫자를 입력해 주세요 : ");
        String numbers = scanner.nextLine().trim();
        checkValidNumbers(numbers);
        System.out.println(numbers);
    }

    private void checkValidNumbers(String numbers) {
        if (numbers.length() != THREE_DIGIT) {
            throw new IllegalArgumentException("3자리를 넘어갔습니다. 3자리 숫자를 입력해 주세요.");
        }
        for (int i = 0; i < THREE_DIGIT; i++) {
            if (!Character.isDigit(numbers.charAt(i))) {
                throw new IllegalArgumentException("숫자만 입력해 주세요.");
            }

        }
    }
}
