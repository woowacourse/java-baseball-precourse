package baseball;

import java.util.Scanner;

public class UserInput {
    private static final String INPUT_TEXT="숫자를 입력해주세요 : ";
    public static String getNumber(Scanner scanner) {
        System.out.println(INPUT_TEXT);
        String userTrial = scanner.nextLine();
        if (InputValidator.checkInputNumber(userTrial)) {
            return userTrial;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
