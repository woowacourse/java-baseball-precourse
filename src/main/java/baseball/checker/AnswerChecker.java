package baseball.checker;

import static baseball.checker.types.EachNumberResultType.*;
import static baseball.checker.NumberChecker.*;

import baseball.checker.dtos.ResultCheckDto;
import baseball.checker.dtos.ResultIndexDto;
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
        for (int computerIndex = 0; computerIndex < NUMBERS_SIZE; computerIndex++) {
            checkStrikeOrBall(new ResultIndexDto(userIndex, computerIndex));
        }
    }

    private void checkStrikeOrBall(ResultIndexDto resultIndexDto) {
        ResultCheckDto resultCheckDto = new ResultCheckDto(players, resultIndexDto);
        EachNumberResultType type
            = StrikeOrBallChecker.resultOfEachNumber(resultCheckDto);
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
