package baseball.controller;

import java.util.List;

import baseball.resource.GameMessage;
import baseball.resource.GameRule;
import baseball.service.BaseballService;
import baseball.view.InputView;
import baseball.view.OutputView;

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
        do {
            List<Integer> playerNumbers = inputView.inputPlayerNumbers();
            String result = baseballService.evaluate(playerNumbers);
            outputView.printMessageWithLine(result);
        } while (checkGameIsNotCleared());
    }

    private boolean checkGameIsNotCleared() {
        if (baseballService.isGameCleared()) {
            outputView.printMessage(GameMessage.GAME_CLEAR_MESSAGE);
            return false;
        }
        return true;
    }

    private boolean decidePlayOrStop() {
        int number = inputView.inputPlayOrStop();
        return (number == GameRule.NUMBER_GAME_PLAY);
    }

}
