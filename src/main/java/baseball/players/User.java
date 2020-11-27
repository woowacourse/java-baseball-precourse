package baseball.players;

import static baseball.checker.types.CheckerType.*;

import baseball.checker.NumberChecker;
import baseball.players.numbers.UserNumbers;
import java.util.Scanner;

public class User {
    private static final String USER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String CONTINUE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final Scanner scanner;
    private final UserNumbers userNumbers;

    public User(Scanner scanner) {
        this.scanner = scanner;
        this.userNumbers = new UserNumbers();
    }

    public void getUserInput() {
        System.out.print(USER_INPUT_MESSAGE);
        String userInput = scanner.nextLine();
        insertNewUserNumbers(userInput);
    }

    public void insertNewUserNumbers(String userInput) {
        userNumbers.clear();
        userNumbers.convertToList(userInput);
        NumberChecker.isValidNumbers(userNumbers.getNumbers(), USER);
    }

    public boolean isUserWantToContinue() {
        System.out.println(CONTINUE_MESSAGE);
        String input = scanner.nextLine();
        if (input.equals("1")) {
            return true;
        }
        if (input.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException();
    }

    public int numberIndexOf(int index) {
        return userNumbers.numberIndexOf(index);
    }

    public void clearNumbers() {
        userNumbers.clear();
    }
}
