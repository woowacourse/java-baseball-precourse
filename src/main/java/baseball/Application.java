package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        
        do {
            getInput(scanner);
        } while (true);
    }

    public static String getInput(Scanner scanner) {
        System.out.print("숫자를 입력해주세요 : ");
        String input = scanner.nextLine();

        try {
            InputValidator.validateInputIsNumber(input);
            InputValidator.validateInputLengthEqualsDigit(input);
            InputValidator.validateZero(input);
            InputValidator.validateDuplication(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getInput(scanner);
        }

        return input;
    }
}
