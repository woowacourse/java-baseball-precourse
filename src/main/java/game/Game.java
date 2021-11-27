package game;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static input.Computer.extractRandomNumbers;
import static input.User.readUserInput;
import static output.Output.printResult;

public class Game {

    static final int BASEBALL_SIZE = 3;
    static final int RESTART_NUMBER = 1;
    List<Integer> randomNumbers;
    List<Integer> userInput;


    public void startGame() {
        this.randomNumbers = new ArrayList<>(extractRandomNumbers());
        runGame();
        askRestart();
    }

    private void askRestart() {
        int checkNumber = Integer.parseInt(readLine());
        if (checkNumber == RESTART_NUMBER) {
            startGame();
        }
    }

    public void runGame() {
        int strike, ball;
        do {
            this.userInput = readUserInput();
            ball = countBall();
            strike = countStrike();
            printResult(ball - strike, strike);
        } while (isTerminate(strike));
    }

    private int countStrike() {
        int count = 0;
        for (int i = 0; i < BASEBALL_SIZE; i++) {
            count += matchStrike(i);
        }
        return count;
    }

    private int matchStrike(int i) {
        if (randomNumbers.get(i) == userInput.get(i)) {
            return 1;
        }
        return 0;
    }

    private int countBall() {
        int count = 0;
        for (int i = 0; i < BASEBALL_SIZE; i++) {
            count += matchBall(i);
        }
        return count;
    }

    private int matchBall(int i) {
        if (randomNumbers.contains(userInput.get(i))) {
            return 1;
        }
        return 0;
    }

    private boolean isTerminate(int strike) {
        if (strike == BASEBALL_SIZE) {
            return false;
        }
        return true;
    }
}
