package baseball.controller;

import baseball.model.Computer;
import baseball.model.Refree;
import static baseball.model.Constants.*;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;
import java.util.Map;

public class Controller {
    Computer computer;
    Refree refree;
    List<Integer> gameAnswer;

    public Controller() {
        computer = new Computer();
        refree = new Refree();
        gameAnswer = computer.generateGameAnswer();
    }

    public void runGame() {
        boolean isThreeStrikes = false;

        while (!isThreeStrikes) {
            try {
                OutputView.printInputMsg();
                List<Integer> playerAnswer = refree.askPlayerAnswer(InputView.getPlayerInput());
                Map<String, Integer> gameResultMap = refree.compareAnswers(playerAnswer, gameAnswer);
                isThreeStrikes = refree.checkThreeStrikes(gameResultMap);
                String gameResultMsg = refree.makeGameResultMsg(gameResultMap);
                OutputView.printResultMsg(gameResultMsg);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMsg(e);
            }
        }
        OutputView.printEndMsg();
        restartOrExitGame();
    }

    private void restartOrExitGame() {
        OutputView.printAskRestartMsg();
        String playerInput = InputView.getPlayerInput();
        if (playerInput.equals(CONTINUE)) {
            Controller nextController = new Controller();
            nextController.runGame();
        }
    }
}
