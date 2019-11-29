package baseballgame;

import baseballgame.io.InputBaseballGame;
import baseballgame.io.OutputBaseballGame;
import baseballgame.system.BaseballGameSystem;

public class BaseballGameApplication {
    public static void main(String[] args) {
        BaseballGameSystem baseballGameSystem = new BaseballGameSystem();
        baseballGameSystem.startGame();
    }
}
