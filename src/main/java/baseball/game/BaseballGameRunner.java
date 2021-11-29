package baseball.game;

import baseball.PromptMessage;
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
            PromptMessage.RESTART_GAME_PROMPT.message()
        );
        return input == GAME_RESTART_FlAG;
    }
}
