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
        // ToDo: 3. 정답이면 게임 종료
        gameService.createComputerAnswer();

        while (true) {
            int[] playerAnswer = gameInputView.inputAnswer();
            gameService.guessAnswer(playerAnswer);

            Hint hint = gameService.getHintForAnswer();
            gameOutputView.outputAnswerResult(hint.getStrike(), hint.getBall());

            if (hint.getStrike() == AnswerRange.DIGIT) {
                break;
            }
        }
    }

    private void askGameReplay() {
        // ToDo: 1. 게임 여부 메세지 출력 2. 사용자 여부 입력 3. 여부에 따라 플레이 타입 변경
    }
}
