package baseball;

import baseball.service.Compute;
import baseball.utils.Parser;
import baseball.utils.RandomUtils;
import baseball.view.UserInput;
import baseball.view.Output;
import camp.nextstep.edu.missionutils.Console;

public class Controller {

    Parser parser = new Parser();
    Compute compute = new Compute();
    Output output = new Output();
    public int[] gameNumber;

    public void run() {
        gameSet();
        gameStart();
    }

    private void gameSet() {
        gameNumber = RandomUtils.getRandomNumbers(3, 1, 9);
    }

    private void gameStart() {
        System.out.println(gameNumber[0]+""+gameNumber[1]+""+gameNumber[2]);
        int strike = 0;
        while (strike != 3) {
            int userNumber[] = getUserNumber();
            int[] score = compute.computeScore(gameNumber, userNumber, 3);
            output.outputScore(score[0], score[1]);
            strike = score[1];
        }
        output.gameSetMessage();
        UserInput.retryMessage();
        String input = Console.readLine();
        int inputNum = Integer.parseInt(input);
        if (inputNum == 0 || inputNum > 2) {
            throw new IllegalArgumentException();
        }
        if (inputNum == 1) {
            run();
        }
    }

    private int[] getUserNumber() {
        UserInput.UserInputData();

        String input = Console.readLine();
        int inputNum[] = parser.userInputParser(input);

        return inputNum;
    }
}
