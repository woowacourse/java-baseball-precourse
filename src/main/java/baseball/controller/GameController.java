package baseball.controller;

import baseball.service.GameService;
import baseball.view.GameInputView;

public class GameController {
    private final GameService gameService;
    private final GameInputView gameInputView;

    public GameController() {
        gameService = new GameService();
        gameInputView = new GameInputView();
    }

    public void run() {
        while (gameService.checkWhetherToPlay()) {
            gamePlay();
            askGameReplay();
        }
    }

    private void gamePlay() {
        // ToDo: 2. 결과 출력 3. 정답이면 게임 종료
        int[] playerAnswer = gameInputView.inputAnswer();
        gameService.guessAnswer(playerAnswer);
    }

    private void askGameReplay() {
        // ToDo: 1. 게임 여부 메세지 출력 2. 사용자 여부 입력 3. 여부에 따라 플레이 타입 변경
    }
}
