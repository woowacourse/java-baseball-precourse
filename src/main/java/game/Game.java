package game;

import camp.nextstep.edu.missionutils.Console;
import input.Computer;
import input.User;
import output.Output;

import java.util.ArrayList;
import java.util.List;

public class Game {

    static final int BASEBALL_SIZE = 3;
    static final int RESTART_NUMBER = 1;
    List<Integer> randomNumbers;
    String userInput;


    public void startGame() {
        this.randomNumbers = new ArrayList<>(Computer.extractRandomNumbers());
        runGame();
        isRestart();
    }

    private void isRestart() {
        int checkNumber = Integer.parseInt(Console.readLine());
        if (checkNumber == RESTART_NUMBER)
            startGame();
    }

    public void runGame() {
        int strike, ball;
        do {
            this.userInput = User.userInput();
            ball = countBall();
            strike = countStrike();
            Output.printResult(ball - strike, strike);
        } while (isTerminate(strike));
    }

    private int countStrike() {
        int count = 0;
        for (int i = 0; i < BASEBALL_SIZE; i++) {
            count += isMatchStrike(i);
        }
        return count;
    }

    private int isMatchStrike(int i) {
        if (randomNumbers.get(i) == userInput.charAt(i) - '0')
            return 1;
        return 0;
    }

    private int countBall() {
        int count = 0;
        for (int i = 0; i < BASEBALL_SIZE; i++) {
            count += isMatchBall(i);
        }
        return count;
    }

    private int isMatchBall(int i) {
        if (randomNumbers.contains(userInput.charAt(i) - '0'))
            return 1;
        return 0;
    }

    private boolean isTerminate(int strike) {
        if (strike == BASEBALL_SIZE) {
            return false;
        }
        return true;
    }
}
