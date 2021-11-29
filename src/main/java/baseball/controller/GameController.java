package baseball.controller;

import baseball.service.GameService;

public class GameController {
    private final GameService gameService;

    public GameController() {
        gameService = new GameService();
    }

    public void run() {
        while(gameService.checkWhetherToPlay()) {
            gamePlay();
            askGameReplay();
        }
    }

    private void gamePlay() {
        // ToDo: 1. 사용자 숫자 입력 2. 결과 출력 3. 정답이면 게임 종료
    }

    private void askGameReplay() {
        // ToDo: 1. 게임 여부 메세지 출력 2. 사용자 여부 입력 3. 여부에 따라 플레이 타입 변경
    }
}
