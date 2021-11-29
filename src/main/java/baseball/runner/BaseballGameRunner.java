package baseball.runner;

import baseball.constants.GameMessages;
import baseball.utils.GameValidator;
import baseball.utils.UserInputHandler;

public class BaseballGameRunner {

    final private static int GAME_RESTART_FlAG = 1;

    public static void runGame() {
        boolean isRunning = true;

        while (isRunning) {
            new BaseballGame().play();
            isRunning = isRestart();
        }
    }

    private static boolean isRestart() {
        int input = UserInputHandler.getNumber(
            GameMessages.PROMPT_GAME_RESTART
        );
        GameValidator.validateRestartFlag(input);
        return input == GAME_RESTART_FlAG;
    }
}
