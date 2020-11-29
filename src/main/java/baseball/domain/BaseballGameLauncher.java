package baseball.domain;

import java.util.Scanner;

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

        while (baseballGame.isGameOver()) {
            player.inputBaseballNumbers(scanner);
            baseballGame.compareBaseBallNumbers(player.getBaseballNumbers());
        }
    }

    private static void confirmGameRestart(Scanner scanner) {
        System.out.println("게임을 새로 시작하시려면 1, 종료하시려면 2를 입력하세요.");
        String confirm = scanner.nextLine();
        if (confirm.equals("1")) {
            play(scanner);
        } else if (confirm.equals("2")) {
            return;
        } else {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
        }
    }
}
