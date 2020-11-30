package baseball;

import java.util.ArrayList;
import java.util.Scanner;
import org.graalvm.compiler.nodes.spi.VirtualizableAllocation;

public class Input {

    private final static String USER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private final static String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final static String RESTART = "1";
    private final static String GAME_END = "2";
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

    public static String getRestartOrGameEnd(Scanner scanner) {
        System.out.println(RESTART_MESSAGE);
        return scanner.nextLine();
    }

    public static boolean isRestart(String message) {
        if (message.equals(RESTART)) {
            return true;
        } else if (message.equals(GAME_END)) {
            return false;
        }
        throw new IllegalArgumentException();
    }
}
