package baseball;

import static baseball.CheckerType.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    private final Scanner scanner;
    private final List<Integer> numbers;

    public User(Scanner scanner) {
        this.scanner = scanner;
        this.numbers = new ArrayList<>();
    }

    public void getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = scanner.nextLine();
        convertToList(userInput);
        NumberChecker.isValidNumbers(numbers, USER);
    }

    private void convertToList(String userInput) {
        try {
            for (char number : userInput.toCharArray()) {
                this.numbers.add(Integer.parseInt(String.valueOf(number)));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

}
