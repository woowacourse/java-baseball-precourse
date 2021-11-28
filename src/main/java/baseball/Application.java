package baseball;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        BaseBallGame baseBallGame = new BaseBallGame();
        ArrayList<String> randomNumber = Computer.makeRandom();
        baseBallGame.start(randomNumber);
    }
}
