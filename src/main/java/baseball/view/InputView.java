package baseball.view;

import java.util.Scanner;

public class InputView {

    public static String getThreeNumbers(Scanner scanner) {
        System.out.print("숫자를 입력해주세요 : ");
        return scanner.nextLine();
    }

    public static String getRestartNumber(Scanner scanner) {
        return scanner.nextLine();
    }
}
