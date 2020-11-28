package baseball;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import java.util.Arrays;
import java.util.Scanner;
import utils.RandomUtils;

public class BaseballGame {

    private Scanner scanner;
    private final int THREE_DIGIT = 3;
    private int[] computerNumbers;
    private int[] userNumbers = new int[THREE_DIGIT];


    public BaseballGame(Scanner scanner) {
        this.scanner = scanner;
        this.computerNumbers = RandomUtils.getComputerNumbers();
        gameStart();
    }

    private void gameStart() {
        while (true) {
            getUserNumbers();
            showHints();
        }
    }

    private void getUserNumbers() {
        System.out.print("숫자를 입력해 주세요 : ");
        String numbers = scanner.nextLine().trim();
        checkValidNumbers(numbers);
        for (int i = 0; i < THREE_DIGIT; i++) {
            userNumbers[i] = numbers.charAt(i) - '0';
        }
    }

    private void showHints() {
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
