package baseball;

import java.util.Scanner;

public class RestartNumber {
    public static final String REGAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static int askRestart(Scanner scanner) {
        try {
            System.out.println(REGAME_MESSAGE);
            String number = scanner.next();
            if (validateInput(number)) {
                return Integer.parseInt(number);
            }
        } catch (IllegalArgumentException e) {
            return askRestart(scanner);
        }
        return 0;
    }

    public static boolean validateInput(String number) throws IllegalArgumentException {
        if (number.equals("1") || number.equals("2")) {
            return true;
        } else {
            throw new IllegalArgumentException();
        }
    }
}