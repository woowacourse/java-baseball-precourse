package baseball.players;

import static baseball.checker.CheckerType.*;

import baseball.checker.NumberChecker;
import baseball.players.numbers.UserNumbers;
import java.util.List;
import java.util.Scanner;

public class User {
    private final Scanner scanner;
    private final UserNumbers userNumbers;

    public User(Scanner scanner) {
        this.scanner = scanner;
        this.userNumbers = new UserNumbers();
    }

    public void getUserInput() {
        userNumbers.clear();
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = scanner.nextLine();
        userNumbers.convertToList(userInput);
        NumberChecker.isValidNumbers(userNumbers.getNumbers(), USER);
    }

    public boolean isUserWantToContinue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = scanner.nextLine();
        if (input.equals("1")) {
            return true;
        }
        if (input.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException();
    }

    public List<Integer> getUserNumbers() {
        return userNumbers.getNumbers();
    }

    public void clearNumbers() {
        userNumbers.clear();
    }
}
