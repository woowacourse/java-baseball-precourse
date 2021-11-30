package controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import model.NewGameCommand;
import view.InputView;
import view.OutputView;

public class GameSystemController {
    private final InputView inputView;
    private final OutputView outputView;

    public GameSystemController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        GameController gameController = new GameController(inputView, outputView);
        boolean willPlayNewGame = true;
        while (willPlayNewGame) {
            gameController.playNewGame();
            outputView.showGameOver();
            willPlayNewGame = checkRestart();
        }
    }

    private boolean checkRestart() {
        inputView.alertRestartNumberInput();
        String inputRestartValue = readLine();
        return NewGameCommand.willPlayNewGame(inputRestartValue);
    }
}
