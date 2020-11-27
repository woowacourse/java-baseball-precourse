package baseball;

import baseball.domain.Computer;
import utils.InputUtils;

import java.util.List;
import java.util.Scanner;

public class Game {

    private final Scanner scanner;

    public Game(Scanner scanner) {
        this.scanner = scanner;
    }

    public void play() {

    }

    private List<Integer> getUserBaseballInput() {
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");

            String input = scanner.nextLine();

            if (!InputUtils.isDigit(input)) {
                System.out.println("※ 숫자만 입력해주세요.");
                continue;
            }

            if (!InputUtils.isInputLengthEqualsToBaseballLength(input)) {
                System.out.println("※ 3자리의 숫자를 입력해주세요.");
                continue;
            }

            if (!InputUtils.isDigitInBaseballRange(input)) {
                System.out.println("※ 1부터 9사이의 숫자만 입력해주세요.");
                continue;
            }

            return InputUtils.convertStringToIntegerList(input);
        }
    }

}
