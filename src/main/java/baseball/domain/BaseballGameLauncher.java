package baseball.domain;

import baseball.view.GameView;

import java.util.Scanner;

import static baseball.view.IllegalArgumentExceptionView.PLEASE_INPUT_ONE_OR_TOW;

public class BaseballGameLauncher {

    public static void play(Scanner scanner) {
        playNewBaseballGame(scanner);
        try {
            confirmGameRestart(scanner);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            confirmGameRestart(scanner);
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
        GameView.printExecuteOrTerminate();
        String confirm = scanner.nextLine();
        if (confirm.equals("1")) {
            play(scanner);
        } else if (!confirm.equals("2")) {
            throw new IllegalArgumentException(PLEASE_INPUT_ONE_OR_TOW);
        }
    }
}
