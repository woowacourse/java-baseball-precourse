package baseball;

import baseball.controller.GameProcess;

public class Game {
    public void start() {
        GameProcess thisGame = new GameProcess();
        thisGame.play();
    }
}
