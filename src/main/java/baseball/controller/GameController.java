package baseball.controller;

import baseball.model.Hint;
import baseball.service.GameService;
import baseball.util.AnswerRange;
import baseball.view.GameInputView;
import baseball.view.GameOutputView;

public class GameController {
    private final GameService gameService;
    private final GameInputView gameInputView;
    private final GameOutputView gameOutputView;

    public GameController() {
        gameService = new GameService();
        gameInputView = new GameInputView();
        gameOutputView = new GameOutputView();
    }

    public void run() {
        while (gameService.checkWhetherToPlay()) {
            gamePlay();
            askGameReplay();
        }
    }

    private void gamePlay() {
        gameService.createComputerAnswer();

        while (true) {
            int[] playerAnswer = gameInputView.inputAnswer();
            gameService.guessAnswer(playerAnswer);

            Hint hint = gameService.getHintForAnswer();
            gameOutputView.outputAnswerResult(hint.getStrike(), hint.getBall());

            if (hint.getStrike() == AnswerRange.DIGIT) {
                gameOutputView.outputCorrectAnswer();
                break;
            }
        }
    }

    private void askGameReplay() {
        // ToDo: 3. 여부에 따라 플레이 타입 변경
        int answer = gameInputView.inputAskReplay();
    }
}
