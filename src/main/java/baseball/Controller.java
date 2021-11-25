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

    public void run() throws IllegalArgumentException{
        gameSet();
        gameStart();
    }

    private void gameSet() {
        gameNumber = RandomUtils.getRandomNumbers(3, 1, 9);
    }

    private void gameStart() throws IllegalArgumentException{
        System.out.println(gameNumber[0]+""+gameNumber[1]+""+gameNumber[2]);
        play();
        gameOver();
    }

    private void gameOver() throws IllegalArgumentException{
        output.gameSetMessage();
        UserInput.retryMessage();
        askRetry();
    }

    private void askRetry() throws IllegalArgumentException{
        String input = Console.readLine();
        int inputNum = Integer.parseInt(input);
        if (inputNum == 0 || inputNum > 2) {
            throw new IllegalArgumentException();
        }
        if (inputNum == 1) {
            run();
        }
    }

    private void play() throws IllegalArgumentException{
        int strike = 0;
        while (strike != 3) {
            int userNumber[] = getUserNumber();
            int[] score = compute.computeScore(gameNumber, userNumber, 3);
            output.outputScore(score[0], score[1]);
            strike = score[1];
        }
    }

    private int[] getUserNumber() throws IllegalArgumentException{
        UserInput.UserInputData();

        String input = Console.readLine();
        int inputNum[] = parser.userInputParser(input);

        return inputNum;
    }
}
