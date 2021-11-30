package baseball;

import java.util.ArrayList;

import baseball.domain.BaseBallGame;
import baseball.domain.Computer;

public class Application {
    public static void main(String[] args) {
        BaseBallGame baseBallGame = new BaseBallGame();
        do {
            ArrayList<String> randomNumber = Computer.makeRandom();
            baseBallGame.start(randomNumber);
        } while (baseBallGame.restart());
    }
}
