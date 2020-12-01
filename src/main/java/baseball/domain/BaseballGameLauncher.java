package baseball.domain;

import baseball.view.GameView;

import java.util.Scanner;

import static baseball.domain.Status.EXECUTION;
import static baseball.domain.Status.TERMINATION;
import static baseball.view.IllegalArgumentExceptionView.PLEASE_INPUT_ONE_OR_TOW;

public class BaseballGameLauncher {

    private BaseballGameLauncher() {
    }

    public static void play(Scanner scanner) {
        playNewBaseballGame(scanner);
        while (true) {
            try {
                confirmGameRestart(scanner);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void playNewBaseballGame(Scanner scanner) {
        BaseballGame baseballGame = new BaseballGame();
        Player player = new Player();

        while (baseballGame.isExecution()) {
            player.inputBaseballNumbers(scanner);
            baseballGame.compareBaseBallNumbers(player.getBaseballNumbers());
        }
    }

    private static void confirmGameRestart(Scanner scanner) {
        String confirm = GameView.inputExecuteOrTerminate(scanner);
        if (confirm.equals(EXECUTION.toString())) {
            play(scanner);
        } else if (!confirm.equals(TERMINATION.toString())) {
            throw new IllegalArgumentException(PLEASE_INPUT_ONE_OR_TOW);
        }
    }
}
