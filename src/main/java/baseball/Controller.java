package baseball;

import baseball.utils.RandomUtils;

public class Controller {

    public int gameNumber;

    public void run() {
        gameSet();
        gameStart();
        gameEnd();
    }

    private void gameSet() {
        gameNumber = RandomUtils.getRandomNumbers(3, 1, 9);
    }

    private void gameStart() {

    }

    private void gameEnd() {

    }
}
