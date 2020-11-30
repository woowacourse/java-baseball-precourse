package baseball.view;

import java.util.Scanner;

public class GameView {
    private static final String PLEASE_INPUT_NUMBERS = "숫자를 입력해주세요 : ";

    private GameView() {
    }

    public static String inputNumbers(Scanner scanner) {
        System.out.print(PLEASE_INPUT_NUMBERS);
        return scanner.nextLine();
    }
}
