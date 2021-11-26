package input;

import camp.nextstep.edu.missionutils.Console;
import output.Output;

import java.util.ArrayList;
import java.util.List;

public class User {

    private static final int BALL_MAX_SIZE = 3;
    private static final char BALL_UPPER_BOUND = '9';
    private static final char BALL_LOWER_BOUND = '1';

    public static List<Integer> readUserInput() {
        Output.pleaseInput();
        String userInput = readConsole();
        checkException(userInput);
        return convertStringToList(userInput);
    }

    private static String readConsole() {
        return Console.readLine();
    }

    private static List<Integer> convertStringToList(String userInput) {
        List<Integer> userInputList = new ArrayList<>();
        userInput.chars().forEach(
                c -> userInputList.add(c - '0')
        );
        return userInputList;
    }

    public static void checkException(String userInput) {
        if (!checkSize(userInput) || !checkRange(userInput.toCharArray()))
            throw new IllegalArgumentException();
    }

    private static boolean checkRange(char[] toCharArray) {
        for (char c : toCharArray) {
            if (c > BALL_UPPER_BOUND || c < BALL_LOWER_BOUND)
                return false;
        }
        return true;
    }

    private static boolean checkSize(String userInput) {
        if (userInput.length() == BALL_MAX_SIZE)
            return true;
        return false;
    }
}
