package baseball.game;

import baseball.PromptMessage;
import baseball.utils.UserInputHandler;

public class BaseballGameRunner {

    final private static int GAME_RESTART = 1;

    public static void run() {
        boolean running = true;
        BaseballGame game;

        while (running) {
            game = new BaseballGame();
            game.play();
            running = isRestart();
        }
    }

    private static boolean isRestart() {
        int input = UserInputHandler.getNumber(
            PromptMessage.RESTART_GAME_PROMPT.message()
        );
        return input == GAME_RESTART;
    }
}
