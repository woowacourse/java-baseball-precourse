package baseball;

import static constants.BaseballMessage.*;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class BaseBallPlay {

    private static List<Integer> userNumber = new ArrayList<>();

    public static void getUserNumber() {
        System.out.println(USER_INPUT_MESSAGE);
        String userInput = Console.readLine();

        isThreeNumbers(userInput);
        userInputToUserNumber(userInput);
        System.out.println(userNumber);
    }
    private static void userInputToUserNumber(String userInput) {
        for (int i = 0; i < 3; i++) {
            userNumber.add(Character.getNumericValue(userInput.charAt(i)));
        }
    }

    private static boolean isThreeNumbers(String numbers) {
        if (numbers.length() > 3) {
            return true;
        }
        return false;
    }
}