package baseball.utils;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserInputHandler {

    public static List<Integer> getNumbersList(String promptMessage)
        throws IllegalArgumentException {
        String input = getUserInput(promptMessage);
        GameValidator.validateNumber(input);
        return Arrays.stream(input.split(""))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    public static String getUserInput(String promptMessage) {
        System.out.print(promptMessage);
        return Console.readLine();
    }

    public static int getNumber(String promptMessage) throws IllegalArgumentException {
        String input = getUserInput(promptMessage);
        GameValidator.validateNumber(input);
        return Integer.parseInt(input);
    }
}
