package baseball;

import java.util.Scanner;

public class RestartNumber {
    public static final String REGAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static int askRestart(Scanner scanner){
        try {
            System.out.println(REGAME_MESSAGE);
            int number = scanner.nextInt();
            if (validateInput(number)){
                return number;
            }
        } catch (IllegalArgumentException e) {
            return askRestart(scanner);
        }
        return 0;
    }

    public static boolean validateInput (int number) throws IllegalArgumentException {
        if (number < 1 || number > 2){
            throw new IllegalArgumentException();
        } else {
            return true;
        }
    }
}
