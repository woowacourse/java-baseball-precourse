package baseball;

import static constants.BaseballMessage.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;

public class BaseBallPlayer {
    private static List<Integer> userNumber = new ArrayList<>(3);

    public static void getUserNumber() {
        System.out.println(USER_INPUT_MESSAGE);
        String userInput = Console.readLine();
        userInputToUserNumber(userInput);
        System.out.println(userNumber);
    }
    private static void userInputToUserNumber(String userInput) {
        for (int i = 0; i < 3; i++) {
            userNumber.add(Character.getNumericValue(userInput.charAt(i)));
        }
    }

}