package baseball;

import baseball.utils.RandomUtils;
import baseball.view.UserInput;
import camp.nextstep.edu.missionutils.Console;

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
        UserInput.UserInputData();
        String input = Console.readLine();
        System.out.println(input);
    }

    private void gameEnd() {

    }
}
