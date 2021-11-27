package input;

import camp.nextstep.edu.missionutils.Console;
import output.Output;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static output.Output.pleaseInput;

public class User {

    private static final int BALL_MAX_SIZE = 3;
    private static final char BALL_UPPER_BOUND = '9';
    private static final char BALL_LOWER_BOUND = '1';

    public static List<Integer> readUserInput() {
        pleaseInput();
        String userInput = readLine();
        checkException(userInput);
        return convertStringToList(userInput);
    }

    private static List<Integer> convertStringToList(String userInput) {
        List<Integer> userInputList = new ArrayList<>();
        userInput.chars().forEach(
                c -> userInputList.add(c - '0')
        );
        return userInputList;
    }

    public static void checkException(String userInput) {
        if (!checkSize(userInput)) {
            throw new IllegalArgumentException("entered more " + (userInput.length() - BALL_MAX_SIZE) + " digit input values than the original input value.");
        }
        if (!checkRange(userInput.toCharArray())) {
            throw new IllegalArgumentException("exceeded the range of the input.");
        }
    }

    private static boolean checkRange(char[] toCharArray) {
        for (char c : toCharArray) {
            if (c > BALL_UPPER_BOUND || c < BALL_LOWER_BOUND) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkSize(String userInput) {
        if (userInput.length() == BALL_MAX_SIZE) {
            return true;
        }
        return false;
    }
}
