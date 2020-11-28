package baseball;

import java.util.Scanner;
import baseball.ExceptionChecker;

public class GamePlayer {
    String userChoice;

    static String chooseUserChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");
        String userChoice = scanner.nextLine();
        ExceptionChecker.checkException(userChoice);
        return userChoice;
    }
}
