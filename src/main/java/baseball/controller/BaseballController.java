package baseball.controller;

import java.util.List;

import baseball.resource.GameRule;
import baseball.resource.message.OutputMessage;

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
            baseballService.init();
            this.playGame();
        } while (decidePlayOrStop());
    }

    public void playGame() {
        do {
            List<Integer> playerNumbers = inputView.inputPlayerNumbers();
            String result = baseballService.playGame(playerNumbers);
            outputView.printMessageWithLine(result);
        } while (checkGameIsNotCleared());
    }

    private boolean checkGameIsNotCleared() {
        if (baseballService.isGameCleared()) {
            outputView.printMessage(OutputMessage.GAME_CLEAR_MESSAGE);
            return false;
        }
        return true;
    }

    private boolean decidePlayOrStop() {
        int number = inputView.inputPlayOrStop();
        return (number == GameRule.NUMBER_GAME_PLAY);
    }

}
