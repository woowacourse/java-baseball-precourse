package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class InputManager {
    private static final String PLAYER_INPUT_PATTERN = "^[0-9]{3}+$";
    private static final String RESTART_INPUT_PATTERN = "^[1-2]$";

    public static List<Integer> getPlayerInput() {
        String input = Console.readLine();
        validatePlayerInput(input);

        String[] splitInput = input.split("");

        return Arrays.stream(splitInput).map(Integer::parseInt).collect(Collectors.toList());
    }

    private static void validatePlayerInput(String input) {
        if (!Pattern.matches(PLAYER_INPUT_PATTERN, input)) {
            throw new IllegalArgumentException();
        }
    }

    public static int getRestartInput() {
        String input = Console.readLine();
        validateRestartInput(input);

        return Integer.parseInt(input);
    }

    private static void validateRestartInput(String input) {
        if (!Pattern.matches(RESTART_INPUT_PATTERN, input)) {
            throw new IllegalArgumentException();
        }
    }
}
