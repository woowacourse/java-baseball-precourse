package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class GameSystem {

    private static final int SIG_GAME_CONTINUE = 1;
    private static final int SIG_GAME_END = 2;
    private static final String THREE_DIGIT_PATTERN = "^ddd$";

    private int signal;

    GameSystem() {
        signal = SIG_GAME_CONTINUE;
    }

    public void executeGameSystem() {
        while (signal == SIG_GAME_CONTINUE) {
            playGame();
            determineContinueGame();
        }
    }

    private void playGame() {
    }

    private String getUser3DigitNum() {
        String input3DigitNum = Console.readLine();
        if (Pattern.matches(THREE_DIGIT_PATTERN, input3DigitNum)) {
            throw new IllegalArgumentException();
        }
        return input3DigitNum;
    }

    private void determineContinueGame() {
        String users_signal = Console.readLine();
        if (users_signal.equals("2")) {
            signal = 2;
        }
        try {
            if (!users_signal.equals("1")) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            signal = 2;
        }
    }
}