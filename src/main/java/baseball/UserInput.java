package baseball;

import java.util.Scanner;

public class UserInput {

    private final Scanner scanner;

    public UserInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = scanner.nextLine();
        if (!this.isValidInput(userInput)) {
            throw new IllegalArgumentException("세 자리 숫자만 입력해야 합니다. 잘못된 입력입니다.");
        }
        return Integer.parseInt(userInput);
    }

    private boolean isValidInput(String input) {
        if (input.length() != 3) {
            return false;
        }
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
