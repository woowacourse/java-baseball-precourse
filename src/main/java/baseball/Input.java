package baseball;

import java.util.ArrayList;
import java.util.Scanner;

public class Input {

    private final static String USER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    public static String getUserInput(Scanner scanner) {
        System.out.println(USER_INPUT_MESSAGE);
        return scanner.nextLine();
    }

    public static ArrayList<Integer> generateUserInputList(String userInput) {
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
