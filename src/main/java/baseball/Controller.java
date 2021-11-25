package baseball;

import baseball.utils.Parser;
import baseball.utils.RandomUtils;
import baseball.view.UserInput;
import camp.nextstep.edu.missionutils.Console;

public class Controller {

    Parser parser = new Parser();
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
        int userInput = getUserInput();

    }

    private int getUserInput() {
        UserInput.UserInputData();

        String input = Console.readLine();
        int inputNum = parser.userInputParser(input);

        return inputNum;
    }

    private void gameEnd() {

    }
}
