package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {

    private final Scanner scanner;
    private final NumberChecker numberChecker;
    private List<Integer> userNumbers;


    public User(Scanner scanner, NumberChecker numberChecker) {
        this.scanner = scanner;
        this.numberChecker = numberChecker;
        this.userNumbers = new ArrayList<>();
    }

    public void getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = scanner.nextLine();
        convertToList(userInput);
        numberChecker.isValidNumbers(this.userNumbers);
    }

    private void convertToList(String userInput) {
        try {
            for (char number : userInput.toCharArray()) {
                this.userNumbers.add(Integer.parseInt(String.valueOf(number)));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

}
