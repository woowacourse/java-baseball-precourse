package baseball;

import baseball.service.Compute;
import baseball.utils.Parser;
import baseball.utils.RandomUtils;
import baseball.view.UserInput;
import camp.nextstep.edu.missionutils.Console;

public class Controller {

    Parser parser = new Parser();
    Compute compute = new Compute();
    public int[] gameNumber;

    public void run() {
        gameSet();
        gameStart();
        gameEnd();
    }

    private void gameSet() {
        gameNumber = RandomUtils.getRandomNumbers(3, 1, 9);
    }

    private void gameStart() {

        System.out.println(gameNumber[0] + "" + gameNumber[1] + "" + gameNumber[2]);
        int userNumber[] = getUserInput();
        int[] score = compute.computeScore(gameNumber, userNumber, 3);
        System.out.println(score[0] + "볼 " + score[1] + "스트라이크");
    }

    private int[] getUserInput() {
        UserInput.UserInputData();

        String input = Console.readLine();
        int inputNum[] = parser.userInputParser(input);

        return inputNum;
    }

    private void gameEnd() {

    }
}
