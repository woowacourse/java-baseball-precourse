package baseball.checker;

import static baseball.checker.NumberChecker.*;

import baseball.players.Computer;
import baseball.players.Players;
import baseball.players.User;
import java.util.List;

public class AnswerChecker {
    private final Players players;
    private final Result result;

    public AnswerChecker(Players players) {
        this.players = players;
        this.result = new Result();
    }

    public boolean isAnswer() {
        return result.isAnswer();
    }

    public void calculateResult() {
        User user = players.getUser();
        System.out.println("컴퓨터의 숫자 : " + players.getComputer().getNumbers().toString());
        List<Integer> userNumbers = user.getUserNumbers();
        for (int userIndex = 0; userIndex < BASEBALL_NUMBERS_SIZE; userIndex++) {
            int userNumber = userNumbers.get(userIndex);
            calculateStrikeOrBall(userIndex, userNumber);
        }
    }

    private void calculateStrikeOrBall(int userIndex, int userNumber) {
        Computer computer = players.getComputer();
        List<Integer> computerNumbers = computer.getNumbers();
        if (computerNumbers.get(userIndex) == userNumber) {
            result.strike();
            return;
        }
        for (int comIndex = 0; comIndex < BASEBALL_NUMBERS_SIZE; comIndex++) {
            if (computerNumbers.get(comIndex) == userNumber && comIndex != userIndex) {
                result.ball();
            }
        }
    }

    public void printResult() {
        result.printResult();
    }

    public void clearUserNumbersAndResult() {
        User user = players.getUser();
        user.clearNumbers();
        result.clearResult();
    }
}
