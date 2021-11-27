package baseball;

import baseball.domain.Controller;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        Controller game = new Controller();
        while (!game.isEnd()) {
            game.initGame();
            while (!game.isSameNumber()) {
                game.getUserNumber();
                game.compareNumbers();
            }
        }

    }
}
