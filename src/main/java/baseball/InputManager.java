package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class InputManager {

    public List<Integer> getPlayerInput() {
        String input = Console.readLine();
        validatePlayerInput(input);

        String[] splitInput = input.split("");

        return Arrays.stream(splitInput).map(Integer::parseInt).collect(Collectors.toList());
    }

    private void validatePlayerInput(String input) {
        String PLAYER_INPUT_PATTERN = "^[0-9]{3}+$";
        if (!Pattern.matches(PLAYER_INPUT_PATTERN, input)) {
            throw new IllegalArgumentException();
        }
    }

    public int getRestartInput() {
        String input = Console.readLine();
        validateRestartInput(input);

        return Integer.parseInt(input);
    }

    private void validateRestartInput(String input) {
        String RESTART_INPUT_PATTERN = "^[1-2]$";
        if (!Pattern.matches(RESTART_INPUT_PATTERN, input)) {
            throw new IllegalArgumentException();
        }
    }
}
