package baseball.checker;

import static baseball.checker.types.EachNumberResultType.*;
import static baseball.checker.NumberChecker.*;

import baseball.checker.types.EachNumberResultType;
import baseball.players.Players;

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
        for (int userIndex = 0; userIndex < NUMBERS_SIZE; userIndex++) {
            checkComputerNumbers(userIndex);
        }
    }

    private void checkComputerNumbers(int userIndex) {
        for (int comIndex = 0; comIndex < NUMBERS_SIZE; comIndex++) {
            checkStrikeOrBall(userIndex, comIndex);
        }
    }

    private void checkStrikeOrBall(int userIndex, int comIndex) {
        StrikeOrBallChecker checker
            = new StrikeOrBallChecker(players.getUser(), players.getComputer());
        EachNumberResultType type = checker.resultOfEachNumber(userIndex, comIndex);
        if (type == STRIKE) {
            result.strike();
        }
        if (type == BALL) {
            result.ball();
        }
    }

    public void printResult() {
        result.printResult();
    }

    public void clear() {
        result.clear();
    }
}
