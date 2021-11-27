package baseball.controller;

import baseball.resource.GameMessage;
import baseball.resource.GameRule;
import baseball.service.BaseballService;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class BaseballController {
    private static final InputView inputView = InputView.getInstance();
    private static final OutputView outputView = OutputView.getInstance();

    private final BaseballService baseballService;

    public BaseballController(BaseballService baseballService) {
        this.baseballService = baseballService;
    }

    public void run() {
        do {
            this.playGame();
        } while (decidePlayOrStop());
    }

    public void playGame() {
        baseballService.pickRefereeNumbers();
        List<Integer> playerNumbers;
        do {
            playerNumbers = inputView.inputPlayerNumbers();
            String result = baseballService.evaluate(playerNumbers);
            outputView.printMessageWithLine(result);
        } while (checkGameNotOver());
    }

    private boolean decidePlayOrStop() {
        int number = inputView.inputPlayOrStop();
        return (number == GameRule.NUMBER_GAME_PLAY);
    }

    private boolean checkGameNotOver() {
        if (baseballService.isGameOver()) {
            outputView.printMessage(GameMessage.GAME_CLEAR_MESSAGE);
            return false;
        }
        return true;
    }

}
