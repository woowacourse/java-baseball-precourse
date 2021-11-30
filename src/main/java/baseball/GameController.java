package baseball;

import java.util.List;

public class GameController {
    private final Game game;
    private final InputManager inputManager;
    private final OutputManager outputManager;

    public GameController() {
        game = new Game();
        inputManager = new InputManager();
        outputManager = new OutputManager();
    }

    public void run() {
        do {
            game.start();
            playGame();

        } while (wantRestartGame());
    }

    private boolean wantRestartGame() {
        outputManager.printRestartGameOutput();

        int restartInput = inputManager.getRestartInput();

        return restartInput == 1;
    }

    private void playGame() {
        List<Integer> playerInput;
        Result result;

        do {
            playerInput = inputManager.getPlayerInput();

            result = game.tryBaseball(playerInput);
            outputManager.printResultOutput(result);

        } while (!result.isStrikeOut());

        outputManager.printEndGameOutput();
    }
}
