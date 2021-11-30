package baseball;

import java.util.List;

public class Application {
    private static final int START_GAME_VALUE = 1;
    private static final int END_GAME_VALUE = 2;

    private static final String GAME_ENDING_OUTPUT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private static final Game game = new Game();
    private static final InputManager inputManager = new InputManager();

    public static void main(String[] args) {
        int gameStatus = START_GAME_VALUE;

        while (gameStatus != END_GAME_VALUE) {
            game.start();
            playGame();

            gameStatus = restartGame();
        }
    }

    private static void playGame() {
        List<Integer> playerInput;
        Result result;

        do {
            playerInput = InputManager.getPlayerInput();

            result = game.tryBaseball(playerInput);
            System.out.println(result.toString());

        } while (!result.isStrikeOut());

        System.out.println(GAME_ENDING_OUTPUT);
    }

    private static int restartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return InputManager.getRestartInput();
    }
}

