package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        List<Integer> userNumber;
        Computer computer = new Computer();
        do {
            userNumber = changeUserInputStringToList(getInput(scanner));
            OutputView outputView = new OutputView(computer.compareWithUserNumber(userNumber));
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
            input = getInput(scanner);
        }
        return input;
    }

    public static List<Integer> changeUserInputStringToList(String userInput) {
        String[] tokensOfUserInput = userInput.split("");
        List<Integer> subdividedUserInput = new ArrayList<>();
        for (String token : tokensOfUserInput) {
            subdividedUserInput.add(Integer.parseInt(token));
        }
        return subdividedUserInput;
    }
}
