package controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

import model.Game;
import model.NumberValidator;
import view.InputView;
import view.OutputView;

public class GameController {
    private static final String USER_INPUT_DELIMITER = "";
    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void playNewGame() {
        Game game = new Game();
        while (game.isNotOver()) {
            inputView.alertInputOfBaseballNumbers();
            List<Integer> userNumbers = NumberValidator.getValidatedNumbers(inputNumbers());
            game.tryOnce(userNumbers);
            outputView.showResult(game.getResult());
        }
    }

    private String[] inputNumbers() {
        return readLine().split(USER_INPUT_DELIMITER);
    }
}