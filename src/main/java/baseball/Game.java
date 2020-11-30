package baseball;

import baseball.controller.GameProcess;

public class Game {
    /* 게임를 시작하라는 명령을 하는 메서드 */
    public void start() {
        GameProcess thisGame = new GameProcess();
        thisGame.play();
    }
}
