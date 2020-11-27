package baseball;

import java.util.ArrayList;
import java.util.Scanner;
import org.graalvm.compiler.nodes.spi.VirtualizableAllocation;

public class Input {

    private final static String USER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    ArrayList<Integer> userInput;
    NumberValidator validator = new NumberValidator(userInput);
    Scanner scanner;

    public Input(Scanner scanner) {
            userInput = getUserInput(scanner);
            validator.numbers = userInput;
        if (!validator.isValid()) {
            throw new IllegalArgumentException();
        }
    }

    public ArrayList<Integer> getUserInput(Scanner scanner) {
        System.out.print(USER_INPUT_MESSAGE);
        return generateUserInputList(scanner.nextLine());
    }

    public ArrayList<Integer> generateUserInputList(String userInput) {
        ArrayList<Integer> userInputList = new ArrayList<>();
        for (int i = 0; i < userInput.length(); i++) {
            if (!Character.isDigit(userInput.charAt(i))) {
                throw new IllegalArgumentException();
            }
            userInputList.add(Character.getNumericValue(userInput.charAt(i)));
        }
        return userInputList;
    }
}
