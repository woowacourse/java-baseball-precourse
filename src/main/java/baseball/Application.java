package baseball;

import baseball.game.BaseballGame;
import baseball.game.ComputerBaseballGenerator;

public class Application {
    public static void main(String[] args) {
        new BaseballGame(new ComputerBaseballGenerator()).run();
    }
}
