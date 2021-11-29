package controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import model.NewGameCommand;
import view.InputView;
import view.OutputView;

public class GameSystemController {
    private final InputView inputView;
    private final OutputView outputView;
    private boolean willPlayNewGame = true;

    public GameSystemController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        GameController gameController = new GameController(inputView, outputView);
        while (willPlayNewGame) {
            gameController.playNewGame();
            outputView.showGameOver();
            checkRestart();
        }
    }

    private void checkRestart() {
        inputView.alertRestartNumberInput();
        String inputRestartValue = readLine();
        willPlayNewGame = NewGameCommand.willPlayNewGame(inputRestartValue);
    }
}
